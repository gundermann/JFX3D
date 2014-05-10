package graphiceditor.gui.controller;

import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.ModellingArea;
import graphiceditor.gui.PaintingArea;
import javafx.scene.Node;

public class ModellingAreaController implements ModellingArea {

  private final DimensionArea dimensionArea;

  private final PaintingArea paintingArea;

  public ModellingAreaController() {
    dimensionArea = new DimensionAreaController();
    paintingArea = new PaintingAreaController();
    dimensionArea.setMainPane( paintingArea.getUI() );
  }

  @Override
  public void add( Node shape ) {
    dimensionArea.add( shape );
  }

  @Override
  public DimensionArea getDimensionArea() {
    return dimensionArea;
  }

  @Override
  public PaintingArea getPaintingArea() {
    return paintingArea;
  }

}
