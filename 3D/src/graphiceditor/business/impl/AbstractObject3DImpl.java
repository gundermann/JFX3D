package graphiceditor.business.impl;

import preferencemenu.util.Property;
import preferencemenu.util.PropertyChange;
import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.observable.AngleProperty;
import graphiceditor.domainspecific.values.observable.RotationProperty;
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
		getTransforms().clear();
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
	@Property(name = "x-position", hasChildren = false)
	public DoubleProperty getXPositionProperty() {
		return asNode().layoutXProperty();
	}
	
	@Override
	@Property(name = "y-position", hasChildren = false)
	public DoubleProperty getYPositionProperty() {
		return asNode().layoutYProperty();
	}
	
	@Override
	@Property(name = "z-position", hasChildren = false)
	public DoubleProperty getZPositionProperty() {
		return asNode().translateZProperty();
	}
	
	@Override
	@PropertyChange(name = "x-position", hasChildren = false)
	public void moveToX(double i) {
		asNode().layoutXProperty().set(i);
	}

	@Override
	@PropertyChange(name = "z-position", hasChildren = false)
	public void moveToZ(double i) {
		asNode().translateZProperty().set(i);;
	}

	@Override
	@PropertyChange(name = "y-position", hasChildren = false)
	public void moveToY(double i) {
		asNode().layoutYProperty().set(i);
	}
	
	@Override
	@PropertyChange(name = "x-rotation", hasChildren = false)
	public void rotateXTo(double i) {
		xRotationProperty.set(i);
	}

	@Override
	@PropertyChange(name = "y-rotation", hasChildren = false)
	public void rotateYTo(double i) {
		yRotationProperty.set(i);
	}

	@Override
	@PropertyChange(name = "z-rotation", hasChildren = false)
	public void rotateZTo(double i) {
		zRotationProperty.set(i);
	}

	@Override
	@Property(name = "x-rotation", hasChildren = false)
	public DoubleProperty getXRotationProperty() {
		return xRotationProperty;
	}

	@Override
	@Property(name = "y-rotation", hasChildren = false)
	public DoubleProperty getYRotationProperty() {
		return yRotationProperty;
	}

	@Override
	@Property(name = "z-rotation", hasChildren = false)
	public DoubleProperty getZRotationProperty() {
		return zRotationProperty;
	}
	
}
