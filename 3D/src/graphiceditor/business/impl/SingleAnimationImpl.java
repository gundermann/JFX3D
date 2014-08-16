package graphiceditor.business.impl;

import graphiceditor.business.Animation;
import graphiceditor.domainspecific.values.observable.AnimationProperty;
import graphiceditor.domainspecific.values.observable.ChangeGraphicProperty;

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

	@Override
	public void addProperty(AnimationProperty property) {
		properties.add(property);
	}

}
