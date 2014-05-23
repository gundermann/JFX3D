package graphiceditor;

import graphiceditor.handler.PaintingHandler;
import graphiceditor.handler.PaintingStartHandler;
import graphiceditor.handler.RectanlgePaintingHandler;

import java.util.HashMap;
import java.util.Map;

public class PaintingListenerProvider {

  public static Map<Painting, Class<? extends PaintingHandler>> getPaintingStartListener() {
    Map<Painting, Class<? extends PaintingHandler>> paintingStartListener = new HashMap<Painting, Class<? extends PaintingHandler>>();
    paintingStartListener.put( Painting.Rectangle, PaintingStartHandler.class );
    return paintingStartListener;
  }

  public static Map<Painting, Class<? extends PaintingHandler>> getPaintingListener() {
    Map<Painting, Class<? extends PaintingHandler>> paintingStartListener = new HashMap<Painting, Class<? extends PaintingHandler>>();
    paintingStartListener.put( Painting.Rectangle, RectanlgePaintingHandler.class );
    return paintingStartListener;
  }
}
