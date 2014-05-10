package graphiceditor.gui.controller;

import graphiceditor.graphicobjects.Painting;
import graphiceditor.gui.PaintingArea;
import javafx.fxml.FXML;

public class PaintingMenuController {

  private PaintingArea actualPaintingArea;

  public PaintingArea getPaintingArea() {
    return actualPaintingArea;
  }

  @FXML
  public void selectPaintRect() {
    actualPaintingArea.initPainting( Painting.Rectangle );
  }

  public void setPaintingArea( PaintingArea paintingArea ) {
    actualPaintingArea = paintingArea;
  }

}
