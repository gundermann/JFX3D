package graphiceditor.handler;

import graphiceditor.gui.PaintingArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

public class RectanglePaintingStartHandler implements PaintingHandler {

  private PaintingArea paintingArea;

  @Override
  public void handle( MouseEvent event ) {
    Rectangle rect = RectangleBuilder.create().x( event.getX() ).y( event.getY() ).build();
    paintingArea.setActualPainting( rect );
    paintingArea.startPainting();
  }

  @Override
  public void setPaintingArea( PaintingArea paintingArea ) {
    this.paintingArea = paintingArea;

  }
}
