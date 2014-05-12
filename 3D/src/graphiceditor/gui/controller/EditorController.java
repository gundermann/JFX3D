package graphiceditor.gui.controller;

import graphiceditor.PaintingAreaFactory;
import graphiceditor.gui.GUIDimensionMenu;
import graphiceditor.gui.GUIPaintingMenu;
import graphiceditor.gui.PaintingArea;
import graphiceditor.sample.Cube;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;

public class EditorController implements Initializable {

  @FXML
  private ToggleButton btDimensionMenu;

  @FXML
  private ToggleButton btPaintingMenu;

  @FXML
  private ChoiceBox<String> paintingAreaSelection;

  private final List<PaintingArea> paintingAreas = new ArrayList<PaintingArea>();

  @FXML
  public void initNewObject() {
    PaintingArea paintingArea = PaintingAreaFactory.getInstance().createPaintingArea();
    paintingAreas.add( paintingArea );
    // FIXME use binding
    paintingAreaSelection.getItems().add( paintingArea.toString() );
    paintingAreaSelection.getSelectionModel().selectLast();
    paintingAreaSelection.setDisable( false );
    btDimensionMenu.setDisable( false );
    btPaintingMenu.setDisable( false );
  }

  public PaintingArea getSelectedPaintingArea() {
    int selectedIndex = paintingAreaSelection.getSelectionModel().getSelectedIndex();
    return paintingAreas.get( selectedIndex );
  }

  public void selectPaintingArea() {
    GUIDimensionMenu.getInstance().setDimensionArea( getSelectedPaintingArea() );
    GUIPaintingMenu.getInstance().setPaintingArea( getSelectedPaintingArea() );
    getSelectedPaintingArea().getUI().toFront();
  }

  @FXML
  public void loadSample() {
    getSelectedPaintingArea().add( new Cube() );
  }

  @FXML
  public void toggleDimensionMenu() {
    if ( !btDimensionMenu.isSelected() ) {
      GUIDimensionMenu.getInstance().hide();
    }
    else {
      GUIDimensionMenu.getInstance().toFront();
      GUIDimensionMenu.getInstance().setDimensionArea( getSelectedPaintingArea() );
    }
  }

  @FXML
  public void togglePaintingMenu() {
    if ( !btPaintingMenu.isSelected() ) {
      GUIPaintingMenu.getInstance().hide();
    }
    else {
      GUIPaintingMenu.getInstance().toFront();
      GUIPaintingMenu.getInstance().setPaintingArea( getSelectedPaintingArea() );
    }
  }

  @Override
  public void initialize( URL paramURL, ResourceBundle paramResourceBundle ) {
    // FIXME
    paintingAreaSelection.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<String>() {

      @Override
      public void changed( ObservableValue<? extends String> paramObservableValue, String paramT1, String paramT2 ) {
        selectPaintingArea();
      }
    } );
  }
}
