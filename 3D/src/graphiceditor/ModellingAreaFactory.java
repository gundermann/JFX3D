package graphiceditor;

import graphiceditor.gui.ModellingArea;
import graphiceditor.gui.ModellingAreaImpl;

public class ModellingAreaFactory {

  private static ModellingAreaFactory _instance;

  public static ModellingAreaFactory getInstance() {
    if ( _instance == null )
      _instance = new ModellingAreaFactory();
    return _instance;
  }

  public ModellingArea createModellingArea() {
    return new ModellingAreaImpl();
  }
}
