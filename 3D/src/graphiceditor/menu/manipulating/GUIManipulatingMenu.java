package graphiceditor.menu.manipulating;

import graphiceditor.business.Object3D;
import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.AbstractGUIMenu;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class GUIManipulatingMenu extends AbstractGUIMenu {

	private static GUIManipulatingMenu _instance;

	public static GUIManipulatingMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIManipulatingMenu(
					new ManipulatingMenuController());
		}
		 if ( !_instance.isVisible() ) {
		      _instance.setVisible( false );
		    }
		return _instance;
	}

	private ManipulatingMenuController controller;

	public GUIManipulatingMenu(
			ManipulatingMenuController manipulatingMenuController) {
		controller = manipulatingMenuController;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"manipulatingmanu.fxml"));
		fxmlLoader.setController(manipulatingMenuController);
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			Scene scene = SceneBuilder.create().root(page)
					.camera(PerspectiveCameraBuilder.create().build())
					.depthBuffer(true).build();
			setScene(scene);
			initStyle(StageStyle.UNDECORATED);
			setX(0);
			setY(500);
			show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPaintingArea(PaintingArea paintingArea) {
		controller.setPaintingArea(paintingArea);
	}

	public void setDisable(boolean disable) {
		getScene().getRoot().setDisable(disable);
	}

	public void setActualPainting(Object3D painting) {
		controller.setActualPainting(painting);
	}

	public void updateComponents() {
		controller.updateComponents();
	}
}
