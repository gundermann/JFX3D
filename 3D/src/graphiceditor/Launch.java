package graphiceditor;

import graphiceditor.gui.GUIMain;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Launch extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primeStage ) throws Exception {
	  System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
    GUIMain.getInstance().toFront();
  }

}
