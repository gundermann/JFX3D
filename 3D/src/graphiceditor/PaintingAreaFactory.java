package graphiceditor;

import graphiceditor.gui.GUIPaintingArea;

public class PaintingAreaFactory {

  private static PaintingAreaFactory _instance;

  public static PaintingAreaFactory getInstance() {
    if ( _instance == null )
      _instance = new PaintingAreaFactory();
    return _instance;
  }

  public GUIPaintingArea createDimensionArea() {
    return new GUIPaintingArea();
  }
}
