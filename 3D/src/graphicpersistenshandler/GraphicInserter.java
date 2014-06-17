package graphicpersistenshandler;

import graphiceditor.Object3DBuilder;
import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;

import java.io.File;
import java.util.List;

public class GraphicInserter {

	private static GraphicInserter _instance;

	public static GraphicInserter getInstance() {
		if(_instance == null){
			_instance = new GraphicInserter();
		}
			return _instance;
	}

	public void insertFromFile(PaintingArea paintingArea) {
		File file = Graphic3DLoader.getInstace().initLoading();
		List<Object3D> shapes = Graphic3DLoader.getInstace().getShapesFromLoader(file);
		CommonObject3D komplexShape = Object3DBuilder.createKomplexShape(shapes, "Complex");
		komplexShape.setTitle(file.getName());
		paintingArea.add(komplexShape);
	}

}
