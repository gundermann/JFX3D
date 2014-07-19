package graphiceditor.menu.manipulation;

import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.Property;
import graphiceditor.menu.AbstractGUIMenu;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GUIAnimationManipulationMenu extends AbstractGUIMenu {

	private static GUIAnimationManipulationMenu _instance;

	private BorderPane mainPane;

	public static GUIAnimationManipulationMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIAnimationManipulationMenu();
		}
		if (!_instance.isVisible()) {
			_instance.setVisible(false);
		}
		return _instance;
	}

	private ComplexAnimationManipulatingMenuController animationController;

	private ComplexManipulatingMenuController manipulationController;

	private Scene scene;

	private CommonObject3D actualPainting;

	public GUIAnimationManipulationMenu() {
		mainPane = new BorderPane();
		scene = SceneBuilder.create().root(mainPane).build();
		setScene(scene);
		setTitle("Animation");
		mainPane.setCenter(initPropertyChangingUIFromActualObject3D());
		mainPane.setBottom(initAnimationControlPanel());
		show();
	}

	private Node initPropertyChangingUIFromActualObject3D() {
		if(actualPainting == null)
			return new Pane();
		
		GridPane pane = new GridPane();
		int i = 0;
		Method[] annotations = actualPainting.getClass().getMethods();
		for (Method method : annotations) {
			Property annotation = method.getAnnotation(Property.class);
			if(annotation != null){
				Label label = new Label(annotation.name().toUpperCase()+": ");
				TextField tf = new TextField();
				pane.add(label, 0, i);
				pane.add(label, 1, i);
				i++;
			}
		}
 		return pane;
	}

	public void setActualPainting(CommonObject3D painting) {
		this.actualPainting = painting;
		mainPane.setCenter(initPropertyChangingUIFromActualObject3D());
	}


	private AnchorPane initAnimationControlPanel() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"animationcontrollpanel.fxml"));
		fxmlLoader.setController(animationController);
		AnchorPane page = new AnchorPane();
		try {
			page = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}

}
