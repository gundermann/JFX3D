package graphiceditor.business;

import graphiceditor.domainspecific.values.observable.ShapeColor;

public interface Object3D extends CommonObject3D {

	ShapeColor getColor();
	
	void setColor(ShapeColor color);

	/**
	 * Changes the height of the shape to given parameter.
	 * @param d
	 */
	void changeHeightTo(double d);

	/**
	 * Changes the width of the shape to given parameter.
	 * @param d
	 */
	void changeWidthTo(double d);

	/**
	 * Defines how to paint the shape with the mouse movement.
	 * @param x - current x-position of the mouse
	 * @param y - current y-position of the mouse
	 * @param initinalX - x-position where painting started
	 * @param initinalY - y-position where painting started
	 */
	void paint(double x, double y, double initinalX, double initinalY);

	

}
