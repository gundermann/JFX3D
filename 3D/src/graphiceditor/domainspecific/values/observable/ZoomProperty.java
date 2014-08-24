package graphiceditor.domainspecific.values.observable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ZoomProperty extends SimpleDoubleProperty{

	private DoubleProperty indicator;

	public ZoomProperty(DoubleProperty indicator) {
		this.indicator = indicator;
	}
	
	@Override
	public void set(double newValue) {
		super.set(newValue);
		indicator.set(newValue * -10);
	}
	
	@Override
	public void setValue(Number newValue) {
		super.setValue(newValue);
		indicator.setValue(newValue.doubleValue() * -10);
	}
	

	
}
