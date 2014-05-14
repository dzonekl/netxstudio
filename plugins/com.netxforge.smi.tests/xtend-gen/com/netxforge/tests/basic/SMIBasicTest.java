package com.netxforge.tests.basic;

import com.netxforge.SmiInjectorProvider;
import com.netxforge.smi.Module;
import javax.inject.Inject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(SmiInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class SMIBasicTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Test
  public void parseDomainmodel() {
  }
}
