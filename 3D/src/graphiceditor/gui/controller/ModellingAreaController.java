package graphiceditor.gui.controller;

import graphiceditor.gui.ModellingArea;
import graphiceditor.gui.PaintingArea;
import javafx.scene.Node;

public class ModellingAreaController implements ModellingArea {

  private final PaintingArea paintingArea;

  public ModellingAreaController() {
    paintingArea = new PaintingAreaController();
  }

  @Override
  public void add( Node shape ) {
    paintingArea.add( shape );
  }

  @Override
  public PaintingArea getPaintingArea() {
    return paintingArea;
  }

}
