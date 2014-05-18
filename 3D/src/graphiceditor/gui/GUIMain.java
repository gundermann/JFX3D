package graphiceditor.gui;

import java.awt.Toolkit;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIMain extends Stage {

  private static GUIMain _instance;

  public GUIMain() {
    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "fxml/main.fxml" ) );
    AnchorPane page;
    try {
      page = (AnchorPane) fxmlLoader.load();
      Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
          .depthBuffer( true ).build();
      setScene( scene );
      initStyle( StageStyle.UNDECORATED );
      show();
      setWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
      setX( 0 );
      setY( 0 );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static GUIMain getInstance() {
    if ( _instance == null ) {
      _instance = new GUIMain();
    }
    return _instance;
  }

}
