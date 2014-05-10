package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;

public interface PaintingArea {

  void initPainting( Painting painting );

  void startPainting();

  Painting getPaintingMode();

  Node getActualPainting();

  void setActualPainting( Node painting );

  void finishPainting();

  void enableRotation();

  List<Group> getAllGraphicObjects();

  void add( Node shape );
}
