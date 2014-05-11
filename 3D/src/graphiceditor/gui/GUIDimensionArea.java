package graphiceditor.gui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage {

  private final DoubleProperty rootAngleX = new SimpleDoubleProperty();

  private final DoubleProperty rootAngleY = new SimpleDoubleProperty();

  private final DoubleProperty rootAngleZ = new SimpleDoubleProperty();

  private AnchorPane mainPane;

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
    rootRotateX.pivotXProperty().bind( mainPane.widthProperty().divide( 2 ) );
    rootRotateX.pivotYProperty().bind( mainPane.heightProperty().divide( 2 ) );
    rootRotateX.angleProperty().bind( rootAngleX );

    final Rotate rootRotateY = RotateBuilder.create().pivotZ( 0 ).axis( Rotate.Y_AXIS ).build();
    rootRotateY.pivotXProperty().bind( mainPane.widthProperty().divide( 2 ) );
    rootRotateY.pivotYProperty().bind( mainPane.heightProperty().divide( 2 ) );
    rootRotateY.angleProperty().bind( rootAngleY );

    final Rotate rootRotateZ = RotateBuilder.create().pivotZ( 0 ).axis( Rotate.Z_AXIS ).build();
    rootRotateZ.pivotXProperty().bind( mainPane.widthProperty().divide( 2 ) );
    rootRotateZ.pivotYProperty().bind( mainPane.heightProperty().divide( 2 ) );
    rootRotateZ.angleProperty().bind( rootAngleZ );
    mainPane.getTransforms().addAll( rootRotateX, rootRotateY, rootRotateZ );
  }

  public AnchorPane createRoot() {
    mainPane = new AnchorPane();

    return mainPane;
  }

  public void setMainPane( AnchorPane mainPane ) {
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

  public DoubleProperty getZRotationProperty() {
    return rootAngleZ;
  }

  public DoubleProperty getXRotationProperty() {
    return rootAngleX;
  }

  public DoubleProperty getYRotationProperty() {
    return rootAngleY;
  }

}
