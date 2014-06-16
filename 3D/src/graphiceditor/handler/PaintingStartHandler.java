package graphiceditor.handler;

import graphiceditor.ShapeBuilder;
import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.Object3D;
import javafx.scene.input.MouseEvent;

public class PaintingStartHandler implements PaintingHandler {

	private PaintingArea paintingArea;
	private Class<? extends Object3D> shapeClass;
	
	public PaintingStartHandler(Class<? extends Object3D> shapeClass) {
		this.shapeClass = shapeClass;
	}

	@Override
	public void handle(MouseEvent event) {
		Object3D shape =  ShapeBuilder.create(shapeClass).
				x(event.getX()).y(event.getY()).build();
		paintingArea.setActualPainting(shape);
		paintingArea.startPainting();
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.paintingArea = paintingArea;
	}
}
