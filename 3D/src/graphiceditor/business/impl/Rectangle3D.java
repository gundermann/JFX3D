package graphiceditor.business.impl;

import graphiceditor.business.Object3D;
import graphiceditor.domainspecific.values.Rotation;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Rectangle3D extends Rectangle implements Object3D {

	private Rotation rotateX;
	private Rotation rotateY;
	private Rotation rotateZ;

	@Override
	public Node asNode() {
		return this;
	}

	@Override
	public void addTransforms(Rotation rotateX, Rotation rotateY,
			Rotation rotateZ) {
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
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
		layoutXProperty().set(layoutXProperty().get() + i);
	}

	@Override
	public void moveZ(int i) {
		translateZProperty().set(translateZProperty().get() + i);
	}

	@Override
	public void moveY(int i) {
		layoutYProperty().set(layoutYProperty().get() + i);
	}

	@Override
	public ObservableValue<? extends String> getXPositionProperty() {
		return layoutXProperty().asString();
	}

	@Override
	public ObservableValue<? extends String> getYPositionProperty() {
		return layoutYProperty().asString();
	}

	@Override
	public ObservableValue<? extends String> getZPositionProperty() {
		return translateZProperty().asString();
	}

	public void setupX(double x) {
		setX(0);
		layoutXProperty().set(x);
	}

	public void setupY(double y) {
		setY(0);
		layoutYProperty().set(y);
	}

	@Override
	public void changeWidth(int i) {
		setWidth(getWidth() + i);
	}

	@Override
	public void changeHeight(int i) {
		setHeight(getHeight() + i);
	}

	@Override
	public DoubleProperty getHeightProperty() {
		return heightProperty();
	}

	@Override
	public DoubleProperty getWidthProperty() {
		return widthProperty();
	}

}
