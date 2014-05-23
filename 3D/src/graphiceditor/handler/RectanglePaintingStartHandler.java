package graphiceditor.handler;

import graphiceditor.RectangleBuilder;
import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.impl.Rectangle3D;
import javafx.scene.input.MouseEvent;

public class RectanglePaintingStartHandler implements PaintingHandler {

	private PaintingArea paintingArea;

	@Override
	public void handle(MouseEvent event) {
		Rectangle3D rect =  RectangleBuilder.create()
				.x(event.getX()).y(event.getY()).build();
		paintingArea.setActualPainting(rect);
		paintingArea.startPainting();
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.paintingArea = paintingArea;

	}
}
