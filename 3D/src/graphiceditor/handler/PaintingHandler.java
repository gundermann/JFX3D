package graphiceditor.handler;

import graphiceditor.gui.PaintingArea;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface PaintingHandler extends EventHandler<MouseEvent> {

  void setPaintingArea( PaintingArea paintingArea );
}
