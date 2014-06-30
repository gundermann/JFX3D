package graphiceditor;

import java.util.List;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;
import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.ComplexObject3DImpl;

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
		graphic.setupX(x);
		return this;
	}
	

	public Object3DBuilder y(double y) {
		graphic.setupY(y);
		return this;
	}
	
	public Object3D build(){
		return graphic;
	}


	public static CommonObject3D createKomplexShape(List<CommonObject3D> shapes, String title) {
		return new ComplexObject3DImpl(shapes, title);
	}


	public Object3DBuilder fromOther(Object3D object3d) {
		graphic.setupX(object3d.getXPositionProperty().get());
		graphic.setupY(object3d.getYPositionProperty().get());
		graphic.moveZ(object3d.getZPositionProperty().get());
		graphic.changeHeightTo(object3d.getHeightProperty().get());
		graphic.changeWidthTo(object3d.getWidthProperty().get());
		graphic.rotateX(object3d.getXRotationProperty().get());
		graphic.rotateY(object3d.getYRotationProperty().get());
		graphic.rotateZ(object3d.getZRotationProperty().get());
		graphic.setColor(object3d.getColor());
		return this;
	}

}
