package graphiceditor.handler;

import graphiceditor.gui.PaintingArea;
import javafx.scene.input.MouseEvent;

public class PaintingFinishedHandler implements PaintingHandler {

  private PaintingArea paintingArea;

  @Override
  public void handle( MouseEvent event ) {
    paintingArea.finishPainting();
  }

  @Override
  public void setPaintingArea( PaintingArea paintingArea ) {
    this.paintingArea = paintingArea;
  }

}
