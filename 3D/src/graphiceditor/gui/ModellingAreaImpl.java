package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;
import javafx.scene.Node;

public class ModellingAreaImpl implements ModellingArea {

  private final DimensionArea dimensionArea;

  private final PaintingArea paintingArea;

  public ModellingAreaImpl() {
    dimensionArea = new DimensionAreaController();
    paintingArea = new PaintingAreaController();
    dimensionArea.setMainPane( paintingArea.getUI() );
  }

  @Override
  public void initPainting( Painting painting ) {
    paintingArea.initPainting( painting );
  }

  @Override
  public void enableZRotation() {
    dimensionArea.enableZRotation();
  }

  @Override
  public void add( Node shape ) {
    dimensionArea.add( shape );
  }

}
