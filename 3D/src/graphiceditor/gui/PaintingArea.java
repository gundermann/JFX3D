package graphiceditor.gui;

import graphiceditor.graphicobjects.Object3D;
import graphiceditor.graphicobjects.Painting;

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
