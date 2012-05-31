package com.netxforge.netxstudio.server.test.snmp;

import junit.framework.TestCase;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpTest extends TestCase {

	public void testSNMP() throws Exception {

		Address targetAddress = GenericAddress.parse("udp:127.0.0.1/161");
		TransportMapping transport = new DefaultUdpTransportMapping();
		Snmp snmp = new Snmp(transport);
		USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
				MPv3.createLocalEngineID()), 0);
		SecurityModels.getInstance().addSecurityModel(usm);
		transport.listen();

		CommandResponder trapPrinter = new CommandResponder() {
			public synchronized void processPdu(CommandResponderEvent e) {
				PDU command = e.getPDU();
				if (command != null) {
					System.out.println(command.toString());
				}
			}
		};
		snmp.addCommandResponder(trapPrinter);
		
		while(true){
			this.wait(5000);
		}
		
		
	}

}
