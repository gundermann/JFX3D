package graphiceditor.gui.observable;

import javafx.beans.property.SimpleDoubleProperty;

public class AngleProperty extends SimpleDoubleProperty {

	private Double addition;

	public AngleProperty(RotationProperty rootAngle) {
		addition = rootAngle.getValue();
		bind(rootAngle);
	}

	@Override
	public double get() {
		return super.get() - addition;
	}

	@Override
	public Double getValue() {
		return super.getValue() - addition;
	}

}
