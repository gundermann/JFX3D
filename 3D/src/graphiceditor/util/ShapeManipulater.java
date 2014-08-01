package graphiceditor.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.PropertyChange;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;

public class ShapeManipulater {

	private static ShapeManipulater _instance;

	public static ShapeManipulater getInstance() {
		if(_instance == null){
			_instance = new ShapeManipulater();
		}
		return _instance;
	}

	public void reset(CommonObject3D actualPainting,
			CommonObject3D originalPainting) {
		List<ChangeGraphicProperty> changesToOriginal = getPropertyValues(originalPainting);
		invokeChange(changesToOriginal , actualPainting);
	}

	private List<ChangeGraphicProperty> getPropertyValues(
			CommonObject3D originalPainting) {
		List<ChangeGraphicProperty> changes = new ArrayList<ChangeGraphicProperty>();
		List<String> propertyNames = PropertyHelper.getInstance().getPropertyNames(originalPainting);
		for (String name : propertyNames) {
			changes.add(new ChangeGraphicProperty(name, PropertyHelper.getInstance().getProperty(name, originalPainting).get()));
		}
		return changes ;
	}

	public void invokeChange(List<ChangeGraphicProperty> partialChanges,
			CommonObject3D animatedObject) {
		Method[] methods = animatedObject.getClass().getMethods();
		for (ChangeGraphicProperty property : partialChanges) {
			for (Method method : methods) {
				PropertyChange annotation = method
						.getAnnotation(PropertyChange.class);
				if (annotation != null
						&& annotation.name().equals(property.getPropertyName())) {
					try {
						method.invoke(animatedObject, property.getValue());
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
