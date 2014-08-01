package graphicpersistenshandler.prefs.impl;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.impl.Rectangle3D;
import graphicpersistenshandler.prefs.AbstractSingleShapePreference;

import java.util.Map;

public class RectPreference extends AbstractSingleShapePreference {
	
	protected static final String WIDTH = "width";

	protected static final String HEIGHT = "height";

	public RectPreference(){
		
	}
	
	public RectPreference(Map<String, String> map) {
		setPrefValues(map);
	}

	//TODO use factory
	@Override
	public CommonObject3D createShape() {
		Rectangle3D rect = new Rectangle3D();
		rect.moveToX(getBeginningX());
		rect.moveToY(getBeginningY());
		rect.moveToZ(getBeginningZ());
		rect.getWidthProperty().set(getWidth());
		rect.getHeightProperty().set(getHeight());
		rect.rotateXTo(getRotationX());
		rect.rotateYTo(getRotationY());
		rect.rotateZTo(getRotationZ());
		rect.getColor().getR().set(getRed());
		rect.getColor().getG().set(getGreen());
		rect.getColor().getB().set(getBlue());
		return rect;
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

	@Override
	public String getPrefType() {
		return "rect";
	}
}
