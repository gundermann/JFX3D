package graphiceditor.gui;

import graphiceditor.shapes.Object3D;
import javafx.beans.property.Property;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public interface DimensionArea {

	Pane getMainPane();

	void add(Object3D shape);

	void enableZRotation();

	void enableXRotation();

	void enableYRotation();

	void setMainPane(AnchorPane mainPane);

	void disableRotation();

	Property<Number> getXRotationProperty();

	Property<Number> getYRotationProperty();

	Property<Number> getZRotationProperty();

	void resetDimensions();

	void showAxis();

}
