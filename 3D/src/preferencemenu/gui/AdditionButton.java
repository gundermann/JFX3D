package preferencemenu.gui;

import graphiceditor.business.CommonObject3D;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import preferencemenu.PropertyHelper;

class AdditionButton extends Button implements EventHandler<MouseEvent> {

	private String name;
	private CommonObject3D actualPainting;

	public AdditionButton(String name,
			CommonObject3D actualPainting) {
		super("+");
		this.name = name;
		this.actualPainting = actualPainting;
		setOnMouseClicked(this);
	}

	@Override
	public void handle(MouseEvent event) {
		PropertyHelper.getInstance().invokeChangingMethod(name,
				PropertyHelper.getInstance().getProperty(name, actualPainting).get() + 1, actualPainting);
	}

}
