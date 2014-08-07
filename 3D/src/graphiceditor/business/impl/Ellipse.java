package graphiceditor.business.impl;

import graphiceditor.domainspecific.Property;
import graphiceditor.domainspecific.PropertyChange;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Shape;

public class Ellipse extends AbstractPaintableObject3D {

	public Ellipse() {
		super("Ellipse");
	}

	@Override
	@Property(name = "y-radius", hasChildren = false)
	public DoubleProperty getHeightProperty() {
		return ((javafx.scene.shape.Ellipse) node).radiusYProperty();
	}

	@Override
	@Property(name = "x-radius", hasChildren = false)
	public DoubleProperty getWidthProperty() {
		return ((javafx.scene.shape.Ellipse) node).radiusXProperty();
	}

	@Override
	@PropertyChange(name = "y-radius", hasChildren = false)
	public void changeHeightTo(double d) {
		((javafx.scene.shape.Ellipse) node).radiusYProperty().set(d);
	}

	@Override
	@PropertyChange(name = "x-radius", hasChildren = false)
	public void changeWidthTo(double d) {
		((javafx.scene.shape.Ellipse) node).radiusXProperty().set(d);
	}

	@Override
	public void paint(double x, double y, double initinalX, double initinalY) {
		if (y > initinalY) {
			changeHeightTo(y - initinalY);
			moveToY(initinalY + (y - initinalY));
		} else {
			changeHeightTo(initinalY - y);
			moveToY(initinalY - (initinalY - y));
		}
		if (x > initinalX) {
			changeWidthTo(x - initinalX);
			moveToX(initinalX + (x - initinalX));
		} else {
			changeWidthTo(initinalX - x);
			moveToX(initinalX - (initinalX - x));
		}
	}

	@Override
	protected Class<? extends Shape> getShapeClass() {
		return javafx.scene.shape.Ellipse.class;
	}

}
