package graphiceditor.business.impl;

import graphiceditor.AnimationFactory;
import graphiceditor.business.Animation;
import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.values.observable.AnimationProperty;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;
import graphiceditor.util.ShapeManipulater;

import java.util.ArrayList;
import java.util.List;

public class AnimationImpl implements Animation {

	private List<AnimationProperty> properties;

	public AnimationImpl() {
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
				ShapeManipulater.getInstance().invokeChange(partialChanges, animatedObject);
				try {
					Thread.sleep(100);
					endtime = endtime -100;
				} catch (InterruptedException e) {
					e.printStackTrace();
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



	@Override
	public void addProperty(AnimationProperty property) {
		properties.add(property);
	}

	@Override
	public void start() {
		for (AnimationProperty property : properties) {
			double starttime = System.currentTimeMillis();
			double endtime = starttime + property.getTime();
			List<ChangeGraphicProperty> partialChanges = extractPartialChanges(property);
			CommonObject3D animatedObject = property.getAnimatedObject();
			while (endtime > starttime) {
				ShapeManipulater.getInstance().invokeChange(partialChanges, animatedObject);
				try {
					Thread.sleep(100);
					endtime = endtime -100;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
	}

}
