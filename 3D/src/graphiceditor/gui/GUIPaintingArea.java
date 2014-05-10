package graphiceditor.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.stage.Stage;
import graphiceditor.PaintingListenerFactory;
import graphiceditor.graphicobjects.Painting;
import graphiceditor.handler.MouseRotationHandler;

public class GUIPaintingArea extends Stage implements PaintingArea {

  public DoubleProperty rootAngleX = new SimpleDoubleProperty();

  public DoubleProperty rootAngleY = new SimpleDoubleProperty();

  private Painting paintingMode = Painting.None;

  private EventHandler<MouseEvent> mouseMoveHandler;

  private EventHandler<MouseEvent> mouseClickHandler;

  private Node actualPainting;

  private final List<Node> allPaintingObject = new ArrayList<Node>();

  private AnchorPane canvas;

  private MouseRotationHandler mouseDragHandler;

  public GUIPaintingArea() {
    Scene scene = SceneBuilder.create().root( createCanvas() ).camera( PerspectiveCameraBuilder.create().build() )
        .depthBuffer( true ).build();
    scene.setFill( Color.BLUE );
    setScene( scene );
    setProperties();
    show();
  }

  private void setProperties() {
    canvas.prefWidthProperty().bind( getScene().widthProperty() );
    canvas.prefHeightProperty().bind( getScene().heightProperty() );
    final Rotate rootRotateX = RotateBuilder.create().pivotX( 0 ).pivotY( getScene().getWidth() / 2 ).pivotZ( 0 )
        .axis( Rotate.X_AXIS ).build();
    rootRotateX.angleProperty().bind( rootAngleX );

    final Rotate rootRotateY = RotateBuilder.create().pivotX( getScene().getX() / 2 ).pivotY( 0 ).pivotZ( 0 )
        .axis( Rotate.Y_AXIS ).build();
    rootRotateY.angleProperty().bind( rootAngleY );
    canvas.getTransforms().addAll( rootRotateX, rootRotateY );
  }

  public AnchorPane createCanvas() {
    canvas = new AnchorPane();
    return canvas;
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
  public void initPainting( Painting painting ) {
    paintingMode = painting;
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingStartListener( this ) );
  }

  @Override
  public void startPainting() {
    setMouseMoveHandler( PaintingListenerFactory.getInstance().createPaintingListener( this ) );
    setMouseClickHandler( PaintingListenerFactory.getInstance().createPaintingFinishListener( this ) );
  }

  @Override
  public void enableRotation() {
    setDragHandler( new MouseRotationHandler( rootAngleX, rootAngleY ) );
  }

  private void setDragHandler( MouseRotationHandler mouseRotationHandler ) {
    addEventHandler( MouseEvent.MOUSE_DRAGGED, mouseRotationHandler );
    mouseDragHandler = mouseRotationHandler;
  }

  @Override
  public List<Group> getAllGraphicObjects() {
    // TODO Auto-generated method stub
    return null;
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
    add( painting );
  }

  @Override
  public void add( Node shape ) {
    canvas.getChildren().add( shape );
  }
}