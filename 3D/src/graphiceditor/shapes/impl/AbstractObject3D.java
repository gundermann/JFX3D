package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.values.Rotation;
import graphiceditor.shapes.Object3D;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

public abstract class AbstractObject3D implements Object3D {

	
	protected Node node;
	
	public AbstractObject3D(){
		try {
			node = getNodeClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	abstract protected Class<? extends Node> getNodeClass();
	
	@Override
	public Node asNode() {
		return node;
	}

	@Override
	public void addTransforms(Rotation rotateX, Rotation rotateY,
			Rotation rotateZ) {
		getTransforms().addAll(rotateX, rotateY, rotateZ);
	}

	@Override
	public void enableRotation() {

	}

	@Override
	public void disableRotation() {

	}

	@Override
	public void moveX(int i) {
		node.layoutXProperty().set(node.layoutXProperty().get() + i);
	}

	@Override
	public void moveZ(int i) {
		node.translateZProperty().set(node.translateZProperty().get() + i);
	}

	@Override
	public void moveY(int i) {
		node.layoutYProperty().set(node.layoutYProperty().get() + i);
	}

	@Override
	public DoubleProperty getXPositionProperty() {
		return node.layoutXProperty();
	}

	@Override
	public DoubleProperty getYPositionProperty() {
		return node.layoutYProperty();
	}

	@Override
	public DoubleProperty getZPositionProperty() {
		return node.translateZProperty();
	}
	
	@Override
	public ObservableList<Transform> getTransforms() {
		return node.getTransforms();
	}



}
