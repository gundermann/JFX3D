package graphiceditor.gui;

import javafx.scene.Node;

public interface ModellingArea {

  void add( Node shape );

  DimensionArea getDimensionArea();

  PaintingArea getPaintingArea();

}
