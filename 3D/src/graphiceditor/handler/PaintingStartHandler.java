package graphiceditor.handler;

import graphiceditor.ShapeBuilder;
import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.impl.Rectangle3D;
import javafx.scene.input.MouseEvent;

public class PaintingStartHandler implements PaintingHandler {

	private PaintingArea paintingArea;

	@Override
	public void handle(MouseEvent event) {
		Rectangle3D rect =  (Rectangle3D) ShapeBuilder.create(Rectangle3D.class).
				x(event.getX()).y(event.getY()).build();
		paintingArea.setActualPainting(rect);
		paintingArea.startPainting();
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.paintingArea = paintingArea;

	}
}
