package graphiceditor.domainspecific.values;

import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;

public class Rotation extends Rotate {

	private Axis rotationAxis;

	public Rotation(Axis rotationAxis) {
		this.rotationAxis = rotationAxis;
		axisProperty().set(rotationAxis.getAxis());
		angleProperty().set(rotationAxis.getActualAngle());
		enable();
	}
	
	public void enable(){
		angleProperty().bind(rotationAxis.getAngleProperty());
	}

	public void disable() {
		angleProperty().unbind();
		angleProperty().set(rotationAxis.getActualAngle());
	}
	
	public Axis getRotationAxis(){
		return rotationAxis;
	}

	public void setPivot(Point3D pivot) {
		setPivotX(pivot.getX());
		setPivotY(pivot.getY());
		setPivotZ(pivot.getZ());
	}

}
