package graphiceditor.handler;

import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class AbstractMouseDragRotationHandler implements EventHandler<MouseEvent> {

  private final DoubleProperty rootAngle;

  private final MouseMovement mouseMovement;

  public AbstractMouseDragRotationHandler( DoubleProperty rootAngle, MouseMovement mouseMovement ) {
    this.rootAngle = rootAngle;
    this.mouseMovement = mouseMovement;
  }

  @Override
  public void handle( MouseEvent mouseEvent ) {
    if ( mouseMovement == MouseMovement.Horizontal ) {
      rootAngle.set( mouseEvent.getSceneX() );
    }
    else if ( mouseMovement == MouseMovement.Vertical ) {
      rootAngle.set( mouseEvent.getSceneY() );
    }
  }

}
