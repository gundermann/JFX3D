package graphiceditor.handler;

import graphiceditor.gui.GUIDimensionArea;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class PositionChangedHandler implements EventHandler<WindowEvent> {

  public PositionChangedHandler( GUIDimensionArea guiDimensionArea ) {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void handle( WindowEvent event ) {
    System.out.println( "hello" );
  }

}
