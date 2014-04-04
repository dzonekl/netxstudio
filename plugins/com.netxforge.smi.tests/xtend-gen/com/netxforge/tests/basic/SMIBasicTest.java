package com.netxforge.tests.basic;

import com.netxforge.SmiInjectorProvider;
import com.netxforge.smi.Module;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = SmiInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class SMIBasicTest {
  /* @Inject
   */private ParseHelper<Module> parser;
  
  @Test
  public void parseDomainmodel() {
  }
}
