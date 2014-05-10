package graphiceditor.gui;

import graphiceditor.gui.controller.DimensionMenuController;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIDimensionMenu extends Stage {

  private static GUIDimensionMenu _instance;

  private final DimensionMenuController controller;

  public GUIDimensionMenu( DimensionMenuController dimensionMenuController ) {
    controller = dimensionMenuController;
    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "fxml/dimensionmenu.fxml" ) );
    fxmlLoader.setController( dimensionMenuController );
    AnchorPane page;
    try {
      page = (AnchorPane) fxmlLoader.load();
      Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
          .depthBuffer( true ).build();
      setScene( scene );
      initStyle( StageStyle.UNDECORATED );
      setX( 0 );
      setY( 0 );
      show();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static GUIDimensionMenu getInstance() {
    if ( _instance == null ) {
      _instance = new GUIDimensionMenu( new DimensionMenuController() );
    }
    return _instance;
  }

  public void setDimensionArea( DimensionArea dimensionArea ) {
    controller.setDimensionArea( dimensionArea );
  }

}
