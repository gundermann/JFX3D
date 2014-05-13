package graphiceditor.graphicobjects.impl;

import graphiceditor.graphicobjects.Object3D;
import javafx.scene.Node;

public abstract class Object3DImpl extends Node implements Object3D {

	@Override
	public Node asNode() {
		return this;
	}



}
