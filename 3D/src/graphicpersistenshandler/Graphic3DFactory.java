package graphicpersistenshandler;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;
import graphicpersistenshandler.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.List;

public class Graphic3DFactory {

	public static List<CommonObject3D> convertPreferencesTo3DGraphics(List<ShapePreference> prefs) {
		List<CommonObject3D> graphicObjects = new ArrayList<CommonObject3D>();
		for (ShapePreference preference : prefs) {
			Object3D point = preference.createShape();
			graphicObjects.add(point);
		}

		return graphicObjects;
	}

}
