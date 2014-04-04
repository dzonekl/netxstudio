package com.netxforge.tests.basic

import com.netxforge.SmiInjectorProvider
import com.netxforge.smi.Module
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
//import java.io.URL 

@InjectWith(typeof(SmiInjectorProvider))
@RunWith(typeof(XtextRunner))
class SMIBasicTest {

	@Inject
	ParseHelper<Module> parser

	@Test
	def void parseDomainmodel() {
	
//	URL	url = this.getClass().getResource("/SNMPv2-SMI.txt.mib")	
	
//		val model = parser.parse("Hello xtend!")
	}

}
