package com.netxforge.netxstudio.emf.poi.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.netxforge.netxstudio.emf.poi.ui.PoiScanningService;
import com.netxforge.netxstudio.emf.teneo.TeneoService;

/**
 * 
 * @author dzonekl
 */
public class ScanningHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		if (!TeneoService.getInstance().initialized())
			return null;
		
		// Run as a job. 
		PoiScanningService.INSTANCE.go();		
		
		return null;
	}
}
