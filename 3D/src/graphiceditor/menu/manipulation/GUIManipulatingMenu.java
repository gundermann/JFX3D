package graphiceditor.menu.manipulation;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.Object3D;
import graphiceditor.menu.AbstractGUIMenu;

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
		setupScene();
		if (controller == null)
			switchToComplexMode();
		show();
	}
	
	public void setupScene(){
		scene = SceneBuilder.create().build();
		setScene(scene);
		initStyle(StageStyle.UNDECORATED);
		setX(0);
		setY(510);
	}

	public void setActualPainting(CommonObject3D painting) {
		if (painting instanceof Object3D)
			switchToObject3DMode();
		else
			switchToComplexMode();
		controller.setActualPainting(painting);
	}

	protected void switchToComplexMode() {
		controller = new ComplexManipulatingMenuController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"complexmanipulatingmenu.fxml"));
		fxmlLoader.setController(controller);
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			updateScene(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateScene(AnchorPane page) {
		scene.setRoot(page);
		setScene(scene);
		setHeight(500);
	}

	protected void switchToObject3DMode() {
		controller = new ManipulatingMenuController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"manipulatingmenu.fxml"));
		fxmlLoader.setController(controller);
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			updateScene(page);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
