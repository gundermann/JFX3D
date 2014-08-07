package graphiceditor.menu.painting;

import graphiceditor.business.Painting;
import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.AbstractMenuController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class PaintingMenuController extends AbstractMenuController{

	private PaintingArea actualPaintingArea;


	@FXML
	public void selectPaintRect() {
		actualPaintingArea.initPainting(Painting.Rectangle);
	}
	
	@FXML
	public void selectPaintEllipse() {
		actualPaintingArea.initPainting(Painting.Ellipse);
	}

	public void setPaintingArea(PaintingArea paintingArea) {
		this.actualPaintingArea = paintingArea;
	}

	@Override
	protected AnchorPane getUI() {
		return GUIPaintingMenu.getInstance();
	}

	
}
