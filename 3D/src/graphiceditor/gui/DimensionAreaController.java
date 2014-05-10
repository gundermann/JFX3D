package graphiceditor.gui;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DimensionAreaController implements DimensionArea {

  private final GUIDimensionArea stage;

  public DimensionAreaController() {
    stage = new GUIDimensionArea();
  }

  @Override
  public Stage getUI() {
    return stage;
  }

  @Override
  public Pane getMainPane() {
    return stage.getMainPane();
  }

  @Override
  public void add( Node shape ) {
    stage.add( shape );
  }

  @Override
  public void enableRotation() {

  }

  @Override
  public void setMainPane( Pane mainPane ) {
    stage.setMainPane( mainPane );
  }

}
