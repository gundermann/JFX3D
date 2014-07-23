package graphiceditor.business.impl;

import graphiceditor.AnimationFactory;
import graphiceditor.business.Animation;
import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.Property;
import graphiceditor.domainspecific.PropertyChange;
import graphiceditor.domainspecific.values.observable.AnimationProperty;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.util.Duration;

public class AnimationImpl implements Animation {

	private List<AnimationProperty> properties;
	private Timeline timeline;

	public AnimationImpl() {
		timeline = new Timeline();
		properties = new ArrayList<AnimationProperty>();
	}

	@Override
	public void run() {
		for (AnimationProperty property : properties) {
			double starttime = System.currentTimeMillis();
			double endtime = starttime + property.getTime();
			List<ChangeGraphicProperty> partialChanges = extractPartialChanges(property);
			CommonObject3D animatedObject = property.getAnimatedObject();
			while (endtime > starttime) {
				invokeChange(partialChanges, animatedObject);
				try {
					Thread.sleep(100);
					endtime = endtime -100;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void invokeChange(List<ChangeGraphicProperty> partialChanges,
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

	private List<ChangeGraphicProperty> extractPartialChanges(
			AnimationProperty property) {
		double time = property.getTime();
		List<ChangeGraphicProperty> changedProperties = property
				.getChangedProperties();
		List<ChangeGraphicProperty> partialChanges = new ArrayList<ChangeGraphicProperty>();
		for (ChangeGraphicProperty changeGraphicProperty : changedProperties) {
			Double value = changeGraphicProperty.getValue();
			Double partialChangeValue = value / (time / 100);
			partialChanges.add(AnimationFactory.getInstance()
					.createChangeGraphicProperty(
							changeGraphicProperty.getPropertyName(),
							partialChangeValue));
		}
		return partialChanges;
	}

	private List<KeyFrame> convertPropertiesToKeyFrames() {
		List<KeyFrame> keyFrames = new ArrayList<KeyFrame>();
		for (AnimationProperty property : properties) {
			Duration time = new Duration(property.getTime());
			KeyValue[] values = new KeyValue[property.getChangedProperties()
					.size()];
			for (int i = 0; i < property.getChangedProperties().size(); i++) {
				WritableValue<Double> wirteable = extractWriteableValueFromGraphicObject(
						property.getAnimatedObject(), property
								.getChangedProperties().get(i)
								.getPropertyName());
				values[i] = new KeyValue(wirteable, property
						.getChangedProperties().get(i).getValue());
			}
			keyFrames.add(new KeyFrame(time, values));
		}
		return keyFrames;
	}

	private WritableValue<Double> extractWriteableValueFromGraphicObject(
			CommonObject3D animatedObject, String propertyName) {
		Method[] methods = animatedObject.getClass().getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(Property.class) != null
					&& method.getAnnotation(Property.class).name()
							.equals(propertyName)) {
				try {
					return (WritableValue<Double>) method.invoke(
							animatedObject, null);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void addProperty(AnimationProperty property) {
		properties.add(property);
	}

}
