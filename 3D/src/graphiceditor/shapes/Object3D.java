package graphiceditor.shapes;

import graphiceditor.domainspecific.values.Rotation;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

public interface Object3D {

	ObservableList<Transform> getTransforms();

	Node asNode();
	
	void addTransforms(Rotation rootRotateX, Rotation rootRotateY,
			Rotation rootRotateZ);

	void enableRotation();
	
	void disableRotation();

	void moveX(int i);

	void moveZ(int i);

	void moveY(int i);

	ObservableValue<? extends String> getXPositionProperty();
	
	ObservableValue<? extends String> getYPositionProperty();
	
	ObservableValue<? extends String> getZPositionProperty();

	void changeWidth(int i);

	void changeHeight(int i);

	DoubleProperty getHeightProperty();

	DoubleProperty getWidthProperty();

}
