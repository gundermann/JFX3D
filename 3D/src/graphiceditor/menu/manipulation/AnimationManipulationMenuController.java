package graphiceditor.menu.manipulation;

import graphiceditor.AnimationFactory;
import graphiceditor.business.Animation;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AnimationManipulationMenuController {

	@FXML
	public void showAnimation() {
		Animation animation = AnimationFactory.getInstance().createAnimation(extractAnimationProperties(), getUI().getActualPainting());
		new Thread(animation).start();
	}

	private Map<String, Double> extractAnimationProperties() {
		Map<String, Double> animationPropertyMap = new HashMap<String, Double>();
		for (Label label : getUI().getUiElementsForAnimationSettings().keySet()) {
			TextField tf = getUI().getUiElementsForAnimationSettings()
					.get(label);
			try {
				if(!tf.getText().isEmpty()){
					animationPropertyMap.put(
							label.getText().toLowerCase().substring(0, label.getText().length()-2),
							Double.valueOf(tf.getText()));
				}
			} catch (ClassCastException cce) {
				System.out.println("no setting for " + label.getText());
			}
		}
		return animationPropertyMap;
	}

	private GUIAnimationManipulationMenu getUI() {
		return GUIAnimationManipulationMenu.getInstance();
	}
}
