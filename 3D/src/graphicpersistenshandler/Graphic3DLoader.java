package graphicpersistenshandler;

import graphiceditor.business.CommonObject3D;
import graphicpersistenshandler.prefs.ShapePreference;
import graphicpersistenshandler.tasks.LoadingTask;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Graphic3DLoader extends AbstractGraphic3DPersister {

	private static final String NAME = "name";

	private static Graphic3DLoader _instance;

	public static Graphic3DLoader getInstace() {
		if (_instance == null) {
			_instance = new Graphic3DLoader();
		}
		return _instance;
	}

	
	public List<CommonObject3D> loadShapes(File file) {
		Task<List<ShapePreference>> loading = new LoadingTask(file);
		new Thread(loading).start();
		try {
			return Graphic3DConverter.getInstance().convertPreferencesTo3DGraphics(
					loading.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public File initLoading() {
		FileChooser filechooser = new FileChooser();
		return filechooser.showOpenDialog(new Stage());
	}
}
