/*******************************************************************************
 * Copyright (c) 24 mrt. 2013 NetXForge.
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
package com.netxforge.gis;

import java.util.List;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Site;

//import de.bacin.geoff.Geoff;
//import de.bacin.geoff.LatLon;
//import de.bacin.geoff.POI;
//import de.bacin.geoff.ServiceUtil;
//import de.bacin.geoff.geocoding.IGeocodingService;
//import de.bacin.geoff.map.GeoMap;
//import de.bacin.geoff.map.MapFactory;
//import de.bacin.geoff.map.MapOptions;
//import de.bacin.geoff.map.StyleMap;
//import de.bacin.geoff.map.StyleMapOptions;
//import de.bacin.geoff.map.features.FeaturesFactory;
//import de.bacin.geoff.map.geometries.GeometriesFactory;
//import de.bacin.geoff.map.geometries.Point;
//import de.bacin.geoff.map.layers.LayerOptions;
//import de.bacin.geoff.map.layers.LayersFactory;
//import de.bacin.geoff.map.layers.OSM;
//import de.bacin.geoff.map.layers.Vector;
//import de.bacin.geoff.map.types.Bounds;
//import de.bacin.geoff.map.types.LonLat;
//import de.bacin.geoff.map.types.TypesFactory;
//import de.bacin.geoff.ui.swt.GeoffMapComposite;

public class CopyOfNewEditGeoSite extends AbstractScreenImpl implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Form frmSite;
	private Country owner;
	private Site site;
	
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private Text txtRegion;
	private Text txtName;
	private Text txtArea;
	private Text txtCity;
	private Text txtStreet;
	private Text txtNr;
	private Text txtLongitude;
	private Text txtLatitude;

	
	private TreeViewer geocodingTreeViewer;

	private GeoffMapComposite geoMapComposite;

	/**
	 * The Geo map
	 */
	private GeoMap map;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public CopyOfNewEditGeoSite(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));
		IObservableValue regionObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtRegion, SWT.Modify));
		IObservableValue areaObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtArea, SWT.Modify));
		IObservableValue cityObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtCity, SWT.Modify));
		IObservableValue streetObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtStreet, SWT.Modify));
		IObservableValue nrObservable = SWTObservables.observeDelayedValue(400,
				SWTObservables.observeText(txtNr, SWT.Modify));
		IObservableValue longitudeObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtLongitude, SWT.Modify));
		IObservableValue latitudeObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtLatitude, SWT.Modify));

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.LOCATION__NAME);
		IEMFValueProperty regionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__REGION);
		IEMFValueProperty areaProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__AREA);
		IEMFValueProperty cityProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__CITY);
		IEMFValueProperty streetProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__SREET);
		IEMFValueProperty nrProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__HOUSENUMBER);
		IEMFValueProperty longitudeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__LONGITUDE);
		IEMFValueProperty latitudeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				GeoPackage.Literals.SITE__LATITUDE);

		context.bindValue(nameObservable, nameProperty.observe(site), null,
				null);
		context.bindValue(regionObservable, regionProperty.observe(site), null,
				null);
		context.bindValue(areaObservable, areaProperty.observe(site), null,
				null);
		context.bindValue(cityObservable, cityProperty.observe(site), null,
				null);
		context.bindValue(streetObservable, streetProperty.observe(site), null,
				null);
		context.bindValue(nrObservable, nrProperty.observe(site), null, null);
		context.bindValue(longitudeObservable, longitudeProperty.observe(site),
				null, null);
		context.bindValue(latitudeObservable, latitudeProperty.observe(site),
				null, null);

		// This dirties the site immidiatly.

		IObservableValue observeSingleSelectionTableViewer = ViewerProperties
				.singleSelection().observe(geocodingTreeViewer);
		IObservableValue latLonObservable = PojoProperties.value(POI.class,
				"latLon", LatLon.class).observeDetail(
				observeSingleSelectionTableViewer);

		IObservableValue latObservable = PojoProperties.value(LatLon.class,
				"lat", double.class).observeDetail(latLonObservable);
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(
				SWT.NONE).observe(txtLatitude);
		context.bindValue(latObservable, observeTextTextObserveWidget, null,
				null);

		IObservableValue lonObservable = PojoProperties.value(LatLon.class,
				"lon", double.class).observeDetail(latLonObservable);
		IObservableValue lonTextObservable = WidgetProperties.text(SWT.NONE)
				.observe(txtLongitude);
		context.bindValue(lonObservable, lonTextObservable, null, null);

		IObservableValue descriptionObservable = PojoProperties.value(
				POI.class, "description", String.class).observeDetail(
				observeSingleSelectionTableViewer);
		IObservableValue nameObservableValue = WidgetProperties.text(SWT.NONE)
				.observe(txtName);
		context.bindValue(descriptionObservable, nameObservableValue, null,
				null);

		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Country) {
			this.owner = (Country) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		final POI poiFromSite;
		if (object != null && object instanceof Site) {
			site = (Site) object;
			// Set the site as Point Of Interrest in Geo FF
			poiFromSite = poiFromSite(site);

		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();

		if (poiFromSite != null) {

			showMarker(site);
		}
		geoMapComposite.setMap(map, "map");
		panToPOI(poiFromSite);
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmSite = toolkit.createForm(this);
		frmSite.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmSite);

		frmSite.setText(getOperationText() + "Site");
		frmSite.getBody().setLayout(new FillLayout());
		SashForm formBody = new SashForm(frmSite.getBody(), SWT.HORIZONTAL);
		{
			// formBody.setLayout(new GridLayout(2, false));
			Composite leftSideContainer = toolkit.createComposite(formBody);
			leftSideContainer
					.setLayoutData(new GridData(GridData.FILL_VERTICAL));
			GridLayout layout = new GridLayout(1, false);
			layout.marginWidth = 0;
			layout.marginHeight = 0;
			leftSideContainer.setLayout(layout);

			{
				Section sctnGeoSpatial = toolkit.createSection(
						leftSideContainer, Section.TITLE_BAR);
				sctnGeoSpatial.setLayoutData(new GridData(GridData.FILL_BOTH));
				toolkit.paintBordersFor(sctnGeoSpatial);
				sctnGeoSpatial.setText("Auto Search");

				Composite composite = toolkit.createComposite(sctnGeoSpatial,
						SWT.NONE);
				toolkit.paintBordersFor(composite);
				sctnGeoSpatial.setClient(composite);
				composite.setLayout(new GridLayout(2, false));

				{
					Text txtLongitude = toolkit.createText(composite, "",
							widgetStyle | SWT.SEARCH);
					txtLongitude.setMessage("Type in address to search for...");
					GridData gd_txtLongitude = new GridData(
							GridData.FILL_HORIZONTAL);
					gd_txtLongitude.horizontalSpan = 2;
					txtLongitude.setLayoutData(gd_txtLongitude);

					Listener listener = new Listener() {
						public void handleEvent(Event event) {
							Text t = (Text) event.widget;
							String query = t.getText();
							IGeocodingService geoCoder = ServiceUtil
									.getService(IGeocodingService.class);
							List<POI> pois = geoCoder.executeQuery(query);
							geocodingTreeViewer.setInput(pois);
						}
					};
					txtLongitude.addListener(SWT.DefaultSelection, listener);
				}

				{
					Tree tree = toolkit.createTree(composite, SWT.SINGLE);
					geocodingTreeViewer = new TreeViewer(tree);
					GridData ld = new GridData(GridData.FILL_BOTH);
					ld.horizontalSpan = 2;
					tree.setLayoutData(ld);
					tree.setLinesVisible(false);
					tree.setHeaderVisible(false);

					geocodingTreeViewer
							.setContentProvider(new ITreeContentProvider() {
								public void inputChanged(Viewer viewer,
										Object oldInput, Object newInput) {
								}

								public void dispose() {
								}

								public boolean hasChildren(Object element) {
									return false;
								}

								public Object getParent(Object element) {
									return null;
								}

								public Object[] getElements(Object inputElement) {
									return new ArrayContentProvider()
											.getElements(inputElement);
								}

								public Object[] getChildren(Object parentElement) {
									return null;
								}
							});

					geocodingTreeViewer.setLabelProvider(new LabelProvider() {
						@Override
						public String getText(Object element) {
							POI poi = (POI) element;
							return poi.getDescription();
						}
					});
				}
			}

			{
				Section sctnMappings = toolkit.createSection(leftSideContainer,
						Section.EXPANDED | Section.TITLE_BAR);
				sctnMappings.setLayoutData(new GridData(
						GridData.FILL_HORIZONTAL));
				toolkit.paintBordersFor(sctnMappings);
				sctnMappings.setText("Manual Input");

				Composite composite_1 = toolkit.createComposite(sctnMappings,
						SWT.NONE);
				toolkit.paintBordersFor(composite_1);
				sctnMappings.setClient(composite_1);
				composite_1.setLayout(new GridLayout(2, false));

				Label lblName = toolkit.createLabel(composite_1, "Name:",
						SWT.NONE);
				lblName.setAlignment(SWT.RIGHT);
				GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER,
						false, false, 1, 1);
				gd_lblName.widthHint = 70;
				lblName.setLayoutData(gd_lblName);

				txtName = toolkit.createText(composite_1, "", widgetStyle);
				GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false,
						false, 1, 1);
				gd_txtName.widthHint = 150;
				txtName.setLayoutData(gd_txtName);

				Label lblRegion = toolkit.createLabel(composite_1, "Region:",
						SWT.NONE);
				lblRegion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
						false, false, 1, 1));

				txtRegion = toolkit.createText(composite_1, "", widgetStyle);
				txtRegion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
						false, false, 1, 1));

				Label lblArea = toolkit.createLabel(composite_1, "Area:",
						SWT.NONE);
				lblArea.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
						false, false, 1, 1));

				txtArea = toolkit.createText(composite_1, "", widgetStyle);
				txtArea.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
						false, 1, 1));

				Label lblCity = toolkit.createLabel(composite_1, "City:",
						SWT.NONE);
				lblCity.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
						false, false, 1, 1));
				lblCity.setAlignment(SWT.RIGHT);

				txtCity = toolkit.createText(composite_1, "", widgetStyle);
				txtCity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
						false, 1, 1));

				Label lblStreet = toolkit.createLabel(composite_1, "Street:",
						SWT.NONE);
				lblStreet.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
						false, false, 1, 1));
				lblStreet.setAlignment(SWT.RIGHT);

				txtStreet = toolkit.createText(composite_1, "", widgetStyle);
				txtStreet.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
						false, false, 1, 1));

				Label lblNr = toolkit.createLabel(composite_1, "Nr:", SWT.NONE);
				lblNr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
						false, 1, 1));
				lblNr.setAlignment(SWT.RIGHT);

				txtNr = toolkit.createText(composite_1, "", widgetStyle);
				GridData gd_txtNr = new GridData(SWT.LEFT, SWT.CENTER, false,
						false, 1, 1);
				gd_txtNr.widthHint = 30;
				txtNr.setLayoutData(gd_txtNr);
			}

			{
				Section sctnGeoSpatial = toolkit.createSection(
						leftSideContainer, Section.TITLE_BAR);
				sctnGeoSpatial.setLayoutData(new GridData(
						GridData.FILL_HORIZONTAL));
				toolkit.paintBordersFor(sctnGeoSpatial);
				sctnGeoSpatial.setText("Geo Spatial Coordinates");

				Composite composite = toolkit.createComposite(sctnGeoSpatial,
						SWT.NONE);
				toolkit.paintBordersFor(composite);
				sctnGeoSpatial.setClient(composite);
				composite.setLayout(new GridLayout(2, false));

				Label lblLongitude = toolkit.createLabel(composite,
						"Longitude:", SWT.NONE);
				GridData gd_lblLongitude = new GridData(SWT.LEFT, SWT.CENTER,
						false, false, 1, 1);
				gd_lblLongitude.widthHint = 70;
				lblLongitude.setLayoutData(gd_lblLongitude);
				lblLongitude.setAlignment(SWT.RIGHT);

				txtLongitude = toolkit.createText(composite, "", widgetStyle);
				GridData gd_txtLongitude = new GridData(SWT.LEFT, SWT.CENTER,
						false, false, 1, 1);
				gd_txtLongitude.widthHint = 150;
				txtLongitude.setLayoutData(gd_txtLongitude);

				Label lblLatitude = toolkit.createLabel(composite, "Latitude:",
						SWT.NONE);
				lblLatitude.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
						false, false, 1, 1));
				lblLatitude.setAlignment(SWT.RIGHT);

				txtLatitude = toolkit.createText(composite, "", widgetStyle);
				txtLatitude.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
						false, false, 1, 1));
			}
		}

		Section mapSection = toolkit.createSection(formBody, Section.EXPANDED
				| Section.TITLE_BAR);
		mapSection.setText("Map");
		mapSection.setLayoutData(new GridData(GridData.FILL_BOTH));
		geoMapComposite = new GeoffMapComposite(mapSection, SWT.None);
		mapSection.setClient(geoMapComposite);

		map = createSiteMap();

		formBody.setWeights(new int[] { 30, 70 });
		formBody.setLayout(new FillLayout());

		geocodingTreeViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						if (!event.getSelection().isEmpty()) {
							POI poi = (POI) ((IStructuredSelection) event
									.getSelection()).getFirstElement();
							panToPOI(poi);
						}
					}
				});
	}

	public GeoMap createSiteMap() {
		GeoMap map = MapFactory.eINSTANCE.createGeoMap();

		{
			MapOptions opts = MapFactory.eINSTANCE.createMapOptions();
			opts.setNumZoomLevels(16);

			map.setOptions(opts);
			boolean useMaxExtent = false;

			if (useMaxExtent) {
				Bounds bounds = TypesFactory.eINSTANCE.createBounds();
				bounds.setLeft(68.774414);
				bounds.setBottom(11.381836);
				bounds.setRight(123.662109);
				bounds.setTop(34.628906);
			} else {
				map.setZoomToMaxExtent(true);
			}
		}

		{
//			WMS layer = LayersFactory.eINSTANCE.createWMS();
//			layer.setUrl("http://vmap0.tiles.osgeo.org/wms/vmap0");
//			HTTPGetParams params = LayersFactory.eINSTANCE
//					.createHTTPGetParams();
//			params.setLayers("basic");
//			layer.setParams(params);
			
			OSM layer = LayersFactory.eINSTANCE.createOSM();
//			LayerOptions opts = LayersFactory.eINSTANCE.createLayerOptions();
//			opts.setIsBaseLayer(true);
//			layer.setOptions(opts);

			LayerOptions opts = LayersFactory.eINSTANCE.createLayerOptions();
			opts.setIsBaseLayer(true);
			layer.setOptions(opts);

			map.getLayers().add(layer);
		}

		// {
		// Vector layer = LayersFactory.eINSTANCE.createVector();
		// layer.setName("KML");
		// Fixed strategy = StrategiesFactory.eINSTANCE.createFixed();
		// layer.getStrategies().add(strategy);
		// HTTP protocol = ProtocolsFactory.eINSTANCE.createHTTP();
		// HTTPOptions opts = ProtocolsFactory.eINSTANCE.createHTTPOptions();
		// opts.setUrl("/www/Ghana_19012008-3.kml");
		// KML kml = FormatsFactory.eINSTANCE.createKML();
		// kml.setExtractAttributes(true);
		// kml.setExtractStyles(true);
		// opts.setFormat(kml);
		// protocol.setOptions(opts);
		// layer.setProtocol(protocol);
		// map.getLayers().add(layer);
		// }

		return map;
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getSites(), site);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (site.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			// System.out.println(site.cdoID() + "" + site.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmSite;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Site";
	}

	/**
	 * 
	 * Bridge Site to POI.
	 * 
	 * @param site
	 * @return
	 */
	public POI poiFromSite(Site site) {

		if (site.eIsSet(GeoPackage.Literals.SITE__LATITUDE)
				&& site.eIsSet(GeoPackage.Literals.SITE__LONGITUDE)) {
			POI poi = new POI();
			poi.setLatLon(new LatLon(new Double(site.getLatitude()),
					new Double(site.getLongitude())));
			poi.setDescription(site.getName());

			return poi;
		}
		return null;
	}

	public void panToPOI(POI poi) {
		LonLat ll = Geoff.types().createLonLat();
		ll.setLat((float) poi.getLatLon().getLat());
		ll.setLon((float) poi.getLatLon().getLon());
		geoMapComposite.setCenter(ll, 9);
	}

	/**
	 * The layer and marker have to be set in the Geoff model in one go,for the
	 * javascript generator.
	 * 
	 * @param site
	 */
	public void showMarker(Site site) {

		if (site.eIsSet(GeoPackage.Literals.SITE__LATITUDE)
				&& site.eIsSet(GeoPackage.Literals.SITE__LONGITUDE)) {

			Vector markerLayer = LayersFactory.eINSTANCE.createVector();
			markerLayer.setName("Overlay");
			StyleMap styleMap = MapFactory.eINSTANCE.createStyleMap();
			StyleMapOptions options = MapFactory.eINSTANCE
					.createStyleMapOptions();
			options.setExternalGraphic("/www/Marker_s_H.png");
			options.setGraphicWidth(20);
			options.setGraphicHeight(24);
			options.setGraphicYOffset(-24);
			options.setTitle("${tooltip}");
			styleMap.setOptions(options);
			markerLayer.setStyleMap(styleMap);

			map.getLayers().add(markerLayer);

			de.bacin.geoff.map.features.Vector feature = FeaturesFactory.eINSTANCE
					.createVector();
			Point geometry = GeometriesFactory.eINSTANCE.createPoint();
			geometry.setX(new Float(site.getLongitude()));
			geometry.setY(new Float(site.getLatitude()));
			geometry.setProjection("EPSG:4326");
			feature.setGeometry(geometry);
			feature.getAttributes().put("tooltip", "OpenLayers");
			markerLayer.getFeatures().add(feature);
		}
	}

}
