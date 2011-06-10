/*******************************************************************************
 * Copyright (c) Jun 10, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import com.netxforge.csv.preference.PreferenceConstants;

/**
 * Creates a dynamic EMF model for the provided .csv file. 
 * It also populates an instance in the provided resource. 
 * The dynamic package is also accesible. 
 * 
 */
public class CSVLoadImpl implements CSVLoad {
	protected static final int BUFFER_SIZE = 200;
	protected CSVResourceImpl resource;
	protected String resourceID = "";
	// CB TODO REMOVE
//	protected InputStream is;
	protected Map<?, ?> options;
	
	// CB TODO REMOVE>
//	protected boolean namespaceAware;
	
	protected EPackage csvPackage; // Our dynamic package.
	
	
	/**
	 * @return the csvPackage
	 */
	public EPackage getCSVPackage() {
		return csvPackage;
	}

	public CSVLoadImpl() {
	}

	protected void handleErrors() throws IOException {
		if (!resource.getErrors().isEmpty()) {
			Resource.Diagnostic error = resource.getErrors().get(0);
			if (error instanceof Exception) {
				throw new Resource.IOWrappedException((Exception) error);
			} else {
				throw new IOException(error.getMessage());
			}
		}
	}

	/**
	 * Start parsing. Builds a dynamic EMF model from the received resource URI
	 * (EClass) and headers (EAttribute's).
	 * 
	 * TODO: For now the EType on attributes is always an EString.
	 * 
	 * TODO: The new model needs to be registered in?
	 * (It's not registered in runtime, because not used in runtime).
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void load(CSVResourceImpl resource, InputStream inputStream,
			Map<?, ?> options) throws IOException {

		this.resource = resource;
		
		resource.eAdapters().add(new CSVLoadAdapter());
		
		InputStreamReader reader = new InputStreamReader(inputStream);

		
		String delimiter = Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_DELIMETER);
		CsvPreference pref = PreferenceConstants
		.getPreference(delimiter);
		
		// de-serializer to dynamic EMF.
		ICsvListReader inFile = new CsvListReader(reader, pref);
		final String[] header = inFile.getCSVHeader(true);

		// The resource start form a fixed position.
		if (Activator.getDefault().isDebugging()) {

			for (int i = 0; i < header.length; i++) {
				System.out.println(header[i]);
			}
		}

		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		
		EClass headerClass = ecoreFactory.createEClass();
		headerClass.setName("header");
		
		EClass rowClass = ecoreFactory.createEClass();
		
		String name = this.getResourceID();
		//Encode the file name, strip .csv
		name = URI.encodeSegment(name, false).toUpperCase();
		name = "csv";
		
		rowClass.setName("row"); 
		// build attributes from the headers.
		for (int i = 0; i < header.length; i++) {
			EAttribute nextA = ecoreFactory.createEAttribute();
			nextA.setName(header[i]); // Chances to it an empty header?
			nextA.setEType(EcorePackage.Literals.ESTRING);
			rowClass.getEStructuralFeatures().add(nextA);
		}
		
		// a containment for rows
		EReference rowFeature = ecoreFactory.createEReference();
		rowFeature.setName("row");
		rowFeature.setEType(rowClass);
		rowFeature.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		rowFeature.setContainment(true);
		headerClass.getEStructuralFeatures().add(rowFeature);

		// We are done generating our package content. Now create the package.
		// The NS URI is set to the file name. 
		csvPackage = ecoreFactory.createEPackage();
		csvPackage.setName(name);
		csvPackage.setNsPrefix(name);
		csvPackage
				.setNsURI("http://www.netxforge.com/" + name);
		csvPackage.getEClassifiers().add(headerClass);
		csvPackage.getEClassifiers().add(rowClass);
		
		
		// Now let's create an instance and populate our package!
		List<String> list;
		EObject headerObject = csvPackage.getEFactoryInstance().create(headerClass);
		resource.getContents().add(headerObject);
		
		while ((list = inFile.read()) != null) {
			// We have a new entry.
			EObject rowObject = csvPackage.getEFactoryInstance().create(rowClass);
			for (int i = 0; i < list.size() ; i++) {
				String data = list.get(i);
				EStructuralFeature feature = rowClass.getEAllStructuralFeatures().get(i);
				if(feature instanceof EAttribute){
					rowObject.eSet(feature, data);
				}
				if (Activator.getDefault().isDebugging()) {
					System.out.println(data);
				}
			}
			((List)headerObject.eGet(rowFeature)).add(rowObject);
		}
		// the data is now loaded in our resource as EMF. 
	}
	
	
	/**
	 * We are interested in what happens on our resource. 
	 * @author dzonekl
	 */
	class CSVLoadAdapter extends EContentAdapter{

		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			System.out.println(notification.toString());
		}
		
	} 
	

	
	//  TODO remove. (NOT USED). 
//	protected byte[] readBuffer() throws IOException {
//		if (is.available() == 0) {
//			return new byte[0];
//		}
//
//		byte[] buffer = new byte[BUFFER_SIZE];
//		is.mark(BUFFER_SIZE);
//		int bytesRead = is.read(buffer, 0, BUFFER_SIZE);
//		int totalBytesRead = bytesRead;
//
//		while (bytesRead != -1 && (totalBytesRead < BUFFER_SIZE)) {
//			bytesRead = is.read(buffer, totalBytesRead, BUFFER_SIZE
//					- totalBytesRead);
//
//			if (bytesRead != -1)
//				totalBytesRead += bytesRead;
//		}
//
//		if (totalBytesRead < 0) {
//			buffer = new byte[0];
//		} else if (totalBytesRead < BUFFER_SIZE) {
//			byte[] smallerBuffer = new byte[totalBytesRead];
//			System.arraycopy(buffer, 0, smallerBuffer, 0, totalBytesRead);
//			buffer = smallerBuffer;
//		}
//
//		is.reset();
//		return buffer;
//	}

	/**
	 * Get an identifier (Once!) from the URI, this is the last segment of the
	 * URI.
	 * 
	 * @return
	 */
	public String getResourceID() {
		assert resource != null : "The CSV resource is not initiated";
		URI uri = this.resource.getURI();
		if (resourceID.isEmpty()) {

			if (Activator.getDefault().isDebugging()) {
				List<String> segments = uri.segmentsList();
				for (String string : segments) {
					System.out.println("segment: " + string);
				}
			}
			resourceID = uri.lastSegment();
			return resourceID;
			// fancy to extract the last segment.
		} else
			return resourceID;

	}
}
