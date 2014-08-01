package graphiceditor;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.Object3D;
import graphiceditor.business.impl.ComplexObject3DImpl;
import graphicpersistenshandler.prefs.ShapePreference;
import graphicpersistenshandler.prefs.impl.ComplexPref;

import java.util.ArrayList;
import java.util.List;

public class Object3DBuilder {
	private  Object3D graphic;
	private static Object3DBuilder _instance;
	
	public static  Object3DBuilder create(Class<? extends Object3D> clazz) {
		try {
		_instance = new Object3DBuilder();
			_instance.graphic = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return _instance;
	}
	

	public Object3DBuilder x(double x) {
		graphic.moveToX(x);
		return this;
	}
	

	public Object3DBuilder y(double y) {
		graphic.moveToY(y);
		return this;
	}
	
	public Object3D build(){
		return graphic;
	}


	public static CommonObject3D createKomplexShape(List<CommonObject3D> shapes, String title) {
		return new ComplexObject3DImpl(shapes, title);
	}


	public Object3DBuilder fromOther(Object3D object3d) {
		graphic.moveToX(object3d.getXPositionProperty().get());
		graphic.moveToY(object3d.getYPositionProperty().get());
		graphic.moveToZ(object3d.getZPositionProperty().get());
		graphic.changeHeightTo(object3d.getHeightProperty().get());
		graphic.changeWidthTo(object3d.getWidthProperty().get());
		graphic.rotateXTo(object3d.getXRotationProperty().get());
		graphic.rotateYTo(object3d.getYRotationProperty().get());
		graphic.rotateZTo(object3d.getZRotationProperty().get());
		graphic.setColor(object3d.getColor());
		return this;
	}

	public static CommonObject3D createKomplexShapeFromPref(
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
