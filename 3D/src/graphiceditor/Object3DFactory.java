package graphiceditor;

import graphiceditor.business.Object3D;

abstract public class Object3DFactory {
	
	
	public Object3D create(double x, double y) {
		Object3D o3d = createPlainObject3D();
		o3d.moveToX(x);
		o3d.moveToY(y);
		return o3d;
	}

	abstract protected Object3D createPlainObject3D();

	public Object3D fromOther(Object3D object3d) {
		Object3D o3g = createPlainObject3D();
		o3g.moveToX(object3d.getXPositionProperty().get());
		o3g.moveToY(object3d.getYPositionProperty().get());
		o3g.moveToZ(object3d.getZPositionProperty().get());
		o3g.changeHeightTo(object3d.getHeightProperty().get());
		o3g.changeWidthTo(object3d.getWidthProperty().get());
		o3g.rotateXTo(object3d.getXRotationProperty().get());
		o3g.rotateYTo(object3d.getYRotationProperty().get());
		o3g.rotateZTo(object3d.getZRotationProperty().get());
		o3g.setColor(object3d.getColor());
		return o3g;
	}

}
