package graphiceditor.domainspecific.values;

import graphiceditor.domainspecific.values.observable.AngleProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point3D;
import javafx.geometry.Point3DBuilder;

public class Axis {

	public static final Point3D X = Point3DBuilder.create().x(1000).y(0).z(0)
			.build();
	public static final Point3D Y = Point3DBuilder.create().x(0).y(-1000).z(0)
			.build();
	public static final Point3D Z = Point3DBuilder.create().x(0).y(0).z(1000)
			.build();
	private AngleProperty angleProperty;
	private Point3D axis;
	
	public Axis( Point3D axis, AngleProperty angleProperty) {
		this.axis = axis;
		this.angleProperty = angleProperty;
	}

	public double getActualAngle() {
		return angleProperty.get();
	}

	public ObservableValue<? extends Number> getAngleProperty() {
		return angleProperty;
	}

	public Point3D getAxis() {
		return axis;
	}
	
}
