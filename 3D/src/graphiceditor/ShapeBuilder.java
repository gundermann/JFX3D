package graphiceditor;

import graphiceditor.shapes.Object3D;

public class ShapeBuilder {
	private  Object3D graphic;
	private static ShapeBuilder _instance;
	
	public static  ShapeBuilder create(Class<? extends Object3D> clazz) {
		try {
		_instance = new ShapeBuilder();
			_instance.graphic = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return _instance;
	}
	

	public ShapeBuilder x(double x) {
		graphic.setupX(x);
		return this;
	}
	

	public ShapeBuilder y(double y) {
		graphic.setupY(y);
		return this;
	}
	
	public Object3D build(){
		return graphic;
	}

}
