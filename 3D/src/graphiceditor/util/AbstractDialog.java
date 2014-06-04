package graphiceditor.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class AbstractDialog {
	
	private Stage stage;

	public AbstractDialog() {
		stage = new Stage();
		FXMLLoader loader = initLoader();
		loader.setController(this);
		try {
			AnchorPane a = (AnchorPane) loader.load();
			Scene s = new Scene(a);
			stage.setScene(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		stage.initStyle( StageStyle.UNDECORATED );
		stage.show();
	}

	abstract protected FXMLLoader initLoader();

	public Stage getStage() {
		return stage;
	}
	
	
}
