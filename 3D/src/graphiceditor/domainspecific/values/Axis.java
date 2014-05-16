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
	private Point3D pivot;
	private Point3D direction;

	public Axis(Point3D pivot, Point3D direction, AngleProperty angleProperty) {
		this.pivot = pivot;
		this.direction = direction;
		this.angleProperty = angleProperty;
	}

	public Axis(Point3D pivot, Point3D direction, AngleProperty angleProperty,
			double width) {
		new Axis(pivot, direction, angleProperty);
	}

	public Point3D getDirectionPoint() {
		return this.direction;
	}

	public double getPivotX() {
		return pivot.getX();
	}

	public double getPivotY() {
		return pivot.getY();
	}

	public double getPivotZ() {
		return pivot.getZ();
	}

	public double getActualAngle() {
		return angleProperty.get();
	}

	//Wenn um eine andere Achse gedreht wird, verändert sich hier die Richtung der Achse
	//Pivot bleibt immer gleich --> Vorerst refactorn, damit man noch durchsieht.
	public void updateDirection() {
	}

	public ObservableValue<? extends Number> getAngleProperty() {
		return angleProperty;
	}

}
