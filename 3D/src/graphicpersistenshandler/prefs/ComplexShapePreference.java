package graphicpersistenshandler.prefs;

import java.util.List;
import java.util.Map;

public class ComplexShapePreference extends ShapePreference  {

	private List<ShapePreference> prefs;

	public ComplexShapePreference(Map<String, String> prefMap, List<ShapePreference> children) {
		super("complex", prefMap);
		prefs = children;
	}


//
//	public ComplexShapePreference(Map<String, String> prefs, List<ShapePreference> graphicObjects) {
//		setPrefValues(prefs);
//		this.prefs = graphicObjects;
//	}
//
//	public ComplexShapePreference(ComplexObject3D complexGraphicObject) {
//		setTitle(complexGraphicObject.toString());
//		List<ShapePreference> graphicList = new ArrayList<ShapePreference>();
//		for (CommonObject3D graphic : complexGraphicObject.getShapes()) {
//			graphicList.add(PreferenceFactory.getInstance()
//					.createPrefFromObject3D(graphic));
//		}
//		this.prefs = graphicList;
//
//		setBeginningX(complexGraphicObject.getXPositionProperty().get());
//		setBeginningY(complexGraphicObject.getYPositionProperty().get());
//		setBeginningZ(complexGraphicObject.getZPositionProperty().get());
//		setRotationX(complexGraphicObject.getXRotationProperty().get());
//		setRotationY(complexGraphicObject.getYRotationProperty().get());
//		setRotationZ(complexGraphicObject.getZRotationProperty().get());
//	}
//
//	@Override
//	public CommonObject3D createShape() {
//		return ComplexObject3DFactory.getInstance().createKomplexShapeFromPref(this);
//	}
//
//	@Override
//	public String getPrefType() {
//		return "complex";
//	}
//
	public List<ShapePreference> getGraphicPrefs() {
		return prefs;
	}
}
