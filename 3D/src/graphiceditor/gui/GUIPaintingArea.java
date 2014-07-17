package graphiceditor.gui;

import graphiceditor.business.CommonObject3D;

import java.util.List;

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

	public void removeAll(List<CommonObject3D> objectsToRemove) {
		for (CommonObject3D commonObject3D : objectsToRemove) {
			remove(commonObject3D);
		}
	}

}
