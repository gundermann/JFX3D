package graphiceditor.domainspecific.values;

import javafx.scene.transform.Rotate;

public class Rotation extends Rotate {

	private Axis rotationAxis;

	public Rotation(Axis rotationAxis) {
		this.rotationAxis = rotationAxis;
		axisProperty().set(rotationAxis.getDirectionPoint());
		pivotXProperty().set(rotationAxis.getPivotX());
		pivotYProperty().set(rotationAxis.getPivotY());
		pivotZProperty().set(rotationAxis.getPivotZ());
		angleProperty().set(rotationAxis.getActualAngle());
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

}
