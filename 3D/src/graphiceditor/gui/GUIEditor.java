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

public class GUIEditor extends Stage {

  private static GUIEditor _instance;

  public GUIEditor() {
    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "fxml/main.fxml" ) );
    AnchorPane page;
    try {
      page = (AnchorPane) fxmlLoader.load();
      Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
          .depthBuffer( true ).build();
      setScene( scene );
      initStyle( StageStyle.UNDECORATED );
      show();
      setX( Toolkit.getDefaultToolkit().getScreenSize().getWidth() - scene.getWidth() );
      setY( 0 );
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void bringToFront() {
    if ( _instance == null ) {
      _instance = new GUIEditor();
    }
    _instance.toFront();
  }

}
