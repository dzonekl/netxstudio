package com.netxforge.netxstudio.models.export.kml;

import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.models.export.kml.ExportJob;
import com.netxforge.netxstudio.operators.Node;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * A background job which exports network
 * information to KML
 */
@SuppressWarnings("all")
public class KMLExporter {
  private IDataProvider provider;
  
  private List<Node> nodes;
  
  public KMLExporter(final IDataProvider provider) {
    this.provider = provider;
  }
  
  public void go() {
    ExportJob _exportJob = new ExportJob("kml export");
    ExportJob j = _exportJob;
    j.schedule(1000);
  }
  
  public List<Node> set(final Node... nodes) {
    List<Node> _nodes = this.nodes = ((List<Node>)Conversions.doWrapArray(nodes));
    return _nodes;
  }
}
