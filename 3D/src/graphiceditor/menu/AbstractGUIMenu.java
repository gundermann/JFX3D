package graphiceditor.menu;

import javafx.stage.Stage;

public abstract class AbstractGUIMenu extends Stage {

	private boolean visible = false;
//	private PaintingArea paintingArea;

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		if (visible) {
			this.show();
		} else {
			this.hide();
		}
	}

//	public void setPaintingArea(PaintingArea selectedPaintingArea) {
//		this.paintingArea = selectedPaintingArea;
//	}

}
