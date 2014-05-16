package graphiceditor;

import graphiceditor.business.Painting;
import graphiceditor.handler.PaintingHandler;
import graphiceditor.handler.RectanglePaintingStartHandler;
import graphiceditor.handler.RectanlgePaintingHandler;

import java.util.HashMap;
import java.util.Map;

public class PaintingListenerProvider {

  public static Map<Painting, Class<? extends PaintingHandler>> getPaintingStartListener() {
    Map<Painting, Class<? extends PaintingHandler>> paintingStartListener = new HashMap<Painting, Class<? extends PaintingHandler>>();
    paintingStartListener.put( Painting.Rectangle, RectanglePaintingStartHandler.class );
    return paintingStartListener;
  }

  public static Map<Painting, Class<? extends PaintingHandler>> getPaintingListener() {
    Map<Painting, Class<? extends PaintingHandler>> paintingStartListener = new HashMap<Painting, Class<? extends PaintingHandler>>();
    paintingStartListener.put( Painting.Rectangle, RectanlgePaintingHandler.class );
    return paintingStartListener;
  }
}
