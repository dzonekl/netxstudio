/*
* generated by Xtext
*/
package com.netxforge.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.Parameter;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class NetxscriptLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public NetxscriptLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	//Labels and icons can be computed like this:
	
	String text(Parameter ele) {
	  return ele.getName() +
	  		"\n" +
	  		"\n value = " + ele.getValue();
	}
/*	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
