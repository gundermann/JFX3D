package graphiceditor;

import graphiceditor.gui.ModellingArea;
import graphiceditor.gui.controller.ModellingAreaController;

public class ModellingAreaFactory {

  private static ModellingAreaFactory _instance;

  public static ModellingAreaFactory getInstance() {
    if ( _instance == null )
      _instance = new ModellingAreaFactory();
    return _instance;
  }

  public ModellingArea createModellingArea() {
    return new ModellingAreaController();
  }

}
