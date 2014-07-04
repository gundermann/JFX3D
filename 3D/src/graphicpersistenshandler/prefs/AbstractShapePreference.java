package graphicpersistenshandler.prefs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShapePreference implements ShapePreference {

	protected static final String X = "x-coordinate";

	protected static final String Y = "y-coordinate";

	protected static final String Z = "z-coordinate";

	protected static final String XR = "xr";

	protected static final String YR = "yr";

	protected static final String ZR = "zr";
	
	protected static final String NAME ="name";
	
	private Map<String, String> preferenceMap = new HashMap<String, String>();
	
	public double getBeginningX() {
		return Double.parseDouble(getPrefValue(X));
	}

	public void setBeginningX(double beginningX) {
		setValueForPreference(X, beginningX);
		}

	public double getBeginningY() {
		return Double.parseDouble(getPrefValue(Y));
	}

	public void setBeginningY(double beginningY) {
		setValueForPreference(Y, beginningY);
	}

	public double getBeginningZ() {
		return Double.parseDouble(getPrefValue(Z));
	}

	public void setBeginningZ(double beginningZ) {
		setValueForPreference(Z, beginningZ);
	}
	
	public double getRotationX() {
		return Double.parseDouble(getPrefValue(XR));
	}

	public void setRotationX(double rotationX) {
		setValueForPreference(XR, rotationX);
	}

	public double getRotationY() {
		return Double.parseDouble(getPrefValue(YR));
	}

	public void setRotationY(double rotationY) {
		setValueForPreference(YR, rotationY);
	}

	public double getRotationZ() {
		return Double.parseDouble(getPrefValue(ZR));
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
		return preferenceMap.get(key) != null ? preferenceMap.get(key) : "0";
	}

	@Override
	public Map<String, String> getPreferences() {
		return preferenceMap ;
	}

	public void setPrefValues(Map<String, String> map) {
		this.preferenceMap = map;
	}

	public void setTitle(String title){
		setValueForPreference(NAME, title);
	}
	
	public String getTitle(){
		return getPrefValue(NAME);
	}
}
