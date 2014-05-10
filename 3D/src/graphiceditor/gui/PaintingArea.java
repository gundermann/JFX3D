package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;
import javafx.scene.Node;

public interface PaintingArea extends DimensionArea {

  GUIPaintingArea getUI();

  void initPainting( Painting painting );

  void startPainting();

  Painting getPaintingMode();

  Node getActualPainting();

  void setActualPainting( Node painting );

  void finishPainting();

  void setActualPaintingById( int selectedIndex );

}
