package graphiceditor.menu.dimension;

import graphiceditor.gui.DimensionArea;
import graphiceditor.menu.AbstractGUIMenu;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class GUIDimensionMenu extends AbstractGUIMenu {

	private static GUIDimensionMenu _instance;

	private final DimensionMenuController controller;

	public GUIDimensionMenu(DimensionMenuController dimensionMenuController) {
		controller = dimensionMenuController;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"dimensionmenu.fxml"));
		fxmlLoader.setController(dimensionMenuController);
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			getChildren().add(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static GUIDimensionMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIDimensionMenu(new DimensionMenuController());
		}
		if (!_instance.isVisible()) {
			_instance.setVisible(false);
		}
		return _instance;
	}

	public void setDimensionArea(DimensionArea dimensionArea) {
		controller.setDimensionArea(dimensionArea);
	}

	@Override
	public String getTitle() {
		return "Dimensions";
	}

}
