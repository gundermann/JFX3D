package graphiceditor;

import graphiceditor.business.Object3D;
import graphiceditor.business.impl.Rectangle3D;

public class Rectangle3DFactory extends Object3DFactory {

	private static Object3DFactory _instance;

	@Override
	public Object3D createPlainObject3D() {
		return new Rectangle3D();
	}

	public static Object3DFactory getInstance() {
		if(_instance == null)
			_instance = new Rectangle3DFactory();
		return _instance;
	}

}
