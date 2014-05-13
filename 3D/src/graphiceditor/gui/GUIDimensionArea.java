package graphiceditor.gui;

import graphiceditor.graphicobjects.Object3D;
import graphiceditor.gui.observable.AngleProperty;
import graphiceditor.gui.observable.RotationProperty;
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

	private final Point3D xAxis;

	private final RotationProperty rootAngleX = new RotationProperty();

	private final RotationProperty rootAngleY = new RotationProperty();

	private final RotationProperty rootAngleZ = new RotationProperty();

	private final List<Object3D> allGraphicObjects = new ArrayList<Object3D>();

	public List<Object3D> getAllGraphicObjects() {
		return allGraphicObjects;
	}

	private final double pivotX;

	private final double pivotY;

	private AnchorPane mainPane;

	private Point3D yAxis;

	private Point3D zAxis;

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
		show();
		pivotX = this.getWidth() / 2;
		pivotY = this.getHeight() / 2;
		xAxis = Point3DBuilder.create().x(pivotX).y(0).z(0).build();
		yAxis = Point3DBuilder.create().x(0).y(pivotY).z(0).build();
		zAxis = Point3DBuilder.create().x(0).y(0).z(1).build();
		rootRotateX = new Rotation(xAxis, new AngleProperty(
				rootAngleX), pivotX, pivotY);

		rootRotateY = new Rotation(yAxis, new AngleProperty(
				rootAngleY), pivotX, pivotY);

		rootRotateZ = new Rotation(zAxis, new AngleProperty(
				rootAngleZ), pivotX, pivotY);

		mainPane.getTransforms().addAll(rootRotateX, rootRotateY, rootRotateZ);
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
		final Rotation rotateX = new Rotation(xAxis, new AngleProperty(
				rootAngleX), pivotX, pivotY);

		final Rotation rotateY = new Rotation(yAxis, new AngleProperty(
				rootAngleY), pivotX, pivotY);

		final Rotation rotateZ = new Rotation(zAxis, new AngleProperty(
				rootAngleZ), pivotX, pivotY);

		shape.addTransforms(rotateX, rotateY, rotateZ);
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
}
