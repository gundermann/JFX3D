package graphiceditor.menu.painting;

import graphiceditor.Painting;
import graphiceditor.gui.PaintingArea;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PaintingMenuController {

	private PaintingArea actualPaintingArea;


	@FXML
	public void selectPaintRect() {
		actualPaintingArea.initPainting(Painting.Rectangle);
	}

	public void setPaintingArea(PaintingArea paintingArea) {
		this.actualPaintingArea = paintingArea;
	}

	
}
