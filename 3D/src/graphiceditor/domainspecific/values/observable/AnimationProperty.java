package graphiceditor.domainspecific.values.observable;

import java.util.List;

import graphiceditor.business.CommonObject3D;

public class AnimationProperty {

	private double time;
	
	private CommonObject3D animatedObject;
	
	private List<ChangeGraphicProperty> changedProperties;
}
