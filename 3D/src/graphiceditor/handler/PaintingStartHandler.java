package graphiceditor.handler;

import graphiceditor.Object3DFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.gui.PaintingArea;
import javafx.scene.input.MouseEvent;

public class PaintingStartHandler implements PaintingHandler {

	private PaintingArea paintingArea;
	private Object3DFactory factory;
	
	public PaintingStartHandler(Object3DFactory factory) {
		this.factory = factory;
	}

	@Override
	public void handle(MouseEvent event) {
		CommonObject3D shape =  factory.create(event.getX(),event.getY());
		System.out.printf("Actual painting [%f, %f, %f]\n",shape.getXPositionProperty().get(), shape.getYPositionProperty().get(), shape.getXPositionProperty().get());
		paintingArea.setActualPainting(shape);
		paintingArea.startPainting();
	}

	@Override
	public void setPaintingArea(PaintingArea paintingArea) {
		this.paintingArea = paintingArea;
	}
}
