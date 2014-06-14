package graphiceditor.gui;

import graphiceditor.shapes.Object3D;

public class GUIPaintingArea extends GUIDimensionArea {

	private Object3D actualPainting;

	public Object3D getActualPainting() {
		return actualPainting;
	}

	public void setActualPainting(Object3D actualPainting) {
		this.actualPainting = actualPainting;
		add(actualPainting);
	}

	public void resetActualPainting() {
		actualPainting = null;
	}

}
