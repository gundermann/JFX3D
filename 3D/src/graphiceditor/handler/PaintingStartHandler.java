package graphiceditor.handler;

import graphiceditor.Object3DBuilder;
import graphiceditor.business.Object3D;
import graphiceditor.gui.PaintingArea;
import javafx.scene.input.MouseEvent;

public class PaintingStartHandler implements PaintingHandler {

	private PaintingArea paintingArea;
	private Class<? extends Object3D> shapeClass;
	
	public PaintingStartHandler(Class<? extends Object3D> shapeClass) {
		this.shapeClass = shapeClass;
	}

	@Override
	public void handle(MouseEvent event) {
		Object3D shape =  Object3DBuilder.create(shapeClass).
				x(event.getX()).y(event.getY()).build();
		System.out.printf("Actual painting [%f, %f, %f]\n",shape.getXPositionProperty().get(), shape.getYPositionProperty().get(), shape.getXPositionProperty().get());
		paintingArea.setActualPainting(shape);
		paintingArea.startPainting();
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.paintingArea = paintingArea;
	}
}
