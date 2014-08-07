package graphiceditor.domainspecific.values.observable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class EllipseRadiusDoubleProperty extends SimpleDoubleProperty {

	public EllipseRadiusDoubleProperty(DoubleProperty radiusYProperty) {
		this.bind(radiusYProperty);
	}

	@Override
	public double get() {
		return super.get() * 2;
	}
	
}
