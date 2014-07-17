package graphiceditor.menu.manipulation.animation;

import graphiceditor.menu.manipulation.GUIManipulatingMenu;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class GUIAminationManipulationMenu extends GUIManipulatingMenu {

	private static GUIAminationManipulationMenu _instance;

	private BorderPane mainPane = new BorderPane();

	public static GUIAminationManipulationMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIAminationManipulationMenu();
		}
		if (!_instance.isVisible()) {
			_instance.setVisible(false);
		}
		return _instance;
	}

	private ComplexAnimationManipulatingMenuController controller;
	private Scene scene;

	public GUIAminationManipulationMenu() {
		super();
	}

	@Override
	public void setupScene() {
		super.setupScene();
		scene.setRoot(mainPane);
		mainPane.setBottom(initAnimationControlPanel());
	}

	private AnchorPane initAnimationControlPanel() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"animationcontrollpanel.fxml"));
		fxmlLoader.setController(controller);
		AnchorPane page = new AnchorPane();
		try {
			page = (AnchorPane) fxmlLoader.load();
			updateScene(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public void updateScene(AnchorPane page) {
		mainPane.setCenter(page);
	}
}
