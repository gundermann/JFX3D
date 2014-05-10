package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;
import javafx.scene.Node;

public interface ModellingArea {

  void initPainting( Painting painting );

  void enableRotation();

  void add( Node shape );
}
