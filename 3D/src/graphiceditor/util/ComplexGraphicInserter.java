package graphiceditor.util;

import graphiceditor.Object3DBuilder;
import graphiceditor.business.CommonObject3D;
import graphiceditor.gui.PaintingArea;
import graphicpersistenshandler.Graphic3DLoader;

import java.io.File;
import java.util.List;

public class ComplexGraphicInserter {

	private static ComplexGraphicInserter _instance;

	public static ComplexGraphicInserter getInstance() {
		if(_instance == null){
			_instance = new ComplexGraphicInserter();
		}
			return _instance;
	}

	public void insertFromFile(PaintingArea paintingArea) {
		File file = Graphic3DLoader.getInstace().initLoading();
		List<CommonObject3D> shapes = Graphic3DLoader.getInstace().getShapesFromLoader(file);
		CommonObject3D komplexShape = Object3DBuilder.createKomplexShape(shapes, file.getName());
		paintingArea.add(komplexShape);
	}

}
