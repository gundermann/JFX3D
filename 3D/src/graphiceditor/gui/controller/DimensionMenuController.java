package graphiceditor.gui.controller;

import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.MenuDisabler;
import javafx.fxml.FXML;

public class DimensionMenuController {

  private DimensionArea dimensionArea;

  public void setDimensionArea( DimensionArea dimensionArea ) {
    this.dimensionArea = dimensionArea;
  }

  @FXML
  public void toggleXRotaion() {
    dimensionArea.enableXRotation();
    MenuDisabler.disableForRotation();
  }

}
