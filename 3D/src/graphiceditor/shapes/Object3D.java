package graphiceditor.shapes;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

public interface Object3D {

	ObservableList<Transform> getTransforms();

	Node asNode();

	void moveX(int i);

	void moveZ(int i);

	void moveY(int i);

	DoubleProperty getXPositionProperty();
	
	DoubleProperty getYPositionProperty();
	
	DoubleProperty getZPositionProperty();

	void changeWidth(int i);

	void changeHeight(int i);

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

}
