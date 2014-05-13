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
	public void updateTransforms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransforms(Rotation rotateX, Rotation rotateY,
			Rotation rotateZ) {
		// TODO Auto-generated method stub
		
	}

}
