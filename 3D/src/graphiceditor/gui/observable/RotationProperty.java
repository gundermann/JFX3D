package graphiceditor.gui.observable;

import javafx.beans.property.SimpleDoubleProperty;

public class RotationProperty extends SimpleDoubleProperty {

	@Override
	public void set(double value) {
		super.set(convertAngle(value));
	}

	@Override
	public void setValue(Number value) {
		super.setValue(convertAngle(value.doubleValue()));
	}

	private double convertAngle(double value) {
		double convertedValue = 0.0;

		if (-180 < value && value <= 180.0) {
			convertedValue = value;
		} else {
			convertedValue = -value;
		}
		return convertedValue;
	}

}
