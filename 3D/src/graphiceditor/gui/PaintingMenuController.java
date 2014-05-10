package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;

import java.util.List;

import javafx.fxml.FXML;

public class PaintingMenuController implements PaintingMenu {

  private final PaintingArea actualPaintingArea;

  private List<PaintingArea> paintingAreas;

  private final GUIPaintingMenu gui;

  public PaintingMenuController( PaintingArea paintingArea ) {
    this.actualPaintingArea = paintingArea;

    gui = new GUIPaintingMenu( this );
  }

  @Override
  public PaintingArea getPaintingArea() {
    return actualPaintingArea;
  }

  @FXML
  public void selectPaintRect() {
    actualPaintingArea.initPainting( Painting.Rectangle );
  }

}
