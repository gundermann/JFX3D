package graphiceditor.domainspecific.values.observable;

import graphiceditor.business.CommonObject3D;

import java.util.ArrayList;
import java.util.List;

public class AnimationProperty {

	private double time;
	
	private CommonObject3D animatedObject;
	
	private List<ChangeGraphicProperty> changedProperties;

	public AnimationProperty(CommonObject3D graphic3d) {
		this.animatedObject = graphic3d;
		this.time = 10000;
		this.changedProperties = new ArrayList<ChangeGraphicProperty>();
	}
	
	public void addChangeGraphicProperty(ChangeGraphicProperty property){
		this.changedProperties.add(property);
	}

	public double getTime() {
		return time;
	}

	public CommonObject3D getAnimatedObject() {
		return animatedObject;
	}

	public List<ChangeGraphicProperty> getChangedProperties() {
		return changedProperties;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	

	
}
