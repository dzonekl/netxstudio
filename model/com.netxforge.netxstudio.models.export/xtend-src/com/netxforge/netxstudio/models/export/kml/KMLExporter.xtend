package com.netxforge.netxstudio.models.export.kml

import com.netxforge.netxstudio.data.IDataProvider
import com.netxforge.netxstudio.operators.Node

import java.util.List

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import static extension org.eclipse.core.runtime.Status.*
import org.eclipse.core.runtime.jobs.Job

/**

 * A background job which exports network 
 * information to KML
 * 
 */
class KMLExporter {

	var IDataProvider provider
	var List<Node> nodes

	new(IDataProvider provider) {
		this.provider = provider
	}

	def go() {
		var j = new ExportJob('kml export')
		j.schedule(1000)
	}

	def set(Node... nodes) {
		this.nodes = nodes;
	}

}

class ExportJob extends Job {

	override protected run(IProgressMonitor arg0) {
		doRun
	}

	new(String name) {
		super(name)
	}

	def IStatus doRun() {
		var result = processHead()
		
		processTail()
		
		return Status::OK_STATUS
	}

	def processHead() '''
		<?xml version="1.0" encoding="UTF-8"?>
		<kml xmlns="http://www.opengis.net/kml/2.2">
	'''

	def processContent() '''
		<Placemark>
		<name>«»</name>
		<description>Attached to the ground. Intelligently places itself 
		at the height of the underlying terrain.</description>
		<Point>
		<coordinates>-122.0822035425683,37.42228990140251,0</coordinates>
		</Point>
		</Placemark>
	'''

	def processTail() '''
		</kml>
	'''
}
