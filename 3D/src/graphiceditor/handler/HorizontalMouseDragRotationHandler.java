package graphiceditor.handler;

import javafx.beans.property.DoubleProperty;

public class HorizontalMouseDragRotationHandler extends AbstractMouseDragRotationHandler {

  public HorizontalMouseDragRotationHandler( DoubleProperty rotationProperty ) {
    super( rotationProperty, MouseMovement.Horizontal );
  }

}
