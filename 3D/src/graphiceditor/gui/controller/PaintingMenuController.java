package graphiceditor.gui.controller;

import graphiceditor.graphicobjects.Painting;
import graphiceditor.gui.PaintingArea;

import java.util.List;

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
  }

  public void updateComponents( List<String> allGraphicObjects ) {
    lvComponents.getItems().setAll( allGraphicObjects );
  }

}
