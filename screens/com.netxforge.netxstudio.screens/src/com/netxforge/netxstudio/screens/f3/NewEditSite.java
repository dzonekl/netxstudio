package com.netxforge.netxstudio.screens.f3;

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
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

import de.bacin.geoff.LatLon;
import de.bacin.geoff.POI;
import de.bacin.geoff.ServiceUtil;
import de.bacin.geoff.geocoding.IGeocodingService;
import de.bacin.geoff.ui.GeoffMapComposite;

public class NewEditSite extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewOperator;
	private Country owner;
	private Site site;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private Text txtRegion;
	private Text txtArea;
	private Text txtCity;
	private Text txtStreet;
	private Text txtNr;
	private Text txtLongitude;
	private Text txtLatitude;
	private TreeViewer tv;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditSite(Composite parent, int style) {
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

		IObservableValue observeSingleSelectionTableViewer = ViewerProperties
				.singleSelection().observe(tv);
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
		if (object != null && object instanceof Site) {
			site = (Site) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewOperator = toolkit.createForm(this);
		frmNewOperator.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewOperator);

		frmNewOperator.setText(getOperationText() + "Site");
		frmNewOperator.getBody().setLayout(new FillLayout());
		SashForm formBody = new SashForm(frmNewOperator.getBody(),
				SWT.HORIZONTAL);
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
							tv.setInput(pois);
						}
					};
					txtLongitude.addListener(SWT.DefaultSelection, listener);
				}

				{
					Tree tree = toolkit.createTree(composite, SWT.SINGLE);
					tv = new TreeViewer(tree);
					GridData ld = new GridData(GridData.FILL_BOTH);
					ld.horizontalSpan = 2;
					tree.setLayoutData(ld);
					tree.setLinesVisible(false);
					tree.setHeaderVisible(false);

					tv.setContentProvider(new ITreeContentProvider() {
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

					tv.setLabelProvider(new LabelProvider() {
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
		final GeoffMapComposite map = new GeoffMapComposite(mapSection,
				SWT.None);
		mapSection.setClient(map);

		formBody.setWeights(new int[] { 30, 70 });
		formBody.setLayout(new FillLayout());

		tv.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (!event.getSelection().isEmpty()) {
					POI poi = (POI) ((IStructuredSelection) event
							.getSelection()).getFirstElement();
					map.setCenter(poi.getLatLon(), 9);
				}
			}
		});
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
//			System.out.println(site.cdoID() + "" + site.cdoState());

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
		return frmNewOperator;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Site";
	}

}
