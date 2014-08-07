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
			changeHeightTo((y - initinalY)/2);
			moveToY(initinalY + (y - initinalY)/2);
		} else {
			changeHeightTo((initinalY - y)/2);
			moveToY(initinalY - (initinalY - y)/2);
		}
		if (x > initinalX) {
			changeWidthTo((x - initinalX)/2);
			moveToX(initinalX + (x - initinalX)/2);
		} else {
			changeWidthTo((initinalX - x)/2);
			moveToX(initinalX - (initinalX - x)/2);
		}
	}

	@Override
	protected Class<? extends Shape> getShapeClass() {
		return javafx.scene.shape.Ellipse.class;
	}

}
