package graphiceditor;

import graphiceditor.business.Animation;

public class AnimationHandler {

	private static AnimationHandler _instance;

	public static AnimationHandler getInstance() {
		if(_instance == null)
			_instance = new AnimationHandler();
		return _instance;
	}

	public void startAnimation(Animation animation) {
		new Thread(animation).start();		
	}

}
