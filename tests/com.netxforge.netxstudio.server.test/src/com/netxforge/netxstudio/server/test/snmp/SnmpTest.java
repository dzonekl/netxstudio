package com.netxforge.netxstudio.server.test.snmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import junit.framework.TestCase;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.event.ResponseListener;
import org.snmp4j.mp.MPv3;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 * SNMP has many config options for Network Destination, Transport, Security,
 * MIB OID's etc...
 * 
 * {@linkplain http://www.manageengine.com/network-monitoring/what-is-snmp.html}
 * 
 * @author Christophe Bouhier
 * 
 */
public class SnmpTest extends TestCase {

	private static final String SNMP_AGENT_ADDRESS = "udp:176.58.103.70/161";

	@SuppressWarnings({ "rawtypes" })
	public void testSNMP() throws Exception {

		Address targetAddress = GenericAddress.parse(SNMP_AGENT_ADDRESS);

		TransportMapping transport = new DefaultUdpTransportMapping();
		Snmp snmp = new Snmp(transport);
		USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
				MPv3.createLocalEngineID()), 0);
		SecurityModels.getInstance().addSecurityModel(usm);
		transport.listen();

		// setting up target
		CommunityTarget target = new CommunityTarget();
		target.setCommunity(new OctetString("public"));
		target.setAddress(targetAddress);
		target.setRetries(2);
		target.setTimeout(1500);
		target.setVersion(SnmpConstants.version1);

		// creating PDU
		PDU pdu = new PDU();
		pdu.add(new VariableBinding(new OID(
				new int[] { 1, 3, 6, 1, 2, 1, 2,1 })));

		pdu.setType(PDU.GETNEXT);

		WaitsUntilDone waitsUntilDone = new WaitsUntilDone();
		snmp.send(pdu, target, null, waitsUntilDone);

		while (true) {
			if (waitsUntilDone.hasResponse()) {
				for (Variable v : waitsUntilDone.getResult()) {
					System.out.println("Value: " + v);
				}
				waitsUntilDone.reset();
				if (waitsUntilDone.getNext() != null) {
					OID next = waitsUntilDone.getNext();
					System.out.println("Next OID: " + next);
					pdu.clear();
					pdu.add(new VariableBinding(next));
					snmp.send(pdu, target, null, waitsUntilDone);
				}else{
					break;
				}
			}

		}
	}

	class WaitsUntilDone implements ResponseListener {

		boolean responseReceived = false;

		OID next = null;

		private List<Variable> result = new ArrayList<Variable>();

		public OID getNext() {
			return next;
		}

		public void reset() {
			responseReceived = false;
		}

		public boolean hasResponse() {
			return responseReceived;
		}

		public void onResponse(ResponseEvent event) {
			// Always cancel async request when response has been received
			// otherwise a memory leak is created! Not canceling a request
			// immediately can be useful when sending a request to a
			// broadcast
			// address.
			next = null;
			((Snmp) event.getSource()).cancel(event.getRequest(), this);
			PDU response = event.getResponse();
			Vector<? extends VariableBinding> variableBindings = response
					.getVariableBindings();
			result.clear();
			for (VariableBinding vbs : variableBindings) {
				Variable variable = vbs.getVariable();
				if (variable instanceof OID) {
					next = (OID) variable;
				} else {
					this.addResult(variable);
				}
			}
			responseReceived = true;
		}

		public synchronized List<Variable> getResult() {
			return result;
		}

		public synchronized void addResult(Variable result) {
			this.result.add(result);
		}
	}

}
