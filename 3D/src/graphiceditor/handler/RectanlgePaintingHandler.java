package graphiceditor.handler;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.impl.Rectangle3D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RectanlgePaintingHandler implements PaintingHandler {

  private Rectangle3D rect;

  private double beginningX;

  private double beginningY;

  @Override
  public void handle( MouseEvent event ) {
    if ( event.getY() > beginningY )
      rect.changeHeightTo( event.getY() - rect.getYPositionProperty().get() );
    else {
      rect.changeHeightTo( beginningY - event.getY() );
      rect.getYPositionProperty().set( event.getY() );
    }

    if ( event.getX() > beginningX )
      rect.changeWidthTo( event.getX() - rect.getXPositionProperty().get() );
    else {
      rect.changeWidthTo( beginningX - event.getX() );
      rect.getXPositionProperty().set( event.getX() );
    }
  }

  @Override
  public void setPaintingArea( PaintingArea paintingArea ) {
    this.rect = (Rectangle3D) paintingArea.getActualPainting();
    beginningX = rect.getXPositionProperty().get();
    beginningY = rect.getYPositionProperty().get();
  }
}
