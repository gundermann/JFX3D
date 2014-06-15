package graphiceditor.domainspecific.values.observable;

import javafx.beans.property.SimpleDoubleProperty;

public class ColorProperty extends SimpleDoubleProperty {

	@Override
	public void set(double value) {
		if(isValid(value))
		super.set(value);
	}

	private boolean isValid(double value) {
		return (0 <= value && value <= 255);
	}

	@Override
	public void setValue(Number value) {
		if(isValid(value.doubleValue()))
		super.setValue(value.doubleValue());
	}

}
