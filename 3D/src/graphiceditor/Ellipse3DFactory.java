package graphiceditor;

import graphiceditor.business.Object3D;
import graphiceditor.business.impl.Ellipse3D;

public class Ellipse3DFactory extends Object3DFactory {

	private static Object3DFactory _instance;

	@Override
	public Object3D createPlainObject3D() {
		return new Ellipse3D();
	}

	public static Object3DFactory getInstance() {
		if(_instance == null)
			_instance = new Ellipse3DFactory();
		return _instance;
	}

	@Override
	public String getType() {
		return "Ellipse";
	}

}
