package graphicpersistenshandler.prefs;

import java.util.Map;

public class ShapePreference {

	private Map<String, String> properties;
	private String prefType;
	private String name;
	public static String nameProperty = "NAME";

	public ShapePreference(String prefType, String name, Map<String, String> prefMap) {
		this.prefType = prefType;
		this.name = name;
		properties = prefMap;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return prefType;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

}
