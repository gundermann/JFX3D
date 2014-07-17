package graphiceditor.handler;

import graphiceditor.business.Object3D;
import graphiceditor.gui.PaintingArea;
import javafx.scene.input.MouseEvent;

public class ShapePaintingHandler implements PaintingHandler {

	private Object3D shape;

	private double initinalX;

	private double initinalY;

	@Override
	public void handle(MouseEvent event) {
		shape.paint(event.getX(), event.getY(), initinalX, initinalY);
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.shape = (Object3D) paintingArea.getActualPainting();
		initinalX = shape.getXPositionProperty().get();
		initinalY = shape.getYPositionProperty().get();
	}
}
