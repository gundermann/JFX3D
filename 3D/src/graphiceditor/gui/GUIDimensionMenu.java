package graphiceditor.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIDimensionMenu extends Stage {

  public GUIDimensionMenu( DimensionMenuController dimensionMenuController ) {
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

}
