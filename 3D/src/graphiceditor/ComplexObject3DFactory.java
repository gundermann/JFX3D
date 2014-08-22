package graphiceditor;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.impl.ComplexObject3DImpl;
import graphicpersistenshandler.prefs.ShapePreference;
import graphicpersistenshandler.prefs.impl.ComplexPref;

import java.util.ArrayList;
import java.util.List;

public class ComplexObject3DFactory {
	
	private static ComplexObject3DFactory _instance;
	
	public static ComplexObject3DFactory getInstance(){
		if(_instance == null)
			_instance = new ComplexObject3DFactory();
		return _instance;
	}
	
	public  CommonObject3D createKomplexShape(List<CommonObject3D> shapes, String title) {
		return new ComplexObject3DImpl(shapes, title);
	}
	public  CommonObject3D createKomplexShapeFromPref(
			ComplexPref complexPref) {
		List<CommonObject3D> commonGraphicObjects = new ArrayList<CommonObject3D>();
		for(ShapePreference pref : complexPref.getGraphicPrefs()){
			commonGraphicObjects.add(pref.createShape());
		}
		CommonObject3D complexShape = createKomplexShape(commonGraphicObjects, complexPref.getTitle());
		complexShape.moveToX(complexPref.getBeginningX());
		complexShape.moveToY(complexPref.getBeginningY());
		complexShape.moveToZ(complexPref.getBeginningZ());
		complexShape.rotateXTo(complexPref.getRotationX());
		complexShape.rotateYTo(complexPref.getRotationY());
		complexShape.rotateZTo(complexPref.getRotationZ());
		return complexShape;
	}

}
