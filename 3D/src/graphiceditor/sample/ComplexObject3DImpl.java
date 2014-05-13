package graphiceditor.sample;

import graphiceditor.graphicobjects.Object3D;
import graphiceditor.gui.transform.Rotation;
import javafx.scene.Group;
import javafx.scene.Node;

public class ComplexObject3DImpl extends Group implements Object3D{

	@Override
	public Node asNode() {
		return this;
	}

	@Override
	public void addTransforms(Rotation rootRotateX, Rotation rootRotateY,
			Rotation rootRotateZ) {
		getTransforms().addAll(rootRotateX, rootRotateY, rootRotateZ);
	}

	@Override
	public void enableRotation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableRotation() {
		// TODO Auto-generated method stub
		
	}


}
