package graphiceditor.gui;

import graphiceditor.business.Object3D;
import graphiceditor.business.Painting;

import java.util.List;

public interface PaintingArea extends DimensionArea {

  GUIPaintingArea getUI();

  void initPainting( Painting painting );

  void startPainting();

  Painting getPaintingMode();

  Object3D getActualPainting();

  void setActualPainting( Object3D painting );

  void finishPainting();

  void setActualPaintingById( int selectedIndex );

  List<String> getAllGraphicObjects();

	

}
