package graphiceditor.handler;

import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseRotationHandler implements EventHandler<MouseEvent> {

  private final DoubleProperty rootAngleX;

  private final DoubleProperty rootAngleY;

  public MouseRotationHandler( DoubleProperty rootAngleX, DoubleProperty rootAngleY ) {
    this.rootAngleX = rootAngleX;
    this.rootAngleY = rootAngleY;
  }

  @Override
  public void handle( MouseEvent mouseEvent ) {
    double mouseX = mouseEvent.getSceneX();
    double mouseY = mouseEvent.getSceneY();

    rootAngleX.set( mouseY );
    rootAngleY.set( mouseX );
  }

}
