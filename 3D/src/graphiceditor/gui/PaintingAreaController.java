package graphiceditor.gui;

import graphiceditor.PaintingListenerFactory;
import graphiceditor.graphicobjects.Painting;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class PaintingAreaController implements PaintingArea {

  private Painting paintingMode = Painting.None;

  private EventHandler<MouseEvent> mouseMoveHandler;

  private EventHandler<MouseEvent> mouseClickHandler;

  private final GUIPaintingArea pane;

  public PaintingAreaController() {
    pane = new GUIPaintingArea();
  }

  public void setMouseMoveHandler( EventHandler<MouseEvent> listener ) {
    pane.addEventHandler( MouseEvent.MOUSE_MOVED, listener );
    mouseMoveHandler = listener;
  }

  public void setMouseClickHandler( EventHandler<MouseEvent> listener ) {
    if ( mouseClickHandler != null )
      pane.removeEventHandler( MouseEvent.MOUSE_CLICKED, mouseClickHandler );
    pane.addEventHandler( MouseEvent.MOUSE_CLICKED, listener );
    mouseClickHandler = listener;
  }

  @Override
  public void finishPainting() {
    paintingMode = Painting.None;
    pane.saveActualPaintingIntoGraphicObjects();
    pane.removeEventHandler( MouseEvent.MOUSE_MOVED, mouseMoveHandler );
    pane.removeEventHandler( MouseEvent.MOUSE_CLICKED, mouseClickHandler );
  }

  @Override
  public void startPainting() {
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingFinishListener( this ) );
    setMouseMoveHandler( PaintingListenerFactory.getInstance().createPaintingListener( this ) );
  }

  @Override
  public List<Node> getAllGraphicObjects() {
    return pane.getAllGraphicObjects();
  }

  @Override
  public Painting getPaintingMode() {
    return paintingMode;
  }

  @Override
  public Node getActualPainting() {
    return pane.getActualPainting();
  }

  @Override
  public void setActualPainting( Node painting ) {
    pane.setActualPainting( painting );
  }

  @Override
  public void initPainting( Painting painting ) {
    paintingMode = painting;
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingStartListener( this ) );
  }

  @Override
  public GUIPaintingArea getUI() {
    return pane;
  }

}