package graphiceditor.business;

import graphiceditor.domainspecific.Property;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;

public interface CommonObject3D {

	void setTitle(String name);

	Node asNode();

	void moveX(double i);

	void moveZ(double i);

	void moveY(double i);

	void setSelected(boolean selected);

	DoubleProperty getHeightProperty();

	DoubleProperty getWidthProperty();

	DoubleProperty getXPositionProperty();

	DoubleProperty getYPositionProperty();

	DoubleProperty getZPositionProperty();

	void rotateX(double i);

	void rotateY(double i);

	void rotateZ(double i);

	DoubleProperty getXRotationProperty();

	DoubleProperty getYRotationProperty();

	DoubleProperty getZRotationProperty();
}
