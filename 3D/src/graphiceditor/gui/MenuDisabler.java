package graphiceditor.gui;

public class MenuDisabler {

  public static void setDisableForRotation( boolean disable ) {
    GUIPaintingMenu.getInstance().setDisable( disable );
  }

}
