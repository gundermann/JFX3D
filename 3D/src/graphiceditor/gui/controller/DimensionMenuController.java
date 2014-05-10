package graphiceditor.gui.controller;

import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.MenuDisabler;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

public class DimensionMenuController {

  private DimensionArea dimensionArea;

  @FXML
  private ToggleButton btXRotation;

  @FXML
  private ToggleButton btYRotation;

  @FXML
  private ToggleButton btZRotation;

  public void setDimensionArea( DimensionArea dimensionArea ) {
    this.dimensionArea = dimensionArea;
  }

  @FXML
  public void toggleXRotation() {
    if ( !btXRotation.isSelected() ) {
      dimensionArea.disableRotation();
      enableRotationButtons();
    }
    else {
      dimensionArea.enableXRotation();
      MenuDisabler.disableForRotation();
      btYRotation.setDisable( true );
      btZRotation.setDisable( true );
    }
  }

  private void enableRotationButtons() {
    btXRotation.setDisable( false );
    btYRotation.setDisable( false );
    btZRotation.setDisable( false );
  }

  @FXML
  public void toggleYRotation() {
    if ( !btYRotation.isSelected() ) {
      dimensionArea.disableRotation();
      enableRotationButtons();
    }
    else {
      dimensionArea.enableYRotation();
      MenuDisabler.disableForRotation();
      btXRotation.setDisable( true );
      btZRotation.setDisable( true );
    }
  }

  @FXML
  public void toggleZRotation() {
    if ( !btZRotation.isSelected() ) {
      dimensionArea.disableRotation();
      enableRotationButtons();
    }
    else {
      dimensionArea.enableZRotation();
      MenuDisabler.disableForRotation();
      btYRotation.setDisable( true );
      btXRotation.setDisable( true );
    }
  }
}
