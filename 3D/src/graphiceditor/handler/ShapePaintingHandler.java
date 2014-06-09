package graphiceditor.handler;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.Object3D;
import javafx.scene.input.MouseEvent;

public class ShapePaintingHandler implements PaintingHandler {

	private Object3D shape;

	private double beginningX;

	private double beginningY;

	@Override
	public void handle(MouseEvent event) {
		if (event.getY() > beginningY)
			shape.changeHeightTo(event.getY()
					- shape.getYPositionProperty().get());
		else {
			shape.changeHeightTo(beginningY - event.getY());
			shape.getYPositionProperty().set(event.getY());
		}

		if (event.getX() > beginningX)
			shape.changeWidthTo(event.getX() - shape.getXPositionProperty().get());
		else {
			shape.changeWidthTo(beginningX - event.getX());
			shape.getXPositionProperty().set(event.getX());
		}
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.shape = paintingArea.getActualPainting();
		beginningX = shape.getXPositionProperty().get();
		beginningY = shape.getYPositionProperty().get();
	}
}
