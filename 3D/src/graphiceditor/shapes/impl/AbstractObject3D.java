package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.Rotation;
import graphiceditor.domainspecific.values.observable.RotationProperty;
import graphiceditor.shapes.Object3D;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

public abstract class AbstractObject3D implements Object3D {

	private static final int Z = 2;
	private static final int Y = 1;
	private static final int X = 0;
	protected Node node;
	RotationBundle rotationBundle = new RotationBundle();
	protected RotationProperty xRotationProperty = new RotationProperty();
	protected RotationProperty yRotationProperty = new RotationProperty();
	protected RotationProperty zRotationProperty = new RotationProperty();

	public AbstractObject3D() {
		try {
			node = getNodeClass().newInstance();
			setupRotation();
			addTransforms(rotationBundle.getRotation(X),
					rotationBundle.getRotation(Y), rotationBundle.getRotation(Z));
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	abstract public void setupRotation();

	abstract protected Class<? extends Node> getNodeClass();

	@Override
	public Node asNode() {
		return node;
	}

	@Override
	public void addTransforms(Rotation rotateX, Rotation rotateY,
			Rotation rotateZ) {
		getTransforms().addAll(rotateX, rotateY, rotateZ);
	}

	@Override
	public void enableRotation() {

	}

	@Override
	public void disableRotation() {

	}

	@Override
	public void moveX(int i) {
		node.layoutXProperty().set(node.layoutXProperty().get() + i);
	}

	@Override
	public void moveZ(int i) {
		node.translateZProperty().set(node.translateZProperty().get() + i);
	}

	@Override
	public void moveY(int i) {
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

}
