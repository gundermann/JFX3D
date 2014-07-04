package graphiceditor;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.ComplexObject3DImpl;
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
		graphic.moveX(x);
		return this;
	}
	

	public Object3DBuilder y(double y) {
		graphic.moveY(y);
		return this;
	}
	
	public Object3D build(){
		return graphic;
	}


	public static CommonObject3D createKomplexShape(List<CommonObject3D> shapes, String title) {
		return new ComplexObject3DImpl(shapes, title);
	}


	public Object3DBuilder fromOther(Object3D object3d) {
		graphic.moveX(object3d.getXPositionProperty().get());
		graphic.moveY(object3d.getYPositionProperty().get());
		graphic.moveZ(object3d.getZPositionProperty().get());
		graphic.changeHeightTo(object3d.getHeightProperty().get());
		graphic.changeWidthTo(object3d.getWidthProperty().get());
		graphic.rotateX(object3d.getXRotationProperty().get());
		graphic.rotateY(object3d.getYRotationProperty().get());
		graphic.rotateZ(object3d.getZRotationProperty().get());
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
		complexShape.moveX(complexPref.getBeginningX());
		complexShape.moveY(complexPref.getBeginningY());
		complexShape.moveZ(complexPref.getBeginningZ());
		complexShape.rotateX(complexPref.getRotationX());
		complexShape.rotateY(complexPref.getRotationY());
		complexShape.rotateZ(complexPref.getRotationZ());
		return complexShape;
	}

}
