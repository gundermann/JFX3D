package graphicpersistenshandler.prefs.impl;

import graphiceditor.Object3DBuilder;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;
import graphicpersistenshandler.PreferenceFactory;
import graphicpersistenshandler.prefs.CommonShapePreference;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.List;

public class ComplexPref implements ComplexShapePreference {

	private List<ShapePreference> prefs = new ArrayList<ShapePreference>();
	
	private String title = "Complex";

	public ComplexPref(String title , List<ShapePreference> graphicObjects){
		this.title = title;
		this.prefs = graphicObjects;
	}

	public ComplexPref(ComplexObject3D graphicObject) {
		this.title = graphicObject.toString();
		List<ShapePreference> graphicList = new ArrayList<ShapePreference>();
		for(CommonObject3D graphic : graphicObject.getShapes()){
			graphicList.add(PreferenceFactory.getInstance().createPrefFromObject3D(graphic));
		}
			
		this.prefs = graphicList ;
	}
	

	@Override
	public CommonObject3D createShape() {
		List<CommonObject3D> commonGraphicObjects = new ArrayList<CommonObject3D>();
		for(CommonShapePreference pref : prefs){
			commonGraphicObjects.add(pref.createShape());
		}
		return Object3DBuilder.createKomplexShape(commonGraphicObjects, title);
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
