package graphiceditor.business.impl;

import graphiceditor.Object3DFactory;
import graphiceditor.Rectangle3DFactory;
import preferencemenu.util.Property;
import preferencemenu.util.PropertyChange;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rectangle3D extends AbstractPaintableObject3D {

	public Rectangle3D(){
		super("Rectangle");
	}

	@PropertyChange(name = "width", hasChildren = false, valueToBalanceWithView = -1)
	public void changeWidthTo(double newWidth) {
		((Rectangle) node).widthProperty().set(newWidth);
	}

	@PropertyChange(name = "height", hasChildren = false, valueToBalanceWithView = -1)
	public void changeHeightTo(double newHeight) {
		((Rectangle) node).heightProperty().set(newHeight);
	}

	@Override
	@Property(name = "height", hasChildren = false, valueToBalanceWithView = 1)
	public DoubleProperty getHeightProperty() {
		return ((Rectangle) node).heightProperty();
	}

	@Override
	@Property(name = "width", hasChildren = false, valueToBalanceWithView = 1)
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
			moveToY(y);
		}
		if (x > initinalX)
			changeWidthTo(x - initinalX);
		else {
			changeWidthTo(initinalX - x);
			moveToX(x);
		}
	}

	@Override
	public Object3DFactory getFactory() {
		return Rectangle3DFactory.getInstance();
	}


}
