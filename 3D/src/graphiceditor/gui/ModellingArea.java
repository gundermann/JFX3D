package graphiceditor.gui;

import javafx.scene.Node;

public interface ModellingArea {

  void add( Node shape );

  PaintingArea getPaintingArea();

}
