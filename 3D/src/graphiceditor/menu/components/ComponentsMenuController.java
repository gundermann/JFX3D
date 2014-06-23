package graphiceditor.menu.components;

import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.manipulating.GUIManipulatingMenu;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ComponentsMenuController {

	@FXML
	private ListView<String> lvComponents;

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
	public void componentSelected() {
		actualPaintingArea.setActualPaintingById(lvComponents
				.getSelectionModel().getSelectedIndex());
		GUIManipulatingMenu.getInstance().setActualPainting(
				actualPaintingArea.getActualPainting());
	}
}
