package graphiceditor.util;

import graphiceditor.business.CommonObject3D;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SubtractionButton extends Button implements EventHandler<ActionEvent> {

	private String name;
	private CommonObject3D actualPainting;

	public SubtractionButton( String name, CommonObject3D actualPainting) {
		super("-");
		this.name = name;
		this.actualPainting = actualPainting;
		setOnAction(this);
	}

	@Override
	public void handle(ActionEvent arg0) {
		PropertyHelper.getInstance().invokeChangingMethod(name, PropertyHelper.getInstance().getProperty(name, actualPainting).get()-1, actualPainting);
	}

}
