package graphiceditor.business.impl;

import graphiceditor.business.Object3D;
import graphiceditor.domainspecific.values.Rotation;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Rectangle3D extends Rectangle implements Object3D{

	private Rotation rotateX;
	private Rotation rotateY;
	private Rotation rotateZ;

	@Override
	public Node asNode() {
		return this;
	}

	@Override
	public void addTransforms(Rotation rotateX, Rotation rotateY,
			Rotation rotateZ) {
		this.rotateX = rotateX;
		this.rotateY = rotateY;
		this.rotateZ = rotateZ;
		getTransforms().addAll(rotateX, rotateY, rotateZ);
	}

	@Override
	public void enableRotation() {
		
	}

	@Override
	public void disableRotation() {
		
		
	}

}
