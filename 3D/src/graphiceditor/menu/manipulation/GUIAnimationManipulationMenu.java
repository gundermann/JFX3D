package graphiceditor.menu.manipulation;

import graphiceditor.business.CommonObject3D;
import graphiceditor.menu.AbstractGUIMenu;
import graphiceditor.util.PropertyHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class GUIAnimationManipulationMenu extends AbstractGUIMenu {

	private static GUIAnimationManipulationMenu _instance;

	private BorderPane mainPane;

	private Map<Label, TextField> animationSettingUiElements;

	public static GUIAnimationManipulationMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIAnimationManipulationMenu();
		}
		if (!_instance.isVisible()) {
			_instance.setVisible(false);
		}
		return _instance;
	}

	private AnimationManipulationMenuController animationController;

	private Scene scene;

	private CommonObject3D actualPainting;

	public GUIAnimationManipulationMenu() {
		mainPane = new BorderPane();
		animationSettingUiElements = new HashMap<Label, TextField>();
		scene = SceneBuilder.create().root(mainPane).build();
		setScene(scene);
		setTitle("Animation");
		mainPane.setCenter(initPropertyChangingUIFromActualObject3D());
		mainPane.setBottom(initAnimationControlPanel());
		show();
	}

	private Node initPropertyChangingUIFromActualObject3D() {
		GridPane pane = new GridPane();
		int i = 0;
		if (actualPainting != null) {
			for (String name : PropertyHelper.getInstance().getPropertyNames(actualPainting)) {
					Label label = new Label(name
							+ ": ");
					TextField tf = new TextField();
					pane.add(label, 0, i);
					pane.add(tf, 1, i);
					animationSettingUiElements.put(label, tf);
					i++;
			}
		}
		resize(i * 30);
		return pane;
	}

	private void resize(int height) {
		setHeight(100 + height);
	}

	public void setActualPainting(CommonObject3D painting) {
		this.actualPainting = painting;
		animationController.setActualPainting(actualPainting);
		mainPane.setCenter(initPropertyChangingUIFromActualObject3D());
	}

	private AnchorPane initAnimationControlPanel() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"animationcontrollpanel.fxml"));
		animationController = new AnimationManipulationMenuController();
		fxmlLoader.setController(animationController);
		AnchorPane page = new AnchorPane();
		try {
			page = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}

	public Map<Label, TextField> getUiElementsForAnimationSettings() {
		return animationSettingUiElements;
	}

	public CommonObject3D getActualPainting() {
		return actualPainting;
	}

}
