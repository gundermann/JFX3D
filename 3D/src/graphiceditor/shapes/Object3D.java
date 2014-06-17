package graphiceditor.shapes;

import graphiceditor.domainspecific.values.observable.ShapeColor;
import javafx.beans.property.DoubleProperty;

public interface Object3D extends CommonObject3D {

	ShapeColor getColor();

	DoubleProperty getHeightProperty();

	DoubleProperty getWidthProperty();

	void setupX(double x);

	void setupY(double y);

	void changeHeightTo(double d);

	void changeWidthTo(double d);

	void paint(double x, double y, double initinalX, double initinalY);

}
