package graphiceditor.business;

import graphiceditor.domainspecific.values.observable.ShapeColor;

public interface Object3D extends CommonObject3D {

	ShapeColor getColor();
	
	void setColor(ShapeColor color);

	void changeHeightTo(double d);

	void changeWidthTo(double d);

	void paint(double x, double y, double initinalX, double initinalY);

	

}
