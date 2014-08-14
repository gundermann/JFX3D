package graphiceditor.business;

import graphiceditor.domainspecific.values.observable.AnimationProperty;

public interface Animation extends Runnable{

	void addProperty(AnimationProperty property);

	void start();
	
}
