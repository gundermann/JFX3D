package graphiceditor.business;

import graphiceditor.domainspecific.values.Rotation;
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
}
