package animation.business;

import animation.domainspecific.AnimationProperty;

public interface Animation extends Runnable{

	void addProperty(AnimationProperty property);
	
}
