package graphiceditor.handler;

import javafx.beans.property.DoubleProperty;

public class VerticalMouseDragRotationHandler extends AbstractMouseDragRotationHandler {

  public VerticalMouseDragRotationHandler( DoubleProperty rotationProperty ) {
    super( rotationProperty, MouseMovement.Vertical );
  }

}
