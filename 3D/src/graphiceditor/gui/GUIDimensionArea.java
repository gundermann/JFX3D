package graphiceditor.gui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage {

  public DoubleProperty rootAngleX = new SimpleDoubleProperty();

  public DoubleProperty rootAngleY = new SimpleDoubleProperty();

  private Pane mainPane;

  public GUIDimensionArea() {
    Scene scene = SceneBuilder.create().root( createRoot() ).camera( PerspectiveCameraBuilder.create().build() )
        .depthBuffer( true ).build();
    // scene.setFill( Color.BLUE );
    setScene( scene );
    setProperties();
    show();
  }

  private void setProperties() {
    mainPane.prefWidthProperty().bind( getScene().widthProperty() );
    mainPane.prefHeightProperty().bind( getScene().heightProperty() );
    final Rotate rootRotateX = RotateBuilder.create().pivotX( 0 ).pivotY( 0 ).pivotZ( 0 ).axis( Rotate.X_AXIS ).build();
    rootRotateX.angleProperty().bind( rootAngleX );

    final Rotate rootRotateY = RotateBuilder.create().pivotX( 0 ).pivotY( 0 ).pivotZ( 0 ).axis( Rotate.Y_AXIS ).build();
    rootRotateY.angleProperty().bind( rootAngleY );
    mainPane.getTransforms().addAll( rootRotateX, rootRotateY );
  }

  public Pane createRoot() {
    mainPane = new Pane();

    return mainPane;
  }

  public void setMainPane( Pane mainPane ) {
    hide();
    this.mainPane = mainPane;
    Scene scene = SceneBuilder.create().root( mainPane ).camera( PerspectiveCameraBuilder.create().build() )
        .depthBuffer( true ).build();
    setScene( scene );
    setProperties();
    show();
  }

  public Pane getMainPane() {
    return mainPane;
  }

  public void add( Node shape ) {
    mainPane.getChildren().add( shape );
  }

}
