package graphiceditor.gui;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage {

	private final RotationBundle rotationBundle;

	private static final double LEVEL_SIZE = 1000;

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
		mainPane.getChildren().addAll(getLevelShapes());
		mainPane.getChildren().addAll(getAxisShapes());
		
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

	private List<Node> getAxisShapes() {
		List<Node> shapes = new ArrayList<Node>();
		Line xAxisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(pivot.getX() + LEVEL_SIZE)
				.endY(pivot.getY()).strokeWidth(3.0).build();
		
		Line yAxisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(pivot.getX() + LEVEL_SIZE)
				.endY(pivot.getY()).strokeWidth(3.0).build();
		yAxisShape.getTransforms().add(RotateBuilder.create().angle(-90).axis(Rotate.Z_AXIS)
				.pivotX(pivot.getX()).pivotY(pivot.getY()).build());

		Line zAxisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(pivot.getX() + LEVEL_SIZE)
				.endY(pivot.getY()).strokeWidth(3.0).build();
		zAxisShape.getTransforms().add(RotateBuilder.create().angle(90).axis(Rotate.Y_AXIS)
				.pivotX(pivot.getX()).pivotY(pivot.getY()).build());
		
		shapes.add(zAxisShape);
		shapes.add(yAxisShape);
		shapes.add(xAxisShape);
		return shapes;
	}

	private List<Node> getLevelShapes() {
		List<Node> levels = new ArrayList<Node>();
		Rectangle xyLevel = RectangleBuilder.create().x(pivot.getX())
				.y(pivot.getY() - LEVEL_SIZE).fill(Color.LIGHTBLUE).build();
		xyLevel.setHeight(LEVEL_SIZE);
		xyLevel.setWidth(LEVEL_SIZE);

		Rectangle xzLevel = RectangleBuilder.create().x(pivot.getX())
				.y(pivot.getY()).fill(Color.LIGHTBLUE).build();
		xzLevel.setHeight(LEVEL_SIZE);
		xzLevel.setWidth(LEVEL_SIZE);
		xzLevel.getTransforms().add(
				RotateBuilder.create().angle(-90).axis(Rotate.X_AXIS)
						.pivotX(pivot.getX()).pivotY(pivot.getY()).build());

		Rectangle yzLevel = RectangleBuilder.create().x(pivot.getX())
				.y(pivot.getY() - LEVEL_SIZE).fill(Color.LIGHTBLUE).build();
		yzLevel.setHeight(LEVEL_SIZE);
		yzLevel.setWidth(LEVEL_SIZE);
		yzLevel.getTransforms().add(
				RotateBuilder.create().angle(90).axis(Rotate.Y_AXIS)
						.pivotX(pivot.getX()).pivotY(pivot.getY()).build());

		levels.add(xyLevel);
		levels.add(xzLevel);
		levels.add(yzLevel);
		return levels;
	}
}
