package graphicloader;

import graphiceditor.shapes.Object3D;
import graphicloader.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.List;

public class Graphic3DFactory {

	public static List<Object3D> convertPreferencesTo3DGraphics(List<ShapePreference> prefs) {
		List<Object3D> graphicObjects = new ArrayList<Object3D>();
		for (ShapePreference preference : prefs) {
			Object3D point = preference.createShape();
			graphicObjects.add(point);
		}

		return graphicObjects;
	}

}
