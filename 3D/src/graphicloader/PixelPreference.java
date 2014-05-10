package graphicloader;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

public class PixelPreference {

  private double x;

  private double y;

  private double z;

  private int red;

  private int green;

  private int blue;

  public Rectangle createPoint() {
    Rectangle point = RectangleBuilder.create().x( x ).y( y ).fill( Color.rgb( red, green, blue ) ).build();
    point.translateYProperty().set( z );
    return point;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }

  public void setX( double x ) {
    this.x = x;
  }

  public void setY( double y ) {
    this.y = y;
  }

  public void setZ( double z ) {
    this.z = z;
  }

  public void setRed( int red ) {
    this.red = red;
  }

  public void setGreen( int green ) {
    this.green = green;
  }

  public void setBlue( int blue ) {
    this.blue = blue;
  }

}
