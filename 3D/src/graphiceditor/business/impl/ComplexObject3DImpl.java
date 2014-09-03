package graphiceditor.business.impl;

import graphiceditor.ComplexObject3DFactory;
import graphiceditor.Object3DFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

public class ComplexObject3DImpl extends AbstractObject3DImpl implements
		ComplexObject3D {

	private List<CommonObject3D> childrenShapes;
	private Group shape;

	public ComplexObject3DImpl() {
		super("complex");
		shape = new Group();
		childrenShapes = new ArrayList<CommonObject3D>();
	}

	public ComplexObject3DImpl(List<CommonObject3D> shapes, String title) {
		super(title);
		this.childrenShapes = shapes;
		shape = new Group();
		shape.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
		for(CommonObject3D childrenShape : childrenShapes){
			shape.getChildren().add(childrenShape.asNode());
		}
		try {
			moveToX(minimum(childrenShapes, CommonObject3D.class.getMethod(
					"getXPositionProperty", null)));
			moveToY(minimum(childrenShapes, CommonObject3D.class.getMethod(
					"getYPositionProperty", null)));
			moveToZ(minimum(childrenShapes, CommonObject3D.class.getMethod(
					"getZPositionProperty", null)));
			resetShapesProperties();
			refreshTransforms();
			shape.autosize();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}


	private void resetShapesProperties() {
		for (CommonObject3D cO3D : childrenShapes) {
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
		double min = Integer.MAX_VALUE;
		for (CommonObject3D commonObject3D : shapes) {
			try {
				double possibleMin = ((DoubleProperty) method.invoke(
						commonObject3D, null)).get();
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
		for (CommonObject3D o : childrenShapes) {
			o.setSelected(selected);
		}
	}

	@Override
	public void scale(double height, double width) {
		double maxHeight = 0;
		double maxWidth = 0;
		try {
			maxHeight = maximum(childrenShapes,
					Shape.class.getMethod("heightProperty", null));
			maxWidth = maximum(childrenShapes,
					Shape.class.getMethod("widthProperty", null));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		double heightRealtion = height / maxHeight;
		double widthRealtion = width / maxWidth;

		for (CommonObject3D objec3D : childrenShapes) {
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
			heightProperty.set(maximum(childrenShapes,
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
			widthProperty.set(maximum(childrenShapes,
					CommonObject3D.class.getMethod("getWidthProperty", null)));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return widthProperty;
	}

	@Override
	public List<CommonObject3D> getShapes() {
		return childrenShapes;
	}

	@Override
	public void setShapes(List<CommonObject3D> childrenShapes) {
		this.childrenShapes = childrenShapes;
		shape.getChildren().clear();
		for(CommonObject3D childrenShape : childrenShapes){
			shape.getChildren().add(childrenShape.asNode());
		}
		
		
		//nicht abziehen sondern raufaddieren
		refreshTransforms();
	}

	@Override
	public Object3DFactory getFactory() {
		return ComplexObject3DFactory.getInstance();
	}

}
