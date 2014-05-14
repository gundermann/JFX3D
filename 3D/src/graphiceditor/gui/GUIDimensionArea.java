package graphiceditor.gui;

import graphiceditor.graphicobjects.Object3D;
import graphiceditor.gui.observable.AngleProperty;
import graphiceditor.gui.observable.RotationProperty;
import graphiceditor.gui.transform.Axis;
import graphiceditor.gui.transform.PaintableAxis;
import graphiceditor.gui.transform.Rotation;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point3D;
import javafx.geometry.Point3DBuilder;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage {

	private final PaintableAxis xAxis;

	private final PaintableAxis yAxis;

	private final PaintableAxis zAxis;

	private final RotationProperty rootAngleX = new RotationProperty();

	private final RotationProperty rootAngleY = new RotationProperty();

	private final RotationProperty rootAngleZ = new RotationProperty();

	private final List<Object3D> allGraphicObjects = new ArrayList<Object3D>();

	private final Point3D pivot;

	private AnchorPane mainPane;

	private Rotation rootRotateX;

	private Rotation rootRotateY;

	private Rotation rootRotateZ;

	public GUIDimensionArea() {
		Scene scene = SceneBuilder.create().root(createRoot())
				.camera(PerspectiveCameraBuilder.create().build())
				.depthBuffer(true).build();
		// scene.setFill( Color.BLUE );
		setScene(scene);
		setProperties();
		centerOnScreen();
		show();
		pivot = Point3DBuilder.create().x(this.getWidth() / 2)
				.y(this.getHeight() / 2).z(0).build();

		xAxis = new PaintableAxis(pivot, Axis.X, new AngleProperty(rootAngleX));
		yAxis = new PaintableAxis(pivot, Axis.Y, new AngleProperty(rootAngleY));
		zAxis = new PaintableAxis(pivot, Axis.Z, new AngleProperty(rootAngleZ));
		rootRotateX = new Rotation(xAxis);
		rootRotateY = new Rotation(yAxis);
		rootRotateZ = new Rotation(zAxis);

		mainPane.getTransforms().addAll(rootRotateX, rootRotateY, rootRotateZ);
	}

	public List<Object3D> getAllGraphicObjects() {
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

	public void add(Object3D shape) {
		final Rotation rotateX = new Rotation(xAxis);

		// final Rotation rotateY = new Rotation(yAxis, new AngleProperty(
		// rootAngleY), pivotX, pivotY);
		//
		// final Rotation rotateZ = new Rotation(zAxis, new AngleProperty(
		// rootAngleZ), pivotX, pivotY);
		// , rotateY, rotateZ
		// addTransforms(rotateX);
		shape.getTransforms().add(rotateX);
		mainPane.getChildren().add(shape.asNode());
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
		rootRotateX.enable();
	}

	public void enableYRotation() {
		rootRotateY.enable();
	}

	public void enableZRotation() {
		rootRotateZ.enable();
	}

	public void disableRotation() {
		rootRotateX.disable();
		rootRotateY.disable();
		rootRotateZ.disable();
	}

	public void resetDimensions() {
		rootAngleX.set(0);
		rootAngleY.set(0);
		rootAngleZ.set(0);
	}

	public void showAxis() {
		mainPane.getChildren().add(xAxis.getAxisShape());
		mainPane.getChildren().add(yAxis.getAxisShape());
		mainPane.getChildren().add(zAxis.getAxisShape());
	}
}
