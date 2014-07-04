package graphicpersistenshandler.prefs;

import graphicpersistenshandler.util.ColorConverter;

public abstract class AbstractSingleShapePreference extends AbstractShapePreference{

	private static final String COLOR = "color";
	
	private int red = 0;
	
	private int green = 0;
	
	private int blue = 0;

	public int getColor() {
		return Integer.parseInt(getPrefValue(COLOR));
	}

	public void setColor(String color) {
		setValueForPreference(COLOR, color);	
	}
	
	public int getRed() {
		return ColorConverter.getInstance().hex2Rgb(getPrefValue(COLOR)).getRed();
	}
	
	public int getBlue() {
		return ColorConverter.getInstance().hex2Rgb(getPrefValue(COLOR)).getBlue();
	}

	public int getGreen() {
		return ColorConverter.getInstance().hex2Rgb(getPrefValue(COLOR)).getGreen();
	}
	
	public void setRed(int intValue) {
		red=intValue;
		updateColor();
	}

	private void updateColor() {
		setValueForPreference(COLOR, ColorConverter.getInstance().Rgb2hex(red, green, blue));
	}

	public void setGreen(int intValue) {
		green=intValue;
		updateColor();		
	}

	public void setBlue(int intValue) {
		blue=intValue;
		updateColor();		
	}
	

}
