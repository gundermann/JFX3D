package graphiceditor.sample;

import graphiceditor.graphicobjects.impl.Object3DImpl;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;

public class Cube extends Object3DImpl {

  public Cube() {
    final Rectangle side1 = RectangleBuilder.create().x( -100 ).y( -100 ).width( 200 ).height( 200 ).fill( Color.RED )
        .build();

    final Rotate side2Rotate = RotateBuilder.create().pivotX( -100 ).pivotY( -100 ).pivotZ( 0 ).axis( Rotate.Y_AXIS )
        .angle( 90 ).build();

    final Rectangle side2 = RectangleBuilder.create().x( -100 ).y( -100 ).width( 200 ).height( 200 ).fill( Color.GREEN )
        .transforms( side2Rotate ).build();

    final Rotate side3Rotate = RotateBuilder.create().pivotX( 100 ).pivotY( -100 ).pivotZ( 0 ).angle( 90 )
        .axis( new Point3D( -1, 0, 0 ) ).build();

    final Rectangle side3 = RectangleBuilder.create().x( -100 ).y( -100 ).width( 200 ).height( 200 ).fill( Color.BLUE )
        .transforms( side3Rotate ).build();

    final Rotate side4Rotate = RotateBuilder.create().pivotX( 100 ).pivotY( 100 ).pivotZ( 0 ).angle( 90 )
        .axis( new Point3D( 0, -1, 0 ) ).build();

    final Rectangle side4 = RectangleBuilder.create().x( -100 ).y( -100 ).width( 200 ).height( 200 ).fill( Color.CYAN )
        .transforms( side4Rotate ).build();

    final Rotate side5Rotate = RotateBuilder.create().pivotX( -100 ).pivotY( 100 ).pivotZ( 0 ).axis( Rotate.X_AXIS )
        .angle( 90 ).build();

    final Rectangle side5 = RectangleBuilder.create().x( -100 ).y( -100 ).width( 200 ).height( 200 )
        .fill( Color.MAGENTA ).transforms( side5Rotate ).build();

    final Rectangle side6 = RectangleBuilder.create().x( -100 ).y( -100 ).width( 200 ).height( 200 ).translateZ( -200 )
        .fill( Color.YELLOW ).build();

    getChildren().addAll( side1, side2, side3, side4, side5, side6 );
  }
}
