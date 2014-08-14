package graphiceditor.util;

import graphiceditor.AnimationFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import preferencemenu.PropertyHelper;
import preferencemenu.util.PropertyChange;

public class ShapeManipulater {

	private static ShapeManipulater _instance;

	public static ShapeManipulater getInstance() {
		if (_instance == null) {
			_instance = new ShapeManipulater();
		}
		return _instance;
	}

	public void reset(CommonObject3D actualPainting,
			CommonObject3D originalPainting) {
		List<ChangeGraphicProperty> changesToOriginal = getPropertyValues(originalPainting);
		invokeChange(changesToOriginal, actualPainting);
	}

	private List<ChangeGraphicProperty> getPropertyValues(
			CommonObject3D originalPainting) {
		List<ChangeGraphicProperty> changes = new ArrayList<ChangeGraphicProperty>();
		List<String> propertyNames = PropertyHelper.getInstance()
				.getPropertyNames(originalPainting);
		for (String name : propertyNames) {
			changes.add(new ChangeGraphicProperty(name, PropertyHelper
					.getInstance().getProperty(name, originalPainting).get()));
		}
		return changes;
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

	public void invokeChangeAdditional(
			List<ChangeGraphicProperty> partialChanges,
			CommonObject3D animatedObject) {
		List<ChangeGraphicProperty> additionalChanges = new ArrayList<ChangeGraphicProperty>();
		for (ChangeGraphicProperty changeProperty : partialChanges) {
			DoubleProperty property = PropertyHelper.getInstance().getProperty(
					changeProperty.getPropertyName(), animatedObject);
			ChangeGraphicProperty additionalChangeGraphicProperty = AnimationFactory
					.getInstance().createChangeGraphicProperty(
							changeProperty.getPropertyName(),
							changeProperty.getValue() + property.get());
			additionalChanges.add(additionalChangeGraphicProperty);
		}
		invokeChange(additionalChanges, animatedObject);
	}

}
