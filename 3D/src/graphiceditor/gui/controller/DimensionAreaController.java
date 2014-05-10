package graphiceditor.gui.controller;

import graphiceditor.RotationHandlerFactory;
import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.handler.AbstractMouseDragRotationHandler;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DimensionAreaController implements DimensionArea {

  private final GUIDimensionArea stage;

  private EventHandler<MouseEvent> mouseDragRotationHandler;

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
  public void enableZRotation() {
    setMouseDragRotationHandler( RotationHandlerFactory.getInstance().createHorizontalRotationHandler(
        stage.getZRotationProperty() ) );
  }

  private void setMouseDragRotationHandler( AbstractMouseDragRotationHandler mouseDragRotationHandler ) {
    this.mouseDragRotationHandler = mouseDragRotationHandler;
    stage.addEventHandler( MouseEvent.MOUSE_DRAGGED, this.mouseDragRotationHandler );
  }

  @Override
  public void setMainPane( Pane mainPane ) {
    stage.setMainPane( mainPane );
  }

  @Override
  public void enableXRotation() {
    setMouseDragRotationHandler( RotationHandlerFactory.getInstance().createVerticalRotationHandler(
        stage.getXRotationProperty() ) );
  }

  @Override
  public void enableYRotation() {
    setMouseDragRotationHandler( RotationHandlerFactory.getInstance().createHorizontalRotationHandler(
        stage.getYRotationProperty() ) );
  }

}
