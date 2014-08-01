package graphiceditor;

import graphiceditor.business.Object3D;
import graphiceditor.gui.PaintingArea;
import graphiceditor.handler.PaintingFinishedHandler;
import graphiceditor.handler.PaintingHandler;
import graphiceditor.handler.PaintingStartHandler;
import graphiceditor.handler.ShapePaintingHandler;

public class PaintingListenerFactory {

  private static PaintingListenerFactory _instance;

  public static PaintingListenerFactory getInstance() {
    if ( _instance == null )
      _instance = new PaintingListenerFactory();
    return _instance;
  }

  public PaintingHandler createPaintingStartListener( PaintingArea paintingArea ) {
    Class<? extends Object3D> shapeClass = PaintingProvider.getPaintingClasses().get(
        paintingArea.getPaintingMode() );
    PaintingStartHandler paintingStartHandler = new PaintingStartHandler(shapeClass);
    paintingStartHandler.setPaintingArea(paintingArea);
    return paintingStartHandler;
  }

  public PaintingHandler createPaintingListener( PaintingArea paintingArea ) {
	  ShapePaintingHandler paintingHandler = new ShapePaintingHandler();
	  paintingHandler.setPaintingArea(paintingArea);
    return paintingHandler;
  }

  public PaintingHandler createPaintingFinishListener( PaintingArea paintingArea ) {
	  PaintingFinishedHandler paintingFinishedHandler = new PaintingFinishedHandler();
	  paintingFinishedHandler.setPaintingArea(paintingArea);
    return paintingFinishedHandler;
  }

}
