package graphiceditor.gui;

import graphiceditor.business.CommonObject3D;
import javafx.beans.property.Property;

public interface DimensionArea {

	void add(CommonObject3D shape);

	void enableZRotation();

	void enableXRotation();

	void enableYRotation();

	void disableRotation();

	Property<Number> getXRotationProperty();

	Property<Number> getYRotationProperty();

	Property<Number> getZRotationProperty();

	void resetDimensions();

	void showGrid(boolean b);

	void showAxis(boolean b);

}
