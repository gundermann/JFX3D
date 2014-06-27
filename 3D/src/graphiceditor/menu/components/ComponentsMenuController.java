package graphiceditor.menu.components;

import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.AbstractMenuController;
import graphiceditor.menu.manipulating.GUIManipulatingMenu;
import graphiceditor.util.ShapeSummarizer;
import graphiceditor.util.StageingArea;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class ComponentsMenuController extends AbstractMenuController implements Initializable{

	@FXML
	private ListView<String> lvComponents;

	@FXML
	private MenuItem miSummarize;
	
	private PaintingArea actualPaintingArea;

	public void updateComponents() {
		lvComponents.getItems().setAll(
				this.actualPaintingArea.getAllGraphicObjectsAsString());
	}

	public void setPaintingArea(PaintingArea paintingArea) {
		this.actualPaintingArea = paintingArea;
		updateComponents();
	}
	
	@FXML
	public void checkPossibleActions(){
			miSummarize.setDisable(!(getSelectedIndices().size() > 1));
	}
	
	@FXML
	public void summarize(){
		ShapeSummarizer.getInstance().summazire(actualPaintingArea, getSelectedIndices());
	}

	@FXML
	public void componentSelected() {
		if (getSelectedIndices().size() ==1) {
			actualPaintingArea.setActualPaintingById(getSelectedIndices().get(0));
			GUIManipulatingMenu.getInstance().setActualPainting(
					actualPaintingArea.getActualPainting());
		}
	}
	
	@FXML
	public void deleteComponent(){
		if (!lvComponents.getSelectionModel().isEmpty()) {
			actualPaintingArea.removeByIndex(getSelectedIndices());
		}
	}
	
	@FXML
	public void copyComponent(){
		if (!lvComponents.getSelectionModel().isEmpty()) {
			StageingArea.getInstance().copy(actualPaintingArea.getAllGraphicObjects(), getSelectedIndices());
		}
	}
	
	@FXML
	public void pasteComponent(){
		if (StageingArea.getInstance().hasStagedObject()) {
			actualPaintingArea.addAll( StageingArea.getInstance().paste());
		}
	}

	public List<Integer> getSelectedIndices(){
		return lvComponents.getSelectionModel().getSelectedIndices();
	}
	
	@Override
	protected Stage getUI() {
		return GUIComponentsMenu.getInstance();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lvComponents.getSelectionModel().selectionModeProperty().set(SelectionMode.MULTIPLE);
	}

}
