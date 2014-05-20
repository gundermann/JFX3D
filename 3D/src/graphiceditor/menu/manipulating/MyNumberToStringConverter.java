package graphiceditor.menu.manipulating;

import javafx.util.StringConverter;

public class MyNumberToStringConverter extends StringConverter<Number> {

	@Override
	public Double fromString(String s) {
		return Double.valueOf(s);
	}

	@Override
	public String toString(Number n) {
		return String.valueOf(n);
	}

}
