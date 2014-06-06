package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.observable.AngleProperty;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point3D;
import javafx.geometry.Point3DBuilder;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Rectangle3D extends AbstractObject3D {

	public void setupX(double x) {
		((Rectangle) node).setX(0);
		((Rectangle) node).layoutXProperty().set(x);
		refreshTransforms();
	}

	public void setupY(double y) {
		((Rectangle) node).setY(0);
		((Rectangle) node).layoutYProperty().set(y);
		refreshTransforms();
	}

	@Override
	public void changeWidth(int i) {
		changeWidthTo(((Rectangle) node).getWidth() + i);
	}

	public void changeWidthTo(double newWidth) {
		((Rectangle) node).widthProperty().set(newWidth);
		refreshTransforms();
	}

	public void changeHeightTo(double newHeight) {
		((Rectangle) node).heightProperty().set(newHeight);
		refreshTransforms();
	}

	@Override
	public void changeHeight(int i) {
		changeHeightTo(((Rectangle) node).getHeight() + i);
	}

	@Override
	public DoubleProperty getHeightProperty() {
		return ((Rectangle) node).heightProperty();
	}

	@Override
	public DoubleProperty getWidthProperty() {
		return ((Rectangle) node).widthProperty();
	}

	@Override
	protected Class<? extends Node> getNodeClass() {
		return Rectangle.class;
	}

	@Override
	protected Point3D getPivot() {
		return Point3DBuilder.create().x(getXPositionProperty().get())
				.y(getYPositionProperty().get())
				.z(getZPositionProperty().get()).build();
	}

	@Override
	public String toString() {
		return "Rectangle";
	}

	@Override
	protected void refreshTransforms() {
		rotationBundle.clear();
		rotationBundle.addRotationOfAxis(new Axis(getPivot(), Axis.X,
				new AngleProperty(xRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(getPivot(), Axis.Y,
				new AngleProperty(yRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(getPivot(), Axis.Z,
				new AngleProperty(zRotationProperty)));
		super.refreshTransforms();
	}

}
