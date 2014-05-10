package graphiceditor.gui;

import graphiceditor.PaintingListenerFactory;
import graphiceditor.graphicobjects.Painting;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GUIPaintingArea extends Pane implements PaintingArea {

  private Painting paintingMode = Painting.None;

  private EventHandler<MouseEvent> mouseMoveHandler;

  private EventHandler<MouseEvent> mouseClickHandler;

  private Node actualPainting;

  private final List<Node> allPaintingObject = new ArrayList<Node>();

  public GUIPaintingArea() {
    setStyle( "-fx-background-color:white;" );
  }

  public void setMouseMoveHandler( EventHandler<MouseEvent> listener ) {
    addEventHandler( MouseEvent.MOUSE_MOVED, listener );
    mouseMoveHandler = listener;
  }

  public void setMouseClickHandler( EventHandler<MouseEvent> listener ) {
    if ( mouseClickHandler != null )
      removeEventHandler( MouseEvent.MOUSE_CLICKED, mouseClickHandler );
    addEventHandler( MouseEvent.MOUSE_CLICKED, listener );
    mouseClickHandler = listener;
  }

  @Override
  public void finishPainting() {
    paintingMode = Painting.None;
    allPaintingObject.add( actualPainting );
    actualPainting = null;
    removeEventHandler( MouseEvent.MOUSE_MOVED, mouseMoveHandler );
    removeEventHandler( MouseEvent.MOUSE_CLICKED, mouseClickHandler );
  }

  @Override
  public void startPainting() {
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingFinishListener( this ) );
    setMouseMoveHandler( PaintingListenerFactory.getInstance().createPaintingListener( this ) );
  }

  @Override
  public List<Node> getAllGraphicObjects() {
    return allPaintingObject;
  }

  @Override
  public Painting getPaintingMode() {
    return paintingMode;
  }

  @Override
  public Node getActualPainting() {
    return actualPainting;
  }

  @Override
  public void setActualPainting( Node painting ) {
    actualPainting = painting;
    getChildren().add( actualPainting );
  }

  @Override
  public void initPainting( Painting painting ) {
    paintingMode = painting;
    addEventFilter( MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
      @Override
      public void handle( MouseEvent mouseEvent ) {
        System.out.println( "mouse click detected! " + mouseEvent.getSource() );
      }
    } );
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingStartListener( this ) );
  }

}