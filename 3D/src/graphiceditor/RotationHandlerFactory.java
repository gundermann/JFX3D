package graphiceditor;

import graphiceditor.handler.AbstractMouseDragRotationHandler;
import graphiceditor.handler.HorizontalMouseDragRotationHandler;
import graphiceditor.handler.VerticalMouseDragRotationHandler;
import javafx.beans.property.DoubleProperty;

public class RotationHandlerFactory {

  private static RotationHandlerFactory _instance = null;

  public static RotationHandlerFactory getInstance() {
    if ( _instance == null ) {
      _instance = new RotationHandlerFactory();
    }
    return _instance;
  }

  public AbstractMouseDragRotationHandler createHorizontalRotationHandler( DoubleProperty rotationProperty ) {
    return new HorizontalMouseDragRotationHandler( rotationProperty );
  }

  public AbstractMouseDragRotationHandler createVerticalRotationHandler( DoubleProperty rotationProperty ) {
    return new VerticalMouseDragRotationHandler( rotationProperty );
  }

}