package graphiceditor.gui;

import graphiceditor.OrientationShapeBuilder;
import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.observable.RotationProperty;
import graphiceditor.menu.components.GUIComponentsMenu;
import graphiceditor.shapes.CommonObject3D;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point3D;
import javafx.geometry.Point3DBuilder;
import javafx.scene.Node;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage {

	private final RotationBundle rotationBundle;

	private List<Node> gridShapes;
	
	private List<Node> axisShapes;

	private final RotationProperty rootAngleX = new RotationProperty();

	private final RotationProperty rootAngleY = new RotationProperty();

	private final RotationProperty rootAngleZ = new RotationProperty();

	private final List<CommonObject3D> allGraphicObjects = new ArrayList<CommonObject3D>();

	private final Point3D pivot;

	private AnchorPane mainPane;

	public GUIDimensionArea() {
		Scene scene = SceneBuilder.create().root(createRoot())
				.camera(PerspectiveCameraBuilder.create().build())
				.depthBuffer(true).build();
		setScene(scene);
		setProperties();
		show();
		pivot = Point3DBuilder.create().x(this.getWidth() / 2)
				.y(this.getHeight() / 2).z(0).build();

		rotationBundle = new RotationBundle(pivot);
		rotationBundle.setXAxisRotation(rootAngleX);
		rotationBundle.setYAxisRotation(rootAngleY);
		rotationBundle.setZAxisRotation(rootAngleZ);
		
		mainPane.getTransforms().addAll(rotationBundle.getRotations());
		centerOnScreen();
	}

	public List<CommonObject3D> getAllGraphicObjects() {
		return allGraphicObjects;
	}

	private void setProperties() {
		mainPane.prefWidthProperty().bind(getScene().widthProperty());
		mainPane.prefHeightProperty().bind(getScene().heightProperty());
	}

	public AnchorPane createRoot() {
		mainPane = new AnchorPane();
		return mainPane;
	}

	public void setMainPane(AnchorPane mainPane) {
		hide();
		this.mainPane = mainPane;
		Scene scene = SceneBuilder.create().root(mainPane)
				.camera(PerspectiveCameraBuilder.create().build())
				.depthBuffer(true).build();
		setScene(scene);
		setProperties();
		show();
	}

	public Pane getMainPane() {
		return mainPane;
	}

	public void add(CommonObject3D shape) {
		if (!getAllGraphicObjects().contains(shape)) {
			mainPane.getChildren().add(shape.asNode());
			allGraphicObjects.add(shape);
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
	}

	public void showGrid(boolean active) {
		if(!active && gridShapes != null){
			mainPane.getChildren().removeAll(gridShapes);
		}else{
			gridShapes = OrientationShapeBuilder.createGridShapes(pivot);
			mainPane.getChildren().addAll(gridShapes);
		}
	}

	public void showAxis(boolean active) {
		if(!active && axisShapes != null){
			mainPane.getChildren().removeAll(axisShapes);
		}else{
			axisShapes = OrientationShapeBuilder.createAxisShapes(pivot);
			mainPane.getChildren().addAll(axisShapes);
		}
	}
}
