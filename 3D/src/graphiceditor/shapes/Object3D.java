package graphiceditor.shapes;

import graphiceditor.domainspecific.values.observable.ShapeColor;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

public interface Object3D {

	ObservableList<Transform> getTransforms();

	Node asNode();

	void moveX(double i);

	void moveZ(double i);

	void moveY(double i);

	void setSelected(boolean selected);
	
	DoubleProperty getXPositionProperty();

	DoubleProperty getYPositionProperty();

	DoubleProperty getZPositionProperty();

	ShapeColor getColor();

	DoubleProperty getHeightProperty();

	DoubleProperty getWidthProperty();

	void setupX(double x);

	void setupY(double y);

	void rotateX(int i);

	void rotateY(int i);

	void rotateZ(int i);

	DoubleProperty getXRotationProperty();

	DoubleProperty getYRotationProperty();

	DoubleProperty getZRotationProperty();

	void changeHeightTo(double d);

	void changeWidthTo(double d);

	void paint(double x, double y, double initinalX, double initinalY);

}
