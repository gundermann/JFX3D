package graphicpersistenshandler;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;
import graphiceditor.shapes.impl.Rectangle3D;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;
import graphicpersistenshandler.prefs.impl.ComplexPref;
import graphicpersistenshandler.prefs.impl.RectPreference;

import java.util.List;
import java.util.Map;

public class PreferenceFactory {

	private static PreferenceFactory _instance;
	
	public static PreferenceFactory getInstance() {
		if (_instance == null){
			_instance = new PreferenceFactory();
		}
		return _instance;
	}
	
	public ShapePreference createPrefFromObject3D(CommonObject3D object3d) {
		if(object3d instanceof Rectangle3D){
			return createRectPref((Rectangle3D) object3d);
		}
		return null;
	}

	private ShapePreference createRectPref(Rectangle3D object3d) {
		RectPreference pref = new RectPreference();
		pref.setBeginningX(object3d.getXPositionProperty().get());
		pref.setBeginningY(object3d.getYPositionProperty().get());
		pref.setBeginningZ(object3d.getZPositionProperty().get());
		pref.setHeight(object3d.getHeightProperty().get());
		pref.setWidth(object3d.getWidthProperty().get());
		pref.setRotationX(object3d.getXRotationProperty().getValue().intValue());
		pref.setRotationY(object3d.getYRotationProperty().getValue().intValue());
		pref.setRotationZ(object3d.getZRotationProperty().getValue().intValue());
		pref.setRed(object3d.getColor().getR().getValue().intValue());
		pref.setGreen(object3d.getColor().getG().getValue().intValue());
		pref.setBlue(object3d.getColor().getB().getValue().intValue());
		return pref;
	}

	public ComplexShapePreference createPrefFromComplexObject3D(
			ComplexObject3D graphicObject) {
		return new ComplexPref(graphicObject);
	}

	public ComplexShapePreference createComplexPrefFromPrefMap(Map<String, String> prefs, 
			List<ShapePreference> graphicObjectsPrefs) {
		return new ComplexPref(prefs, graphicObjectsPrefs);
	}

	public ShapePreference createPrefFromPrefMap(String prefType,
			Map<String, String> prefMap) {
		if(prefType.equals("rect")){
			return new RectPreference(prefMap);
		}
		return null;
	}

}
