package graphiceditor.util;

import java.util.ArrayList;
import java.util.List;

import graphiceditor.Object3DBuilder;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;
import graphiceditor.business.Object3D;

public class Cloner {
	
	private static Cloner _instance;
	
	
	public static Cloner getInstance() {
		if (_instance == null) {
			_instance = new Cloner();
		}
		return _instance;
	}

	public  CommonObject3D createCopy(CommonObject3D commonObject3D) {
		if(commonObject3D instanceof ComplexObject3D){
			return createCopyOfComplexObject3D((ComplexObject3D) commonObject3D);
		}
		if(commonObject3D instanceof Object3D){
			return createCopyOfObject3D((Object3D) commonObject3D);
		}
		return null;
	}

	private  CommonObject3D createCopyOfObject3D(Object3D object3D) {
		return Object3DBuilder.create(object3D.getClass()).fromOther(object3D).build();
		
	}

	private  CommonObject3D createCopyOfComplexObject3D(
			ComplexObject3D original) {
		List<CommonObject3D> object3DList = new ArrayList<CommonObject3D>();
		for(CommonObject3D partOfcomplex : original.getShapes()){
			object3DList.add(createCopy(partOfcomplex));
		}
		 CommonObject3D duplicate = Object3DBuilder.createKomplexShape(object3DList , original.toString());
		 duplicate.getXPositionProperty().set(original.getXPositionProperty().get());
		 duplicate.getYPositionProperty().set(original.getYPositionProperty().get());
		 duplicate.getZPositionProperty().set(original.getZPositionProperty().get());
		 duplicate.getXRotationProperty().set(original.getXRotationProperty().get());
		 duplicate.getYRotationProperty().set(original.getYRotationProperty().get());
		 duplicate.getZRotationProperty().set(original.getZRotationProperty().get());
		 return duplicate;
	}

}
