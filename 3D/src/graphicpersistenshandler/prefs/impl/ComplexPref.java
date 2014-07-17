package graphicpersistenshandler.prefs.impl;

import graphiceditor.Object3DBuilder;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;
import graphicpersistenshandler.PreferenceFactory;
import graphicpersistenshandler.prefs.AbstractShapePreference;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComplexPref extends AbstractShapePreference implements
		ComplexShapePreference {

	private List<ShapePreference> prefs = new ArrayList<ShapePreference>();

	public ComplexPref(Map<String, String> prefs, List<ShapePreference> graphicObjects) {
		setPrefValues(prefs);
		this.prefs = graphicObjects;
	}

	public ComplexPref(ComplexObject3D graphicObject) {
		setTitle(graphicObject.toString());
		List<ShapePreference> graphicList = new ArrayList<ShapePreference>();
		for (CommonObject3D graphic : graphicObject.getShapes()) {
			graphicList.add(PreferenceFactory.getInstance()
					.createPrefFromObject3D(graphic));
		}
		this.prefs = graphicList;

		setBeginningX(graphicObject.getXPositionProperty().get());
		setBeginningY(graphicObject.getYPositionProperty().get());
		setBeginningZ(graphicObject.getZPositionProperty().get());
		setRotationX(graphicObject.getXRotationProperty().get());
		setRotationY(graphicObject.getYRotationProperty().get());
		setRotationZ(graphicObject.getZRotationProperty().get());
	}

	@Override
	public CommonObject3D createShape() {
		return Object3DBuilder.createKomplexShapeFromPref(this);
	}

	@Override
	public String getPrefType() {
		return "complex";
	}

	@Override
	public List<ShapePreference> getGraphicPrefs() {
		return prefs;
	}
}
