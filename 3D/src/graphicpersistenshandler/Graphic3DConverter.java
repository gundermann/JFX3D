package graphicpersistenshandler;

import graphiceditor.Object3DFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.List;

import preferencemenu.PropertyHelper;

public class Graphic3DConverter {

	private static Graphic3DConverter _instance;

	public static Graphic3DConverter getInstance() {
		if (_instance == null) {
			_instance = new Graphic3DConverter();
		}
		return _instance;
	}

	public List<CommonObject3D> convertPreferencesTo3DGraphics(
			List<ShapePreference> prefs) {
		List<CommonObject3D> graphicObjects = new ArrayList<CommonObject3D>();
		for (ShapePreference preference : prefs) {
			Object3DFactory factoryFormPreference = PreferenceProvider
					.getInstance().getFactoryFormPreference(
							preference.getType());
			CommonObject3D object3D = factoryFormPreference.create(0, 0);
			transferPreferences(preference, object3D);
			graphicObjects.add(object3D);
		}
		return graphicObjects;
	}

	private void transferPreferences(ShapePreference preference,
			CommonObject3D object3d) {
		for (String propertyName : preference.getProperties().keySet()) {
			double value = Double.parseDouble(preference.getProperties().get(
					propertyName));
			PropertyHelper.getInstance().invokeChangingMethod(propertyName,
					value, object3d);
		}
		if(preference instanceof ComplexShapePreference)
			transferPropertiesOfChildren(object3d, ((ComplexShapePreference) preference).getGraphicPrefs());
			
	}

	private void transferPropertiesOfChildren(CommonObject3D object3d,
			List<ShapePreference> graphicPrefs) {
		List<CommonObject3D> childrenShapes = convertPreferencesTo3DGraphics(graphicPrefs);
		((ComplexObject3D) object3d).setShapes(childrenShapes);		
	}

}
