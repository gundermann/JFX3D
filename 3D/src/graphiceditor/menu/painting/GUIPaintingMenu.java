package graphiceditor.menu.painting;

import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.AbstractGUIMenu;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class GUIPaintingMenu extends AbstractGUIMenu {

  private static GUIPaintingMenu _instance;

  private final PaintingMenuController controller;

  public GUIPaintingMenu( PaintingMenuController paintingMenuController ) {
    controller = paintingMenuController;
    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "paintingmenu.fxml" ) );
    fxmlLoader.setController( paintingMenuController );
    AnchorPane page;
    try {
      page = (AnchorPane) fxmlLoader.load();
      Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
          .depthBuffer( true ).build();
      setScene( scene );
      initStyle( StageStyle.UNDECORATED );
      setX( 400 );
      setY( 0 );
      show();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static GUIPaintingMenu getInstance() {
    if ( _instance == null ) {
      _instance = new GUIPaintingMenu( new PaintingMenuController() );
    }
    if ( !_instance.isVisible() ) {
      _instance.setVisible( false );
    }
    return _instance;

  }

  public void setPaintingArea( PaintingArea paintingArea ) {
    controller.setPaintingArea( paintingArea );
  }

  public void setDisable( boolean disable ) {
    getScene().getRoot().setDisable( disable );
  }

  public void updateComponents() {
    controller.updateComponents();
  }

}
