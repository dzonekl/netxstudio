/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 * http://mindprod.com/jgloss/regex.html
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class TestSplitter {

	
	String testString = "Result Time,Granularity Period,Object Name,Reliability,\"Absolutely Average CPU occupation ratio\",\"Absolutely maximum CPU occupation ratio\",\"Process CPU congestion duration\",\"Process CPU overload duration\"";
	
	String testString2 = "2011-10-18 12:00,60,\"RTSGSN1/Process:Process No.=0, Process type=LIP, Slot No.=8, " +
			"Subrack No.=1\",Reliable,12,16,0,0a";
	
	String testString3 = "\",A,B,C\",\"E\",D";

	String testString4 = "RTSGSN1/Process:Process No.=0, Process type=LIP, Slot No.=8, Subrack No.=1";
	
	String testString5 = "RTSGSN1/RNCInfo:Label=AHMRNC03, RNCX=19";
	
	
	String QUOTED_OR_NOT = "(\".*?\"|.*?)";

	Pattern csvMatcher = Pattern.compile( "(\".*?\"|[^,]++)" , Pattern.MULTILINE | Pattern.DOTALL);

	Pattern csvSplitter = Pattern.compile( "[,(\".*?\")]++");
	
	@Test
	public void testCSVQuoted() {
		System.out.println("-------");
		testString = testString.trim();
		Matcher matcher = csvMatcher.matcher(testString);
		while (matcher.find()) {
			final int gc = matcher.groupCount();
			// group 0 is the whole pattern matched,
			// loops runs from from 0 to gc, not 0 to gc-1 as is traditional.
			for (int i = 0; i <= gc; i++) {
				System.out.println(i + " : " + matcher.group(i));
			}
		}

	}
	
	@Test
	public void testCSVQuoted2() {

		System.out.println("-------");
		Matcher matcher = csvMatcher.matcher(testString2);
		while (matcher.find()) {
			final int gc = matcher.groupCount();
			// group 0 is the whole pattern matched,
			// loops runs from from 0 to gc, not 0 to gc-1 as is traditional.
			for (int i = 0; i <= gc; i++) {
				System.out.println(i + " : " + matcher.group(i));
			}
		}
	}

	
	@Test
	public void testCSVQuoted3() {

		System.out.println("------- Quoted CSV, multiline");
		Matcher matcher = csvMatcher.matcher(testString3);
		while (matcher.find()) {
			final int gc = matcher.groupCount();
			// group 0 is the whole pattern matched,
			// loops runs from from 0 to gc, not 0 to gc-1 as is traditional.
			for (int i = 0; i <= gc; i++) {
				System.out.println(i + " : " + matcher.group(i));
			}
		}
	}

	
	@Test
	public void testCSVSplitter() {
		System.out.println("-------");
		
		String[] split = csvSplitter.split(testString2);
		for(int i = 0; i < split.length ; i++){
			System.out.println(i + ": "+ split[i]);
		}
	}
	
	/*
	 * Extracts RTSGSN1 in: 
	 * RTSGSN1/Process:Process No.=0, Process type=LIP, Slot No.=8, Subrack No.=1
	 */
	Pattern nodeIDExtractor = Pattern.compile("^(\\w+)");
	
	@Test
	public void testValueExtractor_NodeID() {
		System.out.println("------- Node ID Extractor:");
		
		int index = -1;
		Matcher matcher = nodeIDExtractor.matcher(testString4);
		if(matcher.find()) {
			index = matcher.end();
		}

		if(index != -1){
			System.out.println(testString4.substring(0,index));
		}
	}
	
	/*
	 * Extracts LIP in: 
	 * RTSGSN1/Process:Process No.=0, Process type=LIP, Slot No.=8, Subrack No.=1
	 */
	Pattern procesTypeExtractor = Pattern.compile("Process type=(LIP|LLP|SGP|GBP)");
	
	@Test
	public void testValueExtractor_ProcessType() {
		System.out.println("------- Process Type Extractor: ");
		
		Matcher matcher = procesTypeExtractor.matcher(testString4);
		if(matcher.find()) {
			int gc = matcher.groupCount();
			for (int i = 0; i <= gc; i++) {
				// Skip group 0 as usual. 
				System.out.println(i + " : " + matcher.group(i));
			}
		}
	}
	
	
	/*
	 * Extracts LIP in: 
	 * RTSGSN1/Process:Process No.=0, Process type=LIP, Slot No.=8, Subrack No.=1
	 */
	Pattern SlotNoExtractor = Pattern.compile("Slot No\\.=(\\d++)");
	
	@Test
	public void testValueExtractor_Slot() {
		System.out.println("------- Process Slot Extractor: ");
		
		Matcher matcher = SlotNoExtractor.matcher(testString4);
		if(matcher.find()) {
			int gc = matcher.groupCount();
			for (int i = 0; i <= gc; i++) {
				// Skip group 0 as usual. 
				System.out.println(i + " : " + matcher.group(i));
			}
		}
	}
	
	/*
	 * 
	 */
	Pattern RNCExtractor = Pattern.compile("Label=([a-zA-Z0-9]++),");
	
	@Test
	public void testValueExtractor_RNC() {
		System.out.println("-------RNC Extractor: ");
		
		Matcher matcher = RNCExtractor.matcher(testString5);
		if(matcher.find()) {
			int gc = matcher.groupCount();
			for (int i = 0; i <= gc; i++) {
				// Skip group 0 as usual. 
				System.out.println(i + " : " + matcher.group(i));
			}
		}
	}
	
	// Netxscript keyword patterns used for syntax highlighting. 
	
	Pattern NATIVE_EXPRESSION = Pattern.compile("(?:^'\\w*\\(\\)'$)");
	String testStringNativeExpression = "'nativeFunction()'";

	@Test
	public void testNetXScript_NativeFunction() {
		System.out.println("-------NetXScript native function: ");
		
		Matcher matcher = NATIVE_EXPRESSION.matcher(testStringNativeExpression);
		if(matcher.matches()) {
				System.out.println("matching OK");
		}else {
			System.out.println("matching NOK");
		}
	}
	
	
	
}
