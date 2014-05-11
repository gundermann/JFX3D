package graphiceditor;

import graphiceditor.gui.PaintingArea;
import graphiceditor.gui.controller.PaintingAreaController;

public class PaintingAreaFactory {

  private static PaintingAreaFactory _instance;

  public static PaintingAreaFactory getInstance() {
    if ( _instance == null )
      _instance = new PaintingAreaFactory();
    return _instance;
  }

  public PaintingArea createPaintingArea() {
    return new PaintingAreaController();
  }

}
