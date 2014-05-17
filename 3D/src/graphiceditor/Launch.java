package graphiceditor;

import graphiceditor.gui.GUIMain;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launch extends Application {

  public static void main( String[] args ) {
    launch( args );
  }

  @Override
  public void start( Stage primeStage ) throws Exception {
    GUIMain.getInstance().toFront();
  }

}
