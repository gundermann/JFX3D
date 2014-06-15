package graphicpersister;

import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.Rectangle3D;
import graphicpersister.prefs.RectPreference;
import graphicpersister.prefs.ShapePreference;

public class PreferenceFactory {

	public static ShapePreference createPrefFromObject3D(Object3D object3d) {
		if(object3d instanceof Rectangle3D){
			return createRectPref((Rectangle3D) object3d);
		}
		return null;
	}

	private static ShapePreference createRectPref(Rectangle3D object3d) {
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

}
