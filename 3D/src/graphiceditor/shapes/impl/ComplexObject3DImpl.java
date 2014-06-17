package graphiceditor.shapes.impl;

import graphiceditor.shapes.Object3D;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Node;

public class ComplexObject3DImpl extends AbstractObject3DImpl  {

	private List<Object3D> shapes;
	private Group shape;
	

	public ComplexObject3DImpl(List<Object3D> shapes, String title) {
		super(title);
		this.shapes = shapes;
		shape = GroupBuilder.create().build();
		for(Object3D o : shapes){
			shape.getChildren().add(o.asNode());
		}
	}

	@Override
	public Node asNode() {
		return shape;
	}

	@Override
	public void setSelected(boolean selected) {
		for(Object3D o : shapes){
			o.setSelected(selected);
		}
	}
}
