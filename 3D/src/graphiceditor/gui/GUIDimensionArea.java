package graphiceditor.gui;

import javafx.event.EventHandler;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage implements DimensionArea {

  private EventHandler<MouseEvent> mouseDragHandler;

  private AnchorPane mainPane;

  public GUIDimensionArea() {
    Scene scene = SceneBuilder.create().root( createRoot() ).camera( PerspectiveCameraBuilder.create().build() )
        .depthBuffer( true ).build();
    scene.setFill( Color.BLUE );
    setScene( scene );
    setProperties();
    show();
  }

  private void setProperties() {
    mainPane.prefWidthProperty().bind( getScene().widthProperty() );
    mainPane.prefHeightProperty().bind( getScene().heightProperty() );
    // final Rotate rootRotateX = RotateBuilder.create().pivotX( 0 ).pivotY( getScene().getWidth() / 2 ).pivotZ( 0 )
    // .axis( Rotate.X_AXIS ).build();
    // rootRotateX.angleProperty().bind( rootAngleX );
    //
    // final Rotate rootRotateY = RotateBuilder.create().pivotX( getScene().getX() / 2 ).pivotY( 0 ).pivotZ( 0 )
    // .axis( Rotate.Y_AXIS ).build();
    // rootRotateY.angleProperty().bind( rootAngleY );
    // mainPane.getTransforms().addAll( rootRotateX, rootRotateY );
  }

  public AnchorPane createRoot() {
    mainPane = new AnchorPane();

    return mainPane;
  }
}
