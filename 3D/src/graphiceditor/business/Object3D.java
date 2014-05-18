package graphiceditor.business;

import graphiceditor.domainspecific.values.Rotation;
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
}
