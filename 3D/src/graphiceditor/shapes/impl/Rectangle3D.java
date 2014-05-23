package graphiceditor.shapes.impl;

import javafx.beans.property.DoubleProperty;
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
	}

	@Override
	public void changeHeight(int i) {
		((Rectangle) node).setHeight(((Rectangle) node).getHeight() + i);
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

}
