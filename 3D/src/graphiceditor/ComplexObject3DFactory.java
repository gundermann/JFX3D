package graphiceditor;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.impl.ComplexObject3DImpl;

import java.util.List;

public class ComplexObject3DFactory extends Object3DFactory{
	
	private static ComplexObject3DFactory _instance;
	
	public static ComplexObject3DFactory getInstance(){
		if(_instance == null)
			_instance = new ComplexObject3DFactory();
		return _instance;
	}
	
	public  CommonObject3D createKomplexShape(List<CommonObject3D> shapes, String title) {
		return new ComplexObject3DImpl(shapes, title);
	}
	
	
	@Override
	protected CommonObject3D createPlainObject3D() {
		return new ComplexObject3DImpl();
	}

}
