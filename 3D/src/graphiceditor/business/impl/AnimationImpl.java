package graphiceditor.business.impl;

import graphiceditor.business.Animation;
import graphiceditor.domainspecific.values.observable.AnimationProperty;

import java.util.List;

public class AnimationImpl implements Animation{

	private List<AnimationProperty> properties;

	@Override
	public void run() {
		for(AnimationProperty animationProp : properties){
			
		}
	}

	@Override
	public void addProperty(AnimationProperty property) {
		// TODO Auto-generated method stub
		
	}
	
}
