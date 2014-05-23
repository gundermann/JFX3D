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
      rect.setHeight( event.getY() - rect.layoutYProperty().get() );
    else {
      rect.setHeight( beginningY - event.getY() );
      rect.layoutYProperty().set( event.getY() );
    }

    if ( event.getX() > beginningX )
      rect.setWidth( event.getX() - rect.layoutXProperty().get() );
    else {
      rect.setWidth( beginningX - event.getX() );
      rect.layoutXProperty().set( event.getX() );
    }
  }

  @Override
  public void setPaintingArea( PaintingArea paintingArea ) {
    this.rect = (Rectangle) paintingArea.getActualPainting().asNode();
    beginningX = rect.layoutXProperty().get();
    beginningY = rect.layoutYProperty().get();
  }
}
