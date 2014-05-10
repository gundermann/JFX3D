package graphiceditor.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIPaintingMenu extends Stage {

  public GUIPaintingMenu( PaintingMenuController paintingMenuController ) {
    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "fxml/paintingmenu.fxml" ) );
    fxmlLoader.setController( paintingMenuController );
    AnchorPane page;
    try {
      page = (AnchorPane) fxmlLoader.load();
      Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
          .depthBuffer( true ).build();
      setScene( scene );
      initStyle( StageStyle.UNDECORATED );
      setX( 200 );
      setY( 0 );
      show();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

}
