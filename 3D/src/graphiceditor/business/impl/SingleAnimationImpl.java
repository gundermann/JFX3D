package graphiceditor.business.impl;

import graphiceditor.AnimationFactory;
import graphiceditor.business.Animation;
import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.values.observable.AnimationProperty;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;
import graphiceditor.util.ShapeManipulater;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import preferencemenu.PropertyHelper;

public class SingleAnimationImpl implements Animation {

	private List<AnimationProperty> properties;
	private Timeline timeline;

	public SingleAnimationImpl() {
		timeline = new Timeline();
		properties = new ArrayList<AnimationProperty>();
	}

	@Override
	public void run() {
		AnimationProperty property = properties.get(0);
        timeline.setAutoReverse(true);
		timeline.getKeyFrames().addAll(convertToKeyFrame(property));
		timeline.play();
	}

	private List<KeyFrame> convertToKeyFrame(AnimationProperty property) {
		List<KeyFrame> keyFrameList = new ArrayList<KeyFrame>();
		for (ChangeGraphicProperty changeProperty : property.getChangedProperties()) {
			KeyValue kv = new KeyValue(PropertyHelper.getInstance().getProperty(changeProperty.getPropertyName(), property.getAnimatedObject()), changeProperty.getValue());
			KeyFrame kf = new KeyFrame(Duration.millis(property.getTime()), kv);
			keyFrameList.add(kf);
		}
		return keyFrameList ;
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
		AnimationProperty property = properties.get(0);
		double starttime = System.currentTimeMillis();
		double endtime = starttime + property.getTime();
		List<ChangeGraphicProperty> partialChanges = extractPartialChanges(property);
		CommonObject3D animatedObject = property.getAnimatedObject();
		while (endtime > starttime) {
			ShapeManipulater.getInstance().invokeChangeAdditional(partialChanges,
					animatedObject);
//			try {
//				Thread.sleep(100);
				endtime = endtime - 100;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

}
