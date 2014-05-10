package graphiceditor.gui;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public interface DimensionArea {

  Stage getUI();

  Pane getMainPane();

  void add( Node shape );

  void enableRotation();

  void setMainPane( Pane mainPane );
}
