package graphiceditor.gui;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.Painting;

import java.util.List;

public interface PaintingArea extends DimensionArea {

	GUIPaintingArea getUI();

	void initPainting(Painting painting);

	void startPainting();

	Painting getPaintingMode();

	CommonObject3D getActualPainting();

	void setActualPainting(CommonObject3D painting);

	void finishPainting();

	void setActualPaintingById(int selectedIndex);

	List<String> getAllGraphicObjectsAsString();
	
	List<CommonObject3D> getAllGraphicObjects();

	void addAll(List<CommonObject3D> shapesFromLoader);
	
	void removeByIndex(List<Integer> list);

}
