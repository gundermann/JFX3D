package graphiceditor.shapes.impl;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

public class ComplexObject3DImpl extends AbstractObject3DImpl implements
		ComplexObject3D {

	private List<CommonObject3D> shapes;
	private Group shape;

	public ComplexObject3DImpl(List<CommonObject3D> shapes, String title) {
		super(title);
		this.shapes = shapes;
		shape = GroupBuilder.create().build();
		for (CommonObject3D common : shapes) {
			if (common instanceof ComplexObject3D) {
				for (CommonObject3D shapeFromComplex : ((ComplexObject3D) common).getShapes()) {
					shape.getChildren().add(shapeFromComplex.asNode());
				}
			} else {
				shape.getChildren().add(common.asNode());
			}
		}
		try {
			shape.layoutXProperty().set(
					minimum(shapes,
							Shape.class.getMethod("layoutXProperty", null)));
			shape.layoutYProperty().set(
					minimum(shapes,
							Shape.class.getMethod("layoutYProperty", null)));
			shape.translateZProperty().set(
					minimum(shapes,
							Shape.class.getMethod("translateZProperty", null)));
			resetShapesProperties();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	private void resetShapesProperties() {
		for (CommonObject3D cO3D : shapes) {
			cO3D.getXPositionProperty().set(
					cO3D.getXPositionProperty().get()
							- getXPositionProperty().get());
			cO3D.getYPositionProperty().set(
					cO3D.getYPositionProperty().get()
							- getYPositionProperty().get());
			cO3D.getZPositionProperty().set(
					cO3D.getZPositionProperty().get()
							- getZPositionProperty().get());
		}
	}

	private double minimum(List<CommonObject3D> shapes, Method method) {
		double min = 1000;
		for (CommonObject3D commonObject3D : shapes) {
			try {
				double possibleMin = ((DoubleProperty) method.invoke(
						commonObject3D.asNode(), null)).get();
				if (min > possibleMin)
					min = possibleMin;
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return min;
	}

	@Override
	public Node asNode() {
		return shape;
	}

	@Override
	public void setSelected(boolean selected) {
		for (CommonObject3D o : shapes) {
			o.setSelected(selected);
		}
	}

	@Override
	public void scale(double height, double width) {
		double maxHeight = 0;
		double maxWidth = 0;
		try {
			maxHeight = maximum(shapes,
					Shape.class.getMethod("heightProperty", null));
			maxWidth = maximum(shapes,
					Shape.class.getMethod("widthProperty", null));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		double heightRealtion = height / maxHeight;
		double widthRealtion = width / maxWidth;

		for (CommonObject3D objec3D : shapes) {
			objec3D.getHeightProperty().set(
					objec3D.getHeightProperty().get() * heightRealtion);
			objec3D.getWidthProperty().set(
					objec3D.getWidthProperty().get() * widthRealtion);
		}
	}

	private double maximum(List<CommonObject3D> shapes, Method method) {
		double max = 0;
		for (CommonObject3D commonObject3D : shapes) {
			try {
				double possibleMin = ((DoubleProperty) method.invoke(
						commonObject3D, null)).get();
				if (max < possibleMin)
					max = possibleMin;
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return max;
	}

	@Override
	public DoubleProperty getHeightProperty() {
		DoubleProperty heightProperty = new SimpleDoubleProperty();
		try {
			heightProperty.set(maximum(shapes,
					CommonObject3D.class.getMethod("getHeightProperty", null)));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return heightProperty;
	}

	@Override
	public DoubleProperty getWidthProperty() {
		DoubleProperty widthProperty = new SimpleDoubleProperty();
		try {
			widthProperty.set(maximum(shapes,
					CommonObject3D.class.getMethod("getWidthProperty", null)));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return widthProperty;
	}

	@Override
	public List<CommonObject3D> getShapes() {
		return shapes;
	}

}
