package preferencemenu.gui;

import graphiceditor.business.CommonObject3D;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public abstract class AbstractPropertyButton extends Button implements EventHandler<MouseEvent> {
	
	protected String name;
	protected CommonObject3D object;

	public AbstractPropertyButton(String caption, String name, CommonObject3D o) {
		super(caption);
		this.name = name;
		this.object = object;
		setOnMouseClicked(this);
	}


}
