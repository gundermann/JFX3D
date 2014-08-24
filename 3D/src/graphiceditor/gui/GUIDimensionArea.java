package graphiceditor.gui;

import graphiceditor.HelperShapeFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.observable.RotationProperty;
import graphiceditor.domainspecific.values.observable.ZoomProperty;
import graphiceditor.menu.components.GUIComponentsMenu;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.geometry.Point3D;
import javafx.geometry.Point3DBuilder;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;

public class GUIDimensionArea extends SubScene {

	private final RotationBundle rotationBundle;

	private List<Node> gridShapes;

	private List<Node> axisShapes;

	private final RotationProperty rootAngleX = new RotationProperty();

	private final RotationProperty rootAngleY = new RotationProperty();

	private final RotationProperty rootAngleZ = new RotationProperty();
	
	private ZoomProperty zoomProperty ;

	private final List<CommonObject3D> allGraphicObjects = new ArrayList<CommonObject3D>();

	private final Point3D pivot;

	private static Group mainPane;

	public GUIDimensionArea() {
		super(createRoot(), Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth() - 280, Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight() - 70, true, SceneAntialiasing.DISABLED);
		setCamera(new PerspectiveCamera(false));
		pivot = Point3DBuilder.create().x(this.getWidth() / 2)
				.y(this.getHeight() / 2).z(0).build();
		rotationBundle = new RotationBundle(pivot);
		rotationBundle.setXAxisRotation(rootAngleX);
		rotationBundle.setYAxisRotation(rootAngleY);
		rotationBundle.setZAxisRotation(rootAngleZ);
		setFill(Color.WHITE);
		mainPane.getTransforms().addAll(rotationBundle.getRotations());
		zoomProperty = new ZoomProperty(mainPane.translateZProperty());
	}

	public List<CommonObject3D> getAllGraphicObjects() {
		return allGraphicObjects;
	}

	public static Group createRoot() {
		mainPane = new Group();
		return mainPane;
	}

	public Group getMainPane() {
		return mainPane;
	}

	public void add(CommonObject3D shape) {
		if (!getAllGraphicObjects().contains(shape)) {
			mainPane.getChildren().add(shape.asNode());
			allGraphicObjects.add(shape);
			GUIComponentsMenu.getInstance().updateComponents();
		}
	}

	public void remove(CommonObject3D shape) {
		if (getAllGraphicObjects().contains(shape)) {
			mainPane.getChildren().remove(shape.asNode());
			allGraphicObjects.remove(shape);
			GUIComponentsMenu.getInstance().updateComponents();
		}
	}

	public DoubleProperty getZRotationProperty() {
		return rootAngleZ;
	}

	public DoubleProperty getXRotationProperty() {
		return rootAngleX;
	}

	public DoubleProperty getYRotationProperty() {
		return rootAngleY;
	}

	public void enableXRotation() {
		rotationBundle.enableXAxisRotation();
	}

	public void enableYRotation() {
		rotationBundle.enableYAxisRotation();
	}

	public void enableZRotation() {
		rotationBundle.enableZAxisRotation();
	}

	public void disableRotation() {
		rotationBundle.disableAll();
	}

	public void resetDimensions() {
		rootAngleX.set(0);
		rootAngleY.set(0);
		rootAngleZ.set(0);
		zoomProperty.set(0);
	}

	public void showGrid(boolean active) {
		if (!active && gridShapes != null) {
			mainPane.getChildren().removeAll(gridShapes);
		} else {
			gridShapes = HelperShapeFactory.getInstance()
					.createGridShapes(pivot);
			mainPane.getChildren().addAll(gridShapes);
		}
	}

	public void showAxis(boolean active) {
		if (!active && axisShapes != null) {
			mainPane.getChildren().removeAll(axisShapes);
		} else {
			axisShapes = HelperShapeFactory.getInstance()
					.createAxisShapes(pivot);
			mainPane.getChildren().addAll(axisShapes);
		}
	}

	public Property<Number> getZoomProperty() {
		return zoomProperty;
	}
}
