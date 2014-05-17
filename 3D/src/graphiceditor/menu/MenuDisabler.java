package graphiceditor.menu;

import graphiceditor.menu.painting.GUIPaintingMenu;

public class MenuDisabler {

  public static void setDisableForRotation( boolean disable ) {
    GUIPaintingMenu.getInstance().setDisable( disable );
  }

}
