package graphiceditor.business;

import graphiceditor.Object3DFactory;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;

public interface CommonObject3D {

	void setTitle(String name);

	/**
	 * Returns the javafx-shape-class
	 * 
	 * @return
	 */
	Node asNode();

	void moveToX(double i);

	void moveToZ(double i);

	void moveToY(double i);

	/**
	 * Adds a border to the 3D object. So that it looks like it is in focus.
	 * 
	 * @param selected
	 */
	void setSelected(boolean selected);

	DoubleProperty getHeightProperty();

	DoubleProperty getWidthProperty();

	DoubleProperty getXPositionProperty();

	DoubleProperty getYPositionProperty();

	DoubleProperty getZPositionProperty();

	void rotateXTo(double i);

	void rotateYTo(double i);

	void rotateZTo(double i);

	DoubleProperty getXRotationProperty();

	DoubleProperty getYRotationProperty();

	DoubleProperty getZRotationProperty();

	/**
	 * Returns the factory implemented for this 3D object
	 * 
	 * @return
	 */
	Object3DFactory getFactory();
}
