package graphiceditor.menu.manipulating;

import graphiceditor.menu.AbstractGUIMenu;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class GUIManipulatingMenu extends AbstractGUIMenu {

	private static GUIManipulatingMenu _instance;

	public static GUIManipulatingMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIManipulatingMenu();
		}
		if (!_instance.isVisible()) {
			_instance.setVisible(false);
		}
		return _instance;
	}

	private ComplexManipulatingMenuController controller;
	private Scene scene;

	public GUIManipulatingMenu() {
		scene = SceneBuilder.create().build();
		setScene(scene);
		initStyle(StageStyle.UNDECORATED);
		setX(0);
		setY(510);
		if (controller == null)
			switchToComplexMode();
		show();
	}

	public void setActualPainting(CommonObject3D painting) {
		if (painting instanceof Object3D)
			switchToObject3DMode();
		else
			switchToComplexMode();
		controller.setActualPainting(painting);
	}

	private void switchToComplexMode() {
		controller = new ComplexManipulatingMenuController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"complexmanipulatingmenu.fxml"));
		fxmlLoader.setController(controller);
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			scene.setRoot(page);
			setScene(scene);
			setHeight(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void switchToObject3DMode() {
		controller = new ManipulatingMenuController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"manipulatingmenu.fxml"));
		fxmlLoader.setController(controller);
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			scene = SceneBuilder.create().root(page).build();
			setScene(scene);
			setHeight(500);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
