package graphicpersistenshandler.prefs;

import java.util.Map;

public class ShapePreference {

	private Map<String, String> properties;
	private String prefType;

	public ShapePreference(String prefType, Map<String, String> prefMap) {
		this.prefType = prefType;
		properties = prefMap;
	}

	public String getType() {
		return prefType;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

}
