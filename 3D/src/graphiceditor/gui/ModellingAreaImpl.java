package graphiceditor.gui;

import graphiceditor.graphicobjects.Painting;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ModellingAreaImpl implements ModellingArea {

  private final DimensionArea dimensionArea;

  private final PaintingArea paintingArea;

  public ModellingAreaImpl() {
    dimensionArea = new GUIDimensionArea();
    paintingArea = new GUIPaintingArea();
    dimensionArea.setMainPane( (Pane) paintingArea );
  }

  @Override
  public void initPainting( Painting painting ) {
    paintingArea.initPainting( painting );
  }

  @Override
  public void enableRotation() {
    dimensionArea.enableRotation();
  }

  @Override
  public void add( Node shape ) {
    dimensionArea.add( shape );
  }

}
