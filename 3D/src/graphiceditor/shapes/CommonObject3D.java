package graphiceditor.shapes;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;

public interface CommonObject3D {

	void setTitle(String name);

	Node asNode();

	void moveX(double i);

	void moveZ(double i);

	void moveY(double i);

	void setSelected(boolean selected);
	
	DoubleProperty getXPositionProperty();

	DoubleProperty getYPositionProperty();

	DoubleProperty getZPositionProperty();
	
	void rotateX(int i);

	void rotateY(int i);

	void rotateZ(int i);

	DoubleProperty getXRotationProperty();

	DoubleProperty getYRotationProperty();

	DoubleProperty getZRotationProperty();
}
