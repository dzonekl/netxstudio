/*******************************************************************************
 * Copyright (c) Jun 24, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f4.support;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;

import com.netxforge.netxstudio.metrics.Metric;

public class MetricTreeLabelProvider
extends StyledCellLabelProvider
{
private IMapChangeListener mapChangeListener =
  new IMapChangeListener()
  {
    public void handleMapChange(MapChangeEvent event)
    {
      Set<?> affectedElements =
        event.diff.getChangedKeys();
      if (!affectedElements.isEmpty())
      {
        LabelProviderChangedEvent newEvent =
          new LabelProviderChangedEvent(
            MetricTreeLabelProvider.this,
            affectedElements.toArray()
        );
        fireLabelProviderChanged(newEvent);
      }
    }
  };

public MetricTreeLabelProvider(
  IObservableMap... attributeMaps)
{
  for (int i = 0; i < attributeMaps.length; i++)
  {
    attributeMaps[i].addMapChangeListener(
      mapChangeListener
    );
  }
}

@Override
public String getToolTipText(Object element)
{
  return "#dummy#";
}

@Override
public void update(ViewerCell cell)
{
  if (cell.getElement() instanceof Metric)
  {
    Metric metric = (Metric)cell.getElement();

    StyledString styledString = new StyledString(
      metric.getName()!=null ? metric.getName():"*noname*",
      null
    );
//    String decoration = " (" +
//      metric.getCommitters().size() + " Committers)";
//    styledString.append(
//      decoration,
//      StyledString.COUNTER_STYLER
//    );
    cell.setText(styledString.getString());
//    cell.setImage(projectImage);
    cell.setStyleRanges(styledString.getStyleRanges());
  }
//  else if (cell.getElement() instanceof CommitterShip)
//  {
//    Person p = (
//      (CommitterShip)cell.getElement()
//    ).getPerson();
//    String value = "*noname*";
//    if (p != null)
//    {
//      value = p.getLastname() + ", " + p.getFirstname();
//    }
//    StyledString styledString = new StyledString(
//      value, null);
//    cell.setText(styledString.getString());
//    cell.setForeground(
//      cell.getControl().getDisplay().getSystemColor(
//        SWT.COLOR_DARK_GRAY
//      )
//    );
//    cell.setImage(committerImage);
//    cell.setStyleRanges(styledString.getStyleRanges());
//  }
}
}
