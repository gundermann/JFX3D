package graphiceditor.business.impl;

import graphiceditor.business.Object3D;
import javafx.scene.Node;

public abstract class Object3DImpl extends Node implements Object3D {

	@Override
	public Node asNode() {
		return this;
	}



}
