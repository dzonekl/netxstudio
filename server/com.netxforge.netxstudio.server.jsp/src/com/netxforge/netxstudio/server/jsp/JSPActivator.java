package com.netxforge.netxstudio.server.jsp;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import javax.servlet.Servlet;

import org.eclipse.equinox.http.helper.BundleEntryHttpContext;
import org.eclipse.equinox.http.helper.ContextPathServletAdaptor;
import org.eclipse.equinox.jsp.jasper.JspServlet;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.server.internal.ServerModule;

public class JSPActivator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	private ServiceTracker httpServiceTracker;
	private Injector injector;
	private static JSPActivator INSTANCE;
		
	public static final String CONTEXT_PATH = "/remote";
	
	public static JSPActivator getInstance(){
		return INSTANCE;
	}
	
	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
		
		Module om = ServerModule.getModule();
//		om = override(om).with(new JobModule());
//		om = override(om).with(new LogicModule());
		om = override(om).with(new CommonModule());
		injector = createInjector(om);
		injector.injectMembers(INSTANCE);
		
		httpServiceTracker = new HttpServiceTracker(context);
		httpServiceTracker.open();
		
	}

	public Injector getInjector(){
		return injector;
	}
	
	
	public void stop(BundleContext context) throws Exception {
		httpServiceTracker.close();
	}

	@SuppressWarnings("rawtypes")
	private class HttpServiceTracker extends ServiceTracker {

		@SuppressWarnings("unchecked")
		public HttpServiceTracker(BundleContext context) {
			super(context, HttpService.class.getName(), null);
		}

		@SuppressWarnings("unchecked")
		public Object addingService(ServiceReference reference) {
			final HttpService httpService = (HttpService) context.getService(reference);
			try {
				HttpContext commonContext = new BundleEntryHttpContext(context.getBundle(), "/web"); //$NON-NLS-1$
				httpService.registerResources(CONTEXT_PATH, "/", commonContext); //$NON-NLS-1$ //$NON-NLS-2$
				
				Servlet adaptedJspServlet = new ContextPathServletAdaptor(new JspServlet(context.getBundle(), "/web"), CONTEXT_PATH);  //$NON-NLS-1$//$NON-NLS-2$
				httpService.registerServlet(CONTEXT_PATH + "/*.jsp", adaptedJspServlet, null, commonContext); //$NON-NLS-1$
			} catch (Exception e) {
				e.printStackTrace();
			}
			return httpService;
		}

		@SuppressWarnings("unchecked")
		public void removedService(ServiceReference reference, Object service) {
			final HttpService httpService = (HttpService) service;
			httpService.unregister(CONTEXT_PATH); //$NON-NLS-1$
			httpService.unregister(CONTEXT_PATH + "/*.jsp"); //$NON-NLS-1$
			super.removedService(reference, service);
		}			
	}
}


