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
	 }
	
	 public void setupY(double y) {
		 ((Rectangle) node).setY(0);
		 ((Rectangle) node).layoutYProperty().set(y);
	 }
	
	@Override
	public void changeWidth(int i) {
		((Rectangle) node).setWidth(((Rectangle) node).getWidth() + i);
		setupRotation();
	}

	@Override
	public void changeHeight(int i) {
		((Rectangle) node).setHeight(((Rectangle) node).getHeight() + i);
		setupRotation();
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
	public void setupRotation() {
		Point3D pivot = Point3DBuilder
				.create()
				.x((getXPositionProperty().get() + getWidthProperty().get()) / 2)
				.y((getYPositionProperty().get() + getHeightProperty()
						.get()) / 2).build();
		rotationBundle.addRotationOfAxis(new Axis(pivot, Axis.X,
				new AngleProperty(xRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(pivot, Axis.Y,
				new AngleProperty(yRotationProperty)));
		rotationBundle.addRotationOfAxis(new Axis(pivot, Axis.Z,
				new AngleProperty(zRotationProperty)));		
	}

}
