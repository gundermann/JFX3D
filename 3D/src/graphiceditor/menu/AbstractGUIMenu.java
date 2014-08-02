package graphiceditor.menu;

import javafx.scene.layout.AnchorPane;

public abstract class AbstractGUIMenu extends AnchorPane {

//	private boolean visible = false;
//
//	public boolean isVisible() {
//		return visible;
//	}
//
//	public void setVisible(boolean visible) {
//		this.visible = visible;
//		if (visible) {
//			this.show();
//		} else {
//			this.hide();
//		}
//	}

	abstract public String getTitle();

}
