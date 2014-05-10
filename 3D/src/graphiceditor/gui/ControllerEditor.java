package graphiceditor.gui;

import graphiceditor.ModellingAreaFactory;
import graphiceditor.sample.Cube;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ControllerEditor {

  @FXML
  private BorderPane content;

  private ModellingArea modellingArea;

  @FXML
  public void initNewObject() {
    modellingArea = ModellingAreaFactory.getInstance().createModellingArea();
  }

  @FXML
  public void loadSample() {
    modellingArea.add( new Cube() );
  }

  @FXML
  public void toggleDimensionMenu() {
    new DimensionMenuController( modellingArea.getDimensionArea() );
  }

  @FXML
  public void togglePaintingMenu() {
    new PaintingMenuController( modellingArea.getPaintingArea() );
  }

}
