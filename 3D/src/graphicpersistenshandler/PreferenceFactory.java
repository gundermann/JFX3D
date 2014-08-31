package graphicpersistenshandler;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.DoubleProperty;
import preferencemenu.PropertyHelper;

public class PreferenceFactory {

	private static PreferenceFactory _instance;

	public static PreferenceFactory getInstance() {
		if (_instance == null) {
			_instance = new PreferenceFactory();
		}
		return _instance;
	}

	public ShapePreference createPrefFromObject3D(CommonObject3D object3d) {
		Map<String, String> prefMap = getTransferedPreferencedFromObject3D(object3d);
		ShapePreference preference = new ShapePreference(object3d.toString(),
				prefMap);
		return preference;
	}

	private Map<String, String> getTransferedPreferencedFromObject3D(
			CommonObject3D object3d) {
		Map<String, String> preferenceMap = new HashMap<String, String>();
		List<String> propertyNames = PropertyHelper.getInstance()
				.getPropertyNames(object3d);
		for (String propertyName : propertyNames) {
			DoubleProperty property = PropertyHelper.getInstance().getProperty(
					propertyName, object3d);
			preferenceMap.put(propertyName, String.valueOf(property.getValue()));
		}
		return preferenceMap;
	}

	public ComplexShapePreference createPrefFromComplexObject3D(
			ComplexObject3D complexObject) {
		Map<String, String> transferedPreferencedFromObject3D = getTransferedPreferencedFromObject3D(complexObject);
		List<ShapePreference> prefs = new ArrayList<ShapePreference>();
		for (CommonObject3D commonObject3D : complexObject.getShapes()) {
			ShapePreference childrenProperty = PreferenceFactory.getInstance()
					.createPrefFromObject3D(commonObject3D);
			prefs.add(childrenProperty);
		}
		return new ComplexShapePreference(transferedPreferencedFromObject3D,
				prefs);
	}

	public ComplexShapePreference createComplexPrefFromPrefMap(
			Map<String, String> prefs, List<ShapePreference> graphicObjectsPrefs) {
		return new ComplexShapePreference(prefs, graphicObjectsPrefs);
	}

	public ShapePreference createPrefFromPrefMap(String prefType,
			Map<String, String> prefMap) {
		return new ShapePreference(prefType, prefMap);
	}

}
