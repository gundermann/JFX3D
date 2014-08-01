package graphiceditor;

import java.util.Map;

import graphiceditor.business.Animation;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.impl.AnimationImpl;
import graphiceditor.domainspecific.values.observable.AnimationProperty;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;

public class AnimationFactory {

	private static AnimationFactory _instance;

	public static AnimationFactory getInstance() {
		if (_instance == null) {
			_instance = new AnimationFactory();
		}
		return _instance;
	}

	public Animation createAnimation(Map<String, Double> propertyMap,
			CommonObject3D graphic3D, Double time) {
		AnimationProperty property = new AnimationProperty(graphic3D);
		for (String propertyName : propertyMap.keySet()) {
			ChangeGraphicProperty changeGraphicProperty = createChangeGraphicProperty(
					propertyName, propertyMap.get(propertyName));
			property.addChangeGraphicProperty(changeGraphicProperty);
		}
		property.setTime(time);
		Animation animation = new AnimationImpl();
		animation.addProperty(property);
		return animation;
	}

	public ChangeGraphicProperty createChangeGraphicProperty(
			String propertyName, Double value) {
		 return new ChangeGraphicProperty(
				propertyName, value);
	}
}
