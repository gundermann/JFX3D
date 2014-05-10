package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;
import javafx.scene.Node;

public interface ModellingArea {

  void initPainting( Painting painting );

  void enableZRotation();

  void add( Node shape );

}
