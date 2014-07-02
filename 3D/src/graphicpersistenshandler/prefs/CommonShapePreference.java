package graphicpersistenshandler.prefs;

import graphiceditor.shapes.CommonObject3D;

public interface CommonShapePreference {

	public String getPrefType();

	public CommonObject3D createShape();
	
}
