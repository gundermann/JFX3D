package graphiceditor.gui;

import graphiceditor.menu.MenuBar;

import java.awt.Toolkit;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIMain extends Stage {

	private static GUIMain _instance;
	private BorderPane border;

	public GUIMain() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"fxml/main.fxml"));
		AnchorPane page;
		try {
			page = (AnchorPane) fxmlLoader.load();
			border = new BorderPane();
			Scene scene = SceneBuilder.create().root(border).build();
			setScene(scene);
			border.setTop(page);
			border.setLeft(MenuBar.getInstance());
			initStyle(StageStyle.UNDECORATED);
			setWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
			setHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
			setX(0);
			setY(0);
			show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static GUIMain getInstance() {
		if (_instance == null) {
			_instance = new GUIMain();
		}
		return _instance;
	}

	public void setPaintingArea(PaintingArea paintingAreaController) {
		border.setCenter(paintingAreaController.getUI());
	}

}
