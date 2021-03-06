package graphiceditor.domainspecific.values.observable;

import preferencemenu.util.Property;
import preferencemenu.util.PropertyChange;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ShapeColor extends ObservableValueBase<Paint> implements ChangeListener<Number>{
	
	private ColorProperty r;
	private ColorProperty g;
	private ColorProperty b;
	
	public ShapeColor() {
		r = new ColorProperty();
		g = new ColorProperty();
		b = new ColorProperty();
		r.addListener(this);
		g.addListener(this);
		b.addListener(this);
	}

	@Property(name = "red", hasChildren = false)
	public ColorProperty getR() {
		return r;
	}

	@Property(name = "green", hasChildren = false)
	public ColorProperty getG() {
		return g;
	}

	@Property(name = "blue", hasChildren = false)
	public ColorProperty getB() {
		return b;
	}
	
	
	@PropertyChange(name = "red", hasChildren = false)
	public void setR(double r) {
		this.r.set(r);
	}

	@PropertyChange(name = "green", hasChildren = false)
	public void setG(double g) {
		this.g.set(g);
	}
	@PropertyChange(name = "blue", hasChildren = false)
	public void setB(double b) {
		this.b.set(b);
	}

	@Override
	public Paint getValue() {
		return Color.rgb(r.intValue(), g.intValue(), b.intValue());
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1,
			Number arg2) {
		this.fireValueChangedEvent();
	}

}
