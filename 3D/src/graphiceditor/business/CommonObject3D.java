package graphiceditor.business;

import graphiceditor.Object3DFactory;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;

public interface CommonObject3D {

	void setTitle(String name);

	Node asNode();

	void moveToX(double i);

	void moveToZ(double i);

	void moveToY(double i);

	void setSelected(boolean selected);

	DoubleProperty getHeightProperty();

	DoubleProperty getWidthProperty();

	DoubleProperty getXPositionProperty();

	DoubleProperty getYPositionProperty();

	DoubleProperty getZPositionProperty();

	void rotateXTo(double i);

	void rotateYTo(double i);

	void rotateZTo(double i);

	DoubleProperty getXRotationProperty();

	DoubleProperty getYRotationProperty();

	DoubleProperty getZRotationProperty();
	
	Object3DFactory getFactory();
}
