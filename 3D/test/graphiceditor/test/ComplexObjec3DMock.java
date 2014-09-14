package graphiceditor.test;

import graphiceditor.ComplexObject3DFactory;
import graphiceditor.Object3DFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;

public class ComplexObjec3DMock {

	private static ComplexObjec3DMock _instance;

	public ComplexObject3D create() {
		ComplexObject3D complexMock = new ComplexObject3D() {
			
			@Override
			public void setTitle(String name) {
			}
			
			@Override
			public void setSelected(boolean selected) {
			}
			
			@Override
			public void rotateZTo(double i) {
			}
			
			@Override
			public void rotateYTo(double i) {
			}
			
			@Override
			public void rotateXTo(double i) {
			}
			
			@Override
			public void moveToZ(double i) {
			}
			
			@Override
			public void moveToY(double i) {
			}
			
			@Override
			public void moveToX(double i) {
			}
			
			@Override
			public DoubleProperty getZRotationProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getZPositionProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getYRotationProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getYPositionProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getXRotationProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getXPositionProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getWidthProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public DoubleProperty getHeightProperty() {
				return new SimpleDoubleProperty(10);
			}
			
			@Override
			public Object3DFactory getFactory() {
				return ComplexObject3DFactory.getInstance();
			}
			
			@Override
			public Node asNode() {
				return null;
			}
			
			@Override
			public void setShapes(List<CommonObject3D> childrenShapes) {
				
			}
			
			@Override
			public void scale(double heigt, double width) {
				
			}
			
			@Override
			public List<CommonObject3D> getShapes() {
				return new ArrayList<CommonObject3D>();
			}
		};
		return complexMock ;
	}

	public static ComplexObjec3DMock getInstance() {
		if(_instance == null)
			_instance = new ComplexObjec3DMock();
		return _instance;
	}

}
