package graphiceditor.gui;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface DimensionArea {

  public Pane getMainPane();

  public void add( Node shape );

  void enableRotation();

  void setMainPane( Pane mainPane );
}
