package graphiceditor;

import graphiceditor.gui.controller.MainController;
import graphiceditor.gui.controller.PaintingAreaController;
import graphiceditor.util.TextFieldDialog;

public class PaintingAreaFactory {

	private static PaintingAreaFactory _instance;

	public static PaintingAreaFactory getInstance() {
		if (_instance == null)
			_instance = new PaintingAreaFactory();
		return _instance;
	}

	private MainController paintingAreaContainer;

	public boolean createPaintingArea(String name) {
		if(paintingAreaContainer.doesNameExist(name)){
			return false;
		}
		paintingAreaContainer.addArea(new PaintingAreaController(name));
		return true;
	}

	public void initCreation(MainController mainController) {
		paintingAreaContainer = mainController;
		new TextFieldDialog(this);
	}

}
