package com.netxforge.netxstudio.server.test.snmp;

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
		// pdu.add(new VariableBinding(new OID(
		// new int[] { 1, 3, 6, 1, 2, 1, 1, 1 })));

		pdu.add(new VariableBinding(new OID(new int[] { 1, 3, 6 })));

		pdu.add(new VariableBinding(new OID(
				new int[] { 1, 3, 6, 1, 2, 1, 1, 2 })));

		pdu.setType(PDU.GETNEXT);

		WaitsUntilDone waitsUntilDone = new WaitsUntilDone();

		while (!waitsUntilDone.isDone()) {
			snmp.send(pdu, target, null, waitsUntilDone);
			if(waitsUntilDone.getNext() != null){
				pdu.clear();
				pdu.add(new VariableBinding(waitsUntilDone.getNext()));
			}
		}

	}

	class WaitsUntilDone implements ResponseListener {

		boolean done = false;

		OID next = null;

		public OID getNext() {
			return next;
		}

		public boolean isDone() {
			return done;
		}

		public void setDone(boolean done) {
			this.done = done;
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
			for (VariableBinding vbs : variableBindings) {
				Variable variable = vbs.getVariable();
				if (variable instanceof OID) {
					next = (OID) variable;
				}
				System.out.println(vbs);

			}
			if (next == null) {
				setDone(true);
			}
		}

	}

}
