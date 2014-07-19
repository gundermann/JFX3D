package graphiceditor.business.impl;

import graphiceditor.domainspecific.Property;
import graphiceditor.domainspecific.PropertyChange;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rectangle3D extends AbstractPaintableObject3D {

	public Rectangle3D(){
		super("Rectangle");
	}

	@PropertyChange(name = "height")
	public void changeWidthTo(double newWidth) {
		((Rectangle) node).widthProperty().set(newWidth);
		refreshTransforms();
	}

	@PropertyChange(name = "width")
	public void changeHeightTo(double newHeight) {
		((Rectangle) node).heightProperty().set(newHeight);
		refreshTransforms();
	}

	@Override
	@Property(name = "height")
	public DoubleProperty getHeightProperty() {
		return ((Rectangle) node).heightProperty();
	}

	@Override
	@Property(name = "width")
	public DoubleProperty getWidthProperty() {
		return ((Rectangle) node).widthProperty();
	}

	@Override
	protected Class<? extends Shape> getShapeClass() {
		return Rectangle.class;
	}

	@Override
	public void paint(double x, double y, double initinalX, double initinalY) {
		if (y > initinalY)
			changeHeightTo(y - initinalY);
		else {
			changeHeightTo(initinalY - y);
			moveY(y-getYPositionProperty().get());
		}
		if (x > initinalX)
			changeWidthTo(x - initinalX);
		else {
			changeWidthTo(initinalX - x);
			moveX(x-getXPositionProperty().get());
		}
	}


}
