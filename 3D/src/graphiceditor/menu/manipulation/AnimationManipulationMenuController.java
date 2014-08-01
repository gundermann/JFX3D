package graphiceditor.menu.manipulation;

import graphiceditor.AnimationFactory;
import graphiceditor.business.Animation;
import graphiceditor.business.CommonObject3D;
import graphiceditor.util.AnimationHandler;
import graphiceditor.util.Cloner;
import graphiceditor.util.ShapeManipulater;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AnimationManipulationMenuController {

	@FXML 
	public TextField tfTime;
	private CommonObject3D actualPainting;
	private CommonObject3D originalPainting;
	
	@FXML
	public void showAnimation() {
		Animation animation = AnimationFactory.getInstance().createAnimation(extractAnimationProperties(), getUI().getActualPainting(), getTime());
		AnimationHandler.getInstance().startAnimation(animation);
	}

	private Double getTime() {
		return Double.valueOf(tfTime.getText());
	}

	@FXML
	public void saveAnimation(){
		ShapeManipulater.getInstance().reset(actualPainting,originalPainting);
	}
	
	@FXML
	public void discardAnimation(){
		ShapeManipulater.getInstance().reset(actualPainting,originalPainting);
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

	public void setActualPainting(CommonObject3D actualPainting) {
		this.actualPainting = actualPainting;
		this.originalPainting = Cloner.getInstance().createCopy(actualPainting);
	}
}
