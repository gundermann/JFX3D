package graphiceditor;

import graphiceditor.gui.PaintingArea;
import graphiceditor.handler.PaintingFinishedHandler;
import graphiceditor.handler.PaintingHandler;

public class PaintingListenerFactory {

  private static PaintingListenerFactory _instance;

  public static PaintingListenerFactory getInstance() {
    if ( _instance == null )
      _instance = new PaintingListenerFactory();
    return _instance;
  }

  public PaintingHandler createPaintingStartListener( PaintingArea paintingArea ) {
    Class<? extends PaintingHandler> listenerClass = PaintingListenerProvider.getPaintingStartListener().get(
        paintingArea.getPaintingMode() );
    return initPainingHandler( listenerClass, paintingArea );
  }

  public PaintingHandler createPaintingListener( PaintingArea paintingArea ) {
    Class<? extends PaintingHandler> listenerClass = PaintingListenerProvider.getPaintingListener().get(
        paintingArea.getPaintingMode() );
    return initPainingHandler( listenerClass, paintingArea );
  }

  public PaintingHandler createPaintingFinishListener( PaintingArea paintingArea ) {
    return initPainingHandler( PaintingFinishedHandler.class, paintingArea );
  }

  private PaintingHandler initPainingHandler( Class<? extends PaintingHandler> listenerClass, PaintingArea paintingArea ) {
    PaintingHandler paintingHandler = null;
    try {
      paintingHandler = listenerClass.newInstance();
      paintingHandler.setPaintingArea( paintingArea );
    }
    catch ( InstantiationException | IllegalAccessException e ) {
      e.printStackTrace();
    }
    return paintingHandler;
  }
}
