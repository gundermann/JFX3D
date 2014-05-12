package graphiceditor.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

public class GUIPaintingArea extends GUIDimensionArea {

  private Node actualPainting;

  private final List<Node> allGraphicObjects = new ArrayList<Node>();

  // public GUIPaintingArea() {
  // setStyle( "-fx-background-color:white;" );
  // }

  public Node getActualPainting() {
    return actualPainting;
  }

  public void setActualPainting( Node actualPainting ) {
    this.actualPainting = actualPainting;
    add( actualPainting );
  }

  public List<Node> getAllGraphicObjects() {
    return allGraphicObjects;
  }

  public void saveActualPaintingIntoGraphicObjects() {
    allGraphicObjects.add( actualPainting );
    actualPainting = null;
  }

}
