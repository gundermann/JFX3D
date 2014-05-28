package graphiceditor.domainspecific.values.observable;

import javafx.beans.property.SimpleDoubleProperty;

public class RotationProperty extends SimpleDoubleProperty {

	@Override
	public void set(double value) {
		super.set(convertAngle(value));
	}

	@Override
	public void setValue(Number value) {
		super.setValue(convertAngle(value == null ? null : value.doubleValue()));
	}

	private double convertAngle(Double value) {
		double convertedValue = 0.0;
		if(value == null){
			return convertedValue;
		}
		
		if (-180 < value && value <= 180.0) {
			convertedValue = value;
		} else {
			convertedValue = -value;
		}
		return convertedValue;
	}

}
