package graphiceditor.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUIEditor extends Application {

  @Override
  public void start( Stage primStage ) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "fxml/main.fxml" ) );
    AnchorPane page = (AnchorPane) fxmlLoader.load();
    Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
        .depthBuffer( true ).build();
    primStage.setScene( scene );
    primStage.show();
  }

  public static void main( String[] args ) {
    launch( args );
  }

}
