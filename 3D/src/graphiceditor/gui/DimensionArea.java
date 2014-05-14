package graphiceditor.gui;

import graphiceditor.graphicobjects.Object3D;
import javafx.beans.value.ObservableValue;
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

	ObservableValue<? extends String> getXRotationTextProperty();

	ObservableValue<? extends String> getYRotationTextProperty();

	ObservableValue<? extends String> getZRotationTextProperty();

	void resetDimensions();

	void showAxis();

}
