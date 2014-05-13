package graphiceditor.gui.transform;

import graphiceditor.gui.observable.AngleProperty;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;

public class Rotation extends Rotate {

	private AngleProperty angleProperty;

	public Rotation(Point3D rotationAxis, AngleProperty angleProperty,
			double pivotX, double pivotY) {
		this.angleProperty = angleProperty;
		
		axisProperty().set(rotationAxis);
		pivotXProperty().set(pivotX);
		pivotYProperty().set(pivotY);
		pivotZProperty().set(0);
		angleProperty().set(angleProperty.get());
	}
	
	public void enable(){
		angleProperty().bind(angleProperty);
	}

	public void disable() {
		angleProperty().unbind();
		angleProperty().set(angleProperty.get());
	}

}
