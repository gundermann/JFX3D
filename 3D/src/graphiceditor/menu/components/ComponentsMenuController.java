package graphiceditor.menu.components;

import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.AbstractMenuController;
import graphiceditor.menu.manipulating.GUIManipulatingMenu;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ComponentsMenuController extends AbstractMenuController{

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

	@Override
	protected Stage getUI() {
		return GUIComponentsMenu.getInstance();
	}
}
