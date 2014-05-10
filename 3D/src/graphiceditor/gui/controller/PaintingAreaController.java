package graphiceditor.gui.controller;

import graphiceditor.PaintingListenerFactory;
import graphiceditor.graphicobjects.Painting;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.gui.GUIPaintingArea;
import graphiceditor.gui.PaintingArea;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class PaintingAreaController extends DimensionAreaController implements PaintingArea {

  private Painting paintingMode = Painting.None;

  private EventHandler<MouseEvent> mouseMoveHandler;

  private EventHandler<MouseEvent> mouseClickHandler;

  public void setMouseMoveHandler( EventHandler<MouseEvent> listener ) {
    getUI().addEventHandler( MouseEvent.MOUSE_MOVED, listener );
    mouseMoveHandler = listener;
  }

  public void setMouseClickHandler( EventHandler<MouseEvent> listener ) {
    if ( mouseClickHandler != null )
      getUI().removeEventHandler( MouseEvent.MOUSE_CLICKED, mouseClickHandler );
    getUI().addEventHandler( MouseEvent.MOUSE_CLICKED, listener );
    mouseClickHandler = listener;
  }

  @Override
  public void finishPainting() {
    paintingMode = Painting.None;
    getUI().saveActualPaintingIntoGraphicObjects();
    getUI().removeEventHandler( MouseEvent.MOUSE_MOVED, mouseMoveHandler );
    getUI().removeEventHandler( MouseEvent.MOUSE_CLICKED, mouseClickHandler );
  }

  @Override
  public void startPainting() {
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingFinishListener( this ) );
    setMouseMoveHandler( PaintingListenerFactory.getInstance().createPaintingListener( this ) );
  }

  @Override
  public List<Node> getAllGraphicObjects() {
    return getUI().getAllGraphicObjects();
  }

  @Override
  public Painting getPaintingMode() {
    return paintingMode;
  }

  @Override
  public Node getActualPainting() {
    return getUI().getActualPainting();
  }

  @Override
  public void setActualPainting( Node painting ) {
    getUI().setActualPainting( painting );
  }

  @Override
  public void initPainting( Painting painting ) {
    paintingMode = painting;
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingStartListener( this ) );
  }

  @Override
  public GUIPaintingArea getUI() {
    return (GUIPaintingArea) super.getUI();
  }

  @Override
  protected GUIDimensionArea getNewGUIInstance() {
    return new GUIPaintingArea();
  }
}