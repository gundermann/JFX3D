package graphicpersistenshandler;

import graphiceditor.ComplexObject3DFactory;
import graphiceditor.Ellipse3DFactory;
import graphiceditor.Object3DFactory;
import graphiceditor.Rectangle3DFactory;

import java.util.HashMap;
import java.util.Map;

public class FactoryPreferenceTypeAssoziator {

	private static FactoryPreferenceTypeAssoziator _instance;

	public static FactoryPreferenceTypeAssoziator getInstance() {
		if (_instance == null)
			_instance = new FactoryPreferenceTypeAssoziator();
		return _instance;
	}

	public Object3DFactory getFactoryFormPreference(String type) {
		Map<String, Object3DFactory> paintingStartListener = new HashMap<String, Object3DFactory>();
		paintingStartListener
				.put("Rectangle", Rectangle3DFactory.getInstance());
		paintingStartListener.put("Ellipse", Ellipse3DFactory.getInstance());
		paintingStartListener.put("complex",
				ComplexObject3DFactory.getInstance());
		return paintingStartListener.get(type);
	}

}
