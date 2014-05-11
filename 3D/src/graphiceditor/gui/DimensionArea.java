package graphiceditor.gui;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public interface DimensionArea {

  Pane getMainPane();

  void add( Node shape );

  void enableZRotation();

  void enableXRotation();

  void enableYRotation();

  void setMainPane( AnchorPane mainPane );

  void disableRotation();
}
