package graphiceditor.gui.controller;

import graphiceditor.business.Painting;
import graphiceditor.gui.PaintingArea;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PaintingMenuController {

  private PaintingArea actualPaintingArea;

  @FXML
  private ListView<String> lvComponents;

  public PaintingArea getPaintingArea() {
    return actualPaintingArea;
  }

  @FXML
  public void componentSelected() {
    actualPaintingArea.setActualPaintingById( lvComponents.getSelectionModel().getSelectedIndex() );
  }

  @FXML
  public void selectPaintRect() {
    actualPaintingArea.initPainting( Painting.Rectangle );
  }

  public void setPaintingArea( PaintingArea paintingArea ) {
    this.actualPaintingArea = paintingArea;
    updateComponents();
  }

  public void updateComponents() {
    lvComponents.getItems().setAll( this.actualPaintingArea.getAllGraphicObjects() );
  }

}
