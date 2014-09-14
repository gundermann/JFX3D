package graphiceditor;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.impl.ComplexObject3DImpl;
import graphiceditor.util.Cloner;

import java.util.ArrayList;
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
	public CommonObject3D createPlainObject3D() {
		return new ComplexObject3DImpl();
	}

	@Override
	public String getType() {
		return "complex";
	}

	@Override
	public CommonObject3D fromOther(CommonObject3D object3d) {
		List<CommonObject3D> object3DList = new ArrayList<CommonObject3D>();
		for (CommonObject3D partOfcomplex : ((ComplexObject3DImpl) object3d).getShapes()) {
			object3DList.add(Cloner.getInstance().createCopy(partOfcomplex));
		}
		CommonObject3D duplicate = ComplexObject3DFactory.getInstance()
				.createKomplexShape(object3DList, object3d.toString());
		duplicate.getXPositionProperty().set(
				object3d.getXPositionProperty().get());
		duplicate.getYPositionProperty().set(
				object3d.getYPositionProperty().get());
		duplicate.getZPositionProperty().set(
				object3d.getZPositionProperty().get());
		duplicate.getXRotationProperty().set(
				object3d.getXRotationProperty().get());
		duplicate.getYRotationProperty().set(
				object3d.getYRotationProperty().get());
		duplicate.getZRotationProperty().set(
				object3d.getZRotationProperty().get());
		return duplicate;
	}
	
}
