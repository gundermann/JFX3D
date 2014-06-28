package graphiceditor;

import graphiceditor.gui.controller.MainController;
import graphiceditor.gui.controller.PaintingAreaController;
import graphiceditor.util.Setup;
import graphiceditor.util.TextDialog;
import graphiceditor.util.TextFieldDialog;

public class PaintingAreaFactory implements Setup {

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

	public void load(MainController mainController, String name){
		paintingAreaContainer = mainController;
		createPaintingArea(name);
	}
	
	public void initCreation(MainController mainController) {
		paintingAreaContainer = mainController;
		TextFieldDialog.showSetup(this);;
	}

	@Override
	public void setText(String text) {
		if(!createPaintingArea(text)){
			TextFieldDialog.showSetup(this);
			new TextDialog();
		}
	}

}
