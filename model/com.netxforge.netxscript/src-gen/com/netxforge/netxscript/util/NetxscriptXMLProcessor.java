/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.util;

import com.netxforge.netxscript.NetxscriptPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NetxscriptXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetxscriptXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    NetxscriptPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the NetxscriptResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new NetxscriptResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new NetxscriptResourceFactoryImpl());
    }
    return registrations;
  }

} //NetxscriptXMLProcessor
