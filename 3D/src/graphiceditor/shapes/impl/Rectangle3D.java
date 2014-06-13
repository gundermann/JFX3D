package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.observable.AngleProperty;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

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
	public String toString() {
		return "Rectangle";
	}

	@Override
	protected void refreshTransforms() {
		rotationBundle.clear();
		rotationBundle.addRotationOfAxis(new Axis(Rotate.X_AXIS,
				new AngleProperty(xRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(Rotate.Y_AXIS,
				new AngleProperty(yRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(Rotate.Z_AXIS,
				new AngleProperty(zRotationProperty)));
		super.refreshTransforms();
	}

	@Override
	public void paint(double x, double y, double initinalX, double initinalY) {
		if (y > initinalY)
			changeHeightTo(y - initinalY);
		else {
			changeHeightTo(initinalY - y);
			getYPositionProperty().set(y);
		}
		if (x > initinalX)
			changeWidthTo(x - initinalX);
		else {
			changeWidthTo(initinalX - x);
			getXPositionProperty().set(x);
		}
	}


}
