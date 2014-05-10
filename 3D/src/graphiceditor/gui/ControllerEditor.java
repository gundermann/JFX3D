package graphiceditor.gui;

import graphiceditor.ModellingAreaFactory;
import graphiceditor.graphicobjects.Painting;
import graphiceditor.sample.Cube;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ControllerEditor {

  @FXML
  private BorderPane content;

  private ModellingArea paintingArea;

  @FXML
  public void initNewObject() {
    paintingArea = ModellingAreaFactory.getInstance().createModellingArea();
  }

  @FXML
  public void toggleRotation() {
    paintingArea.enableRotation();
  }

  @FXML
  public void loadSample() {
    paintingArea.add( new Cube() );
  }

  @FXML
  public void selectPaintRect() {
    paintingArea.initPainting( Painting.Rectangle );
  }
}
