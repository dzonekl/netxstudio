/*******************************************************************************
 * Copyright (c) May 18, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.cdo;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public interface ICDOQueries {

	public static final String CACHE_RESULTS = "cacheResults"; //$NON-NLS-1$
	public static final String SELECT_ROLES_FROM_PERSON = "select roles from Person person where person.login=:name";
	public static final String SELECT_JOBS = "from Job";
	public static final String SELECT_JOBS_WITH_METRICSOURCE = "select msjob from MetricSourceJob msjob where msjob.metricSource = :metricSource";
	public static final String SELECT_JOBS_WITH_SERVICE = "select msjob from RFSServiceMonitoringJob msjob where msjob.rFSService = :rfsService";
	public static final String SELECT_JOBS_WITH_SERVICE_REPORTING = "select msjob from RFSServiceReporterJob msjob where msjob.rFSService = :rfsService";
	public static final String SELECT_JOBS_WITH_OPERATOR_REPORTING = "select msjob from OperatorReporterJob msjob where msjob.operator = :operator";
}