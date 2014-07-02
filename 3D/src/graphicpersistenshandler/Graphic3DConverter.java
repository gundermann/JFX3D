package graphicpersistenshandler;

import graphiceditor.shapes.CommonObject3D;
import graphicpersistenshandler.prefs.CommonShapePreference;

import java.util.ArrayList;
import java.util.List;

public class Graphic3DConverter {

	private static Graphic3DConverter _instance;

	public static Graphic3DConverter getInstance() {
		if (_instance == null) {
			_instance = new Graphic3DConverter();
		}
		return _instance;
	}

	public List<CommonObject3D> convertPreferencesTo3DGraphics(
			List<CommonShapePreference> prefs) {
		List<CommonObject3D> graphicObjects = new ArrayList<CommonObject3D>();
		for (CommonShapePreference preference : prefs) {
				CommonObject3D point = preference.createShape();
				graphicObjects.add(point);
		}
		return graphicObjects;
	}

}
