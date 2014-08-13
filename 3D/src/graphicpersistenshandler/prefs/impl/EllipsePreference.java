package graphicpersistenshandler.prefs.impl;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.impl.Ellipse3D;
import graphicpersistenshandler.prefs.AbstractSingleShapePreference;

import java.util.Map;

//TODO summarize with RectPReference and use properties
public class EllipsePreference extends AbstractSingleShapePreference {

	protected static final String WIDTH = "width";

	protected static final String HEIGHT = "height";

	public EllipsePreference(Map<String, String> prefMap) {
		setPrefValues(prefMap);
	}

	public EllipsePreference() {
	}

	@Override
	public String getPrefType() {
		return "ell";
	}

	@Override
	public CommonObject3D createShape() {
		Ellipse3D el = new Ellipse3D();
		el.moveToX(getBeginningX());
		el.moveToY(getBeginningY());
		el.moveToZ(getBeginningZ());
		el.getWidthProperty().set(getWidth());
		el.getHeightProperty().set(getHeight());
		el.rotateXTo(getRotationX());
		el.rotateYTo(getRotationY());
		el.rotateZTo(getRotationZ());
		el.getColor().getR().set(getRed());
		el.getColor().getG().set(getGreen());
		el.getColor().getB().set(getBlue());
		return el;
	}

	public double getHeight() {
		return Double.parseDouble(getPrefValue(HEIGHT));
	}

	public void setHeight(double height) {
		setValueForPreference(HEIGHT, height);
	}

	public double getWidth() {
		return Double.parseDouble(getPrefValue(WIDTH));
	}

	public void setWidth(double width) {
		setValueForPreference(WIDTH, width);
	}

}
