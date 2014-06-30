package graphicpersistenshandler;

import java.util.ArrayList;
import java.util.List;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;
import graphiceditor.shapes.impl.ComplexObject3DImpl;
import graphiceditor.shapes.impl.Rectangle3D;
import graphicpersistenshandler.prefs.RectPreference;
import graphicpersistenshandler.prefs.ShapePreference;

public class PreferenceFactory {

	private static int currentComplexId = 0;

	public static List<ShapePreference> createPrefFromObject3D(CommonObject3D object3d) {
		if(object3d instanceof ComplexObject3D){
			currentComplexId++;
			return createComplexPref((ComplexObject3D) object3d);
		}
		if(object3d instanceof Rectangle3D){
			return createRectPref((Rectangle3D) object3d);
		}
		return null;
	}

	private static List<ShapePreference> createComplexPref(ComplexObject3D object3d) {
		List<ShapePreference> prefList = new ArrayList<ShapePreference>();
		for(CommonObject3D shape : object3d.getShapes()){
			List<ShapePreference> pref = createPrefFromObject3D(shape);
			prefList.addAll(pref);
		}
		for (ShapePreference pref : prefList) {
			pref.setComplexId(currentComplexId);
		}
		return prefList;
	}

	private static List<ShapePreference> createRectPref(Rectangle3D object3d) {
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
		List<ShapePreference> prefList = new ArrayList<ShapePreference>();
		prefList.add(pref);
		return prefList ;
	}

}
