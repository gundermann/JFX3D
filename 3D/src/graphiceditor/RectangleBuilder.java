package graphiceditor;

import graphiceditor.business.impl.Rectangle3D;

public class RectangleBuilder {

	
	private  Rectangle3D rect;
	private static RectangleBuilder _instance;

	public static RectangleBuilder create() {
		_instance = new RectangleBuilder();
		_instance.rect = new Rectangle3D();
		return _instance;
	}

	public RectangleBuilder x(double x) {
		rect.setX(x);
		return this;
	}
	
	public RectangleBuilder y(double y) {
		rect.setY(y);
		return this;
	}

	public Rectangle3D build() {
		return rect;
	}

}
