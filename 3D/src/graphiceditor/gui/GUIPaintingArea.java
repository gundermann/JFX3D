package graphiceditor.gui;

import graphiceditor.shapes.CommonObject3D;

public class GUIPaintingArea extends GUIDimensionArea {

	private CommonObject3D actualPainting;

	public CommonObject3D getActualPainting() {
		return actualPainting;
	}

	public void setActualPainting(CommonObject3D actualPainting) {
		this.actualPainting = actualPainting;
		add(actualPainting);
	}

	public void resetActualPainting() {
		actualPainting.setSelected(false);
		actualPainting = null;
	}

}
