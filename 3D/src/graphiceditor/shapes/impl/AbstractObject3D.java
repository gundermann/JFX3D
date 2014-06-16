package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.observable.RotationProperty;
import graphiceditor.domainspecific.values.observable.ShapeColor;
import graphiceditor.shapes.Object3D;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Transform;

public abstract class AbstractObject3D implements Object3D {

	private static final int Z = 2;
	private static final int Y = 1;
	private static final int X = 0;
	protected Shape node;
	RotationBundle rotationBundle = new RotationBundle();
	protected RotationProperty xRotationProperty = new RotationProperty();
	protected RotationProperty yRotationProperty = new RotationProperty();
	protected RotationProperty zRotationProperty = new RotationProperty();
	private ShapeColor color = new ShapeColor();

	public AbstractObject3D() {
		try {
			node = getShapeClass().newInstance();
			node.fillProperty().bind(color);
			refreshTransforms();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected void refreshTransforms() {
		getTransforms().setAll(rotationBundle.getRotation(X),
				rotationBundle.getRotation(Y), rotationBundle.getRotation(Z));
	}

	abstract protected Class<? extends Shape> getShapeClass();

	@Override
	public Node asNode() {
		return node;
	}

	@Override
	public void moveX(double i) {
		node.layoutXProperty().set(node.layoutXProperty().get() + i);
	}

	@Override
	public void moveZ(double beginningZ) {
		node.translateZProperty().set(
				node.translateZProperty().get() + beginningZ);
	}

	@Override
	public void moveY(double i) {
		node.layoutYProperty().set(node.layoutYProperty().get() + i);
	}

	@Override
	public void rotateX(int i) {
		xRotationProperty.set(xRotationProperty.getValue() + i);
	}

	@Override
	public void rotateY(int i) {
		yRotationProperty.set(yRotationProperty.getValue() + i);
	}

	@Override
	public void rotateZ(int i) {
		zRotationProperty.set(zRotationProperty.getValue() + i);
	}

	@Override
	public DoubleProperty getXPositionProperty() {
		return node.layoutXProperty();
	}

	@Override
	public DoubleProperty getYPositionProperty() {
		return node.layoutYProperty();
	}

	@Override
	public DoubleProperty getZPositionProperty() {
		return node.translateZProperty();
	}

	@Override
	public DoubleProperty getXRotationProperty() {
		return xRotationProperty;
	}

	@Override
	public DoubleProperty getYRotationProperty() {
		return yRotationProperty;
	}

	@Override
	public DoubleProperty getZRotationProperty() {
		return zRotationProperty;
	}

	@Override
	public ObservableList<Transform> getTransforms() {
		return node.getTransforms();
	}

	@Override
	public ShapeColor getColor() {
		return color;
	}

	@Override
	public void setSelected(boolean selected) {
		if (selected) {
			node.setStyle("-fx-stroke: red; -fx-stroke-width: 5; -fx-stroke-dash-array: 12 2 4 2; -fx-stroke-dash-offset: 6; -fx-stroke-line-cap: butt;");
		} else {
			node.setStyle("-fx-stroke-width: 0;");
		}
	}
}
