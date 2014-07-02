package graphicpersistenshandler.prefs;

import graphicpersistenshandler.util.ColorConverter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShapePreference implements ShapePreference {

	protected static final String X = "x-coordinate";

	protected static final String Y = "y-coordinate";

	protected static final String Z = "z-coordinate";

	protected static final String XR = "xr";

	protected static final String YR = "yr";

	protected static final String ZR = "zr";

	private static final String COLOR = "color";
	
	private int red = 0;
	
	private int green = 0;
	
	private int blue = 0;
	
	private Map<String, String> preferenceMap = new HashMap<String, String>();
	
	public double getBeginningX() {
		return Double.parseDouble(preferenceMap.get(X));
	}

	public void setBeginningX(double beginningX) {
		setValueForPreference(X, beginningX);
		}

	public double getBeginningY() {
		return Double.parseDouble(preferenceMap.get(Y));
	}

	public void setBeginningY(double beginningY) {
		setValueForPreference(Y, beginningY);
	}

	public double getBeginningZ() {
		return Double.parseDouble(preferenceMap.get(Z));
	}

	public void setBeginningZ(double beginningZ) {
		setValueForPreference(Z, beginningZ);
	}
	
	public double getRotationX() {
		return Double.parseDouble(preferenceMap.get(XR));
	}

	public void setRotationX(double rotationX) {
		setValueForPreference(XR, rotationX);
	}

	public double getRotationY() {
		return Double.parseDouble(preferenceMap.get(YR));
	}

	public void setRotationY(double rotationY) {
		setValueForPreference(YR, rotationY);
	}

	public double getRotationZ() {
		return Double.parseDouble(preferenceMap.get(ZR));
	}

	public void setRotationZ(double rotationZ) {
		setValueForPreference(ZR, rotationZ);		
	}

	protected void setValueForPreference(String key, double value) {
		preferenceMap.put(key, String.valueOf(value));
	}
	
	protected void setValueForPreference(String key, String value) {
		preferenceMap.put(key, value);
	}
	
	protected String getPrefValue(String key){
		return preferenceMap.get(key);
	}

	public int getColor() {
		return Integer.parseInt(preferenceMap.get(COLOR));
	}

	public void setColor(String color) {
		setValueForPreference(COLOR, color);	
	}
	
	@Override
	public Map<String, String> getPreferences() {
		return preferenceMap ;
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
	
	public void setPrefValues(Map<String, String> map) {
		this.preferenceMap = map;
	}

}
