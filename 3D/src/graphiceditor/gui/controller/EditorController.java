package graphiceditor.gui.controller;

import graphiceditor.ModellingAreaFactory;
import graphiceditor.gui.GUIDimensionMenu;
import graphiceditor.gui.GUIPaintingMenu;
import graphiceditor.gui.ModellingArea;
import graphiceditor.sample.Cube;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

public class EditorController {

  @FXML
  private ToggleButton btDimensionMenu;

  @FXML
  private ToggleButton btPaintingMenu;

  private ModellingArea modellingArea;

  @FXML
  public void initNewObject() {
    modellingArea = ModellingAreaFactory.getInstance().createModellingArea();
    btDimensionMenu.setDisable( false );
    btPaintingMenu.setDisable( false );
  }

  @FXML
  public void loadSample() {
    modellingArea.add( new Cube() );
  }

  @FXML
  public void toggleDimensionMenu() {
    if ( !btDimensionMenu.isSelected() ) {
      GUIDimensionMenu.getInstance().hide();
    }
    else {
      GUIDimensionMenu.getInstance().toFront();
      GUIDimensionMenu.getInstance().setDimensionArea( modellingArea.getPaintingArea() );
    }
  }

  @FXML
  public void togglePaintingMenu() {
    if ( !btPaintingMenu.isSelected() ) {
      GUIPaintingMenu.getInstance().hide();
    }
    else {
      GUIPaintingMenu.getInstance().toFront();
      GUIPaintingMenu.getInstance().setPaintingArea( modellingArea.getPaintingArea() );
    }
  }

}
