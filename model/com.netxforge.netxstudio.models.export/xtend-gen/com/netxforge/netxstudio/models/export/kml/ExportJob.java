package com.netxforge.netxstudio.models.export.kml;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ExportJob extends Job {
  protected IStatus run(final IProgressMonitor arg0) {
    IStatus _doRun = this.doRun();
    return _doRun;
  }
  
  public ExportJob(final String name) {
    super(name);
  }
  
  public IStatus doRun() {
    CharSequence result = this.processHead();
    this.processTail();
    return Status.OK_STATUS;
  }
  
  public CharSequence processHead() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence processContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Placemark>");
    _builder.newLine();
    _builder.append("<name>");
    _builder.append("</name>");
    _builder.newLine();
    _builder.append("<description>Attached to the ground. Intelligently places itself ");
    _builder.newLine();
    _builder.append("at the height of the underlying terrain.</description>");
    _builder.newLine();
    _builder.append("<Point>");
    _builder.newLine();
    _builder.append("<coordinates>-122.0822035425683,37.42228990140251,0</coordinates>");
    _builder.newLine();
    _builder.append("</Point>");
    _builder.newLine();
    _builder.append("</Placemark>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence processTail() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("</kml>");
    _builder.newLine();
    return _builder;
  }
}
