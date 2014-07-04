package graphicpersistenshandler.prefs;

import graphiceditor.shapes.CommonObject3D;

import java.util.Map;

public interface ShapePreference {

	public Map<String, String> getPreferences();

	public String getPrefType();

	public CommonObject3D createShape();
}
