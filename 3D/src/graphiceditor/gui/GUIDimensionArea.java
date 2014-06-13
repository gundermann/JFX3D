package graphiceditor.gui;

import graphiceditor.domainspecific.RotationBundle;
import graphiceditor.domainspecific.values.PaintableAxis;
import graphiceditor.domainspecific.values.observable.AngleProperty;
import graphiceditor.domainspecific.values.observable.RotationProperty;
import graphiceditor.shapes.Object3D;

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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class GUIDimensionArea extends Stage {

	private final RotationBundle rotationBundle;

	private final RotationProperty rootAngleX = new RotationProperty();

	private final RotationProperty rootAngleY = new RotationProperty();

	private final RotationProperty rootAngleZ = new RotationProperty();

	private final List<Object3D> allGraphicObjects = new ArrayList<Object3D>();

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

		rotationBundle = new RotationBundle();
		rotationBundle.setPivot(pivot);
		PaintableAxis xAxis = new PaintableAxis(Rotate.X_AXIS,
				new AngleProperty(rootAngleX));
		PaintableAxis yAxis = new PaintableAxis(Rotate.Y_AXIS,
				new AngleProperty(rootAngleY));
		PaintableAxis zAxis = new PaintableAxis(Rotate.Z_AXIS,
				new AngleProperty(rootAngleZ));
		rotationBundle.addRotationOfAxis(xAxis, yAxis, zAxis);

		mainPane.getTransforms().addAll(rotationBundle.getRotation(0),
				rotationBundle.getRotation(1), rotationBundle.getRotation(2));
		centerOnScreen();
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
		if (!getAllGraphicObjects().contains(shape)) {
			mainPane.getChildren().add(shape.asNode());
			allGraphicObjects.add(shape);
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
		rotationBundle.getRotation(0).enable();
	}

	public void enableYRotation() {
		rotationBundle.getRotation(1).enable();
	}

	public void enableZRotation() {
		rotationBundle.getRotation(2).enable();
	}

	public void disableRotation() {
		rotationBundle.disableAll();
	}

	public void resetDimensions() {
		rootAngleX.set(0);
		rootAngleY.set(0);
		rootAngleZ.set(0);
	}

	public void showAxis() {
		mainPane.getChildren().add(rotationBundle.getAxis(0).getAxisShape());
		mainPane.getChildren().add(rotationBundle.getAxis(1).getAxisShape());
		mainPane.getChildren().add(rotationBundle.getAxis(2).getAxisShape());
	}

}
