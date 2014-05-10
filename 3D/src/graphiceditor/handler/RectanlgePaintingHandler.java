package graphiceditor.handler;

import graphiceditor.gui.PaintingArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RectanlgePaintingHandler implements PaintingHandler {

  private Rectangle rect;

  private double beginningX;

  private double beginningY;

  @Override
  public void handle( MouseEvent event ) {
    if ( event.getY() > beginningY )
      rect.setHeight( event.getY() - rect.getY() );
    else {
      rect.setHeight( beginningY - event.getY() );
      rect.setY( event.getY() );
    }

    if ( event.getX() > beginningX )
      rect.setWidth( event.getX() - rect.getX() );
    else {
      rect.setWidth( beginningX - event.getX() );
      rect.setX( event.getX() );
    }
  }

  @Override
  public void setPaintingArea( PaintingArea paintingArea ) {
    this.rect = (Rectangle) paintingArea.getActualPainting();
    beginningX = rect.getX();
    beginningY = rect.getY();
  }
}
