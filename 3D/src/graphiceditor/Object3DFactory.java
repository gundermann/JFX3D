package graphiceditor;

import graphiceditor.business.CommonObject3D;

import java.util.List;

import javafx.beans.property.DoubleProperty;
import preferencemenu.PropertyHelper;

abstract public class Object3DFactory {
	
	
	public CommonObject3D create(double x, double y) {
		CommonObject3D o3d = createPlainObject3D();
		o3d.moveToX(x);
		o3d.moveToY(y);
		return o3d;
	}

	abstract public CommonObject3D createPlainObject3D();

	public CommonObject3D fromOther(CommonObject3D object3d){
		CommonObject3D newObject3D = object3d.getFactory().create(0, 0);
		List<String> propertyNames = PropertyHelper.getInstance().getPropertyNames(object3d);
		for (String property : propertyNames) {
			DoubleProperty propertyValue = PropertyHelper.getInstance().getProperty(property, object3d);
			PropertyHelper.getInstance().invokeChangingMethod(property, propertyValue.getValue(), newObject3D);
		}
		return newObject3D;
	}

	public String getType(){
		return this.getClass().getName();
	}
}
