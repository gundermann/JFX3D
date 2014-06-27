package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.observable.AngleProperty;
import graphiceditor.domainspecific.values.observable.RotationProperty;
import graphiceditor.shapes.CommonObject3D;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public abstract class AbstractObject3DImpl implements CommonObject3D{

	private String title;
	private static final int Z = 2;
	private static final int Y = 1;
	private static final int X = 0;
	protected RotationProperty xRotationProperty = new RotationProperty();
	protected RotationProperty yRotationProperty = new RotationProperty();
	protected RotationProperty zRotationProperty = new RotationProperty();
	RotationBundle rotationBundle = new RotationBundle();

	public AbstractObject3DImpl(String title) {
		setTitle(title);
	}
	
	protected void refreshTransforms() {
		rotationBundle.clear();
		rotationBundle.addRotationOfAxis(new Axis(Rotate.X_AXIS,
				new AngleProperty(xRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(Rotate.Y_AXIS,
				new AngleProperty(yRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(Rotate.Z_AXIS,
				new AngleProperty(zRotationProperty)));
		getTransforms().setAll(rotationBundle.getRotation(X),
				rotationBundle.getRotation(Y), rotationBundle.getRotation(Z));
	}
	
	private ObservableList<Transform> getTransforms() {
		return asNode().getTransforms();
	}

	@Override
	public void setTitle(String name) {
		this.title = name;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
	
	@Override
	public DoubleProperty getXPositionProperty() {
		return asNode().layoutXProperty();
	}
	
	@Override
	public DoubleProperty getYPositionProperty() {
		return asNode().layoutYProperty();
	}
	
	@Override
	public DoubleProperty getZPositionProperty() {
		return asNode().translateZProperty();
	}
	
	@Override
	public void moveX(double i) {
		asNode().layoutXProperty().set(asNode().layoutXProperty().get()+i);
	}

	@Override
	public void moveZ(double i) {
		asNode().translateZProperty().set(asNode().translateZProperty().get()+i);;
	}

	@Override
	public void moveY(double i) {
		asNode().layoutYProperty().set(asNode().layoutYProperty().get()+i);
	}
	
	@Override
	public void rotateX(double i) {
		xRotationProperty.set(xRotationProperty.getValue() + i);
	}

	@Override
	public void rotateY(double i) {
		yRotationProperty.set(yRotationProperty.getValue() + i);
	}

	@Override
	public void rotateZ(double i) {
		zRotationProperty.set(zRotationProperty.getValue() + i);
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
	
}
