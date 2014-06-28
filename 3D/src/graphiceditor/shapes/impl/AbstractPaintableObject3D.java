package graphiceditor.shapes.impl;

import graphiceditor.domainspecific.values.observable.ShapeColor;
import graphiceditor.shapes.Object3D;
import javafx.scene.shape.Shape;

public abstract class AbstractPaintableObject3D extends AbstractObject3DImpl
		implements Object3D {

	protected Shape node;

	private ShapeColor color = new ShapeColor();

	public AbstractPaintableObject3D(String title) {
		super(title);
		try {
			node = getShapeClass().newInstance();
			node.fillProperty().bind(color);
			refreshTransforms();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	abstract protected Class<? extends Shape> getShapeClass();

	@Override
	public Shape asNode() {
		return node;
	}

	@Override
	public ShapeColor getColor() {
		return color;
	}
	
	@Override
	public void setColor(ShapeColor color) {
		this.color = color;
		node.fillProperty().bind(color);
	}

	@Override
	public void setSelected(boolean selected) {
		if (selected) {
			node.setStyle("-fx-stroke: red; -fx-stroke-width: 5; -fx-stroke-dash-array: 12 2 4 2; -fx-stroke-dash-offset: 6; -fx-stroke-line-cap: butt;");
		} else {
			node.setStyle("-fx-stroke-width: 0;");
		}
	}
}
