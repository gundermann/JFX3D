package graphiceditor.gui.controller;

import graphiceditor.RotationHandlerFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.handler.AbstractMouseDragRotationHandler;
import javafx.beans.property.Property;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DimensionAreaController implements DimensionArea {

	private final GUIDimensionArea gui;

	private EventHandler<MouseEvent> mouseDragRotationHandler;

	private AbstractMouseDragRotationHandler mouseReleaseRotationHandler;

	public DimensionAreaController() {
		gui = getNewGUIInstance();
	}

	protected GUIDimensionArea getNewGUIInstance() {
		return new GUIDimensionArea();
	}

	protected GUIDimensionArea getUI() {
		return gui;
	}

	@Override
	public Pane getMainPane() {
		return gui.getMainPane();
	}

	@Override
	public void add(CommonObject3D shape) {
		gui.add(shape);
	}

	@Override
	public void enableZRotation() {
		gui.enableZRotation();
		setMouseRotationHandler(RotationHandlerFactory.getInstance()
				.createHorizontalRotationHandler(gui.getZRotationProperty()));
	}

	private void setMouseRotationHandler(
			AbstractMouseDragRotationHandler mouseRotationHandler) {
		removeMouseRotationHandler();
		this.mouseDragRotationHandler = mouseRotationHandler;
		this.mouseReleaseRotationHandler = mouseRotationHandler;
		gui.addEventHandler(MouseEvent.MOUSE_DRAGGED,
				this.mouseDragRotationHandler);
		gui.addEventHandler(MouseEvent.MOUSE_RELEASED,
				this.mouseReleaseRotationHandler);
	}

	@Override
	public void setMainPane(AnchorPane mainPane) {
		gui.setMainPane(mainPane);
	}

	@Override
	public void enableXRotation() {
		gui.enableXRotation();
		setMouseRotationHandler(RotationHandlerFactory.getInstance()
				.createVerticalRotationHandler(gui.getXRotationProperty()));
	}

	@Override
	public void enableYRotation() {
		gui.enableYRotation();
		setMouseRotationHandler(RotationHandlerFactory.getInstance()
				.createHorizontalRotationHandler(gui.getYRotationProperty()));
	}

	@Override
	public void disableRotation() {
		gui.disableRotation();
		removeMouseRotationHandler();
	}

	private void removeMouseRotationHandler() {
		if (mouseDragRotationHandler != null)
			gui.removeEventHandler(MouseEvent.MOUSE_DRAGGED,
					mouseDragRotationHandler);
		if (mouseReleaseRotationHandler != null)
			gui.removeEventHandler(MouseEvent.MOUSE_RELEASED,
					mouseReleaseRotationHandler);
	}

	@Override
	public Property<Number> getXRotationProperty() {
		return gui.getXRotationProperty();
	}

	@Override
	public Property<Number> getYRotationProperty() {
		return gui.getYRotationProperty();
	}

	@Override
	public Property<Number> getZRotationProperty() {
		return gui.getZRotationProperty();
	}

	@Override
	public void resetDimensions() {
		gui.resetDimensions();
	}

	@Override
	public void showGrid(boolean b) {
		gui.showGrid(b);
	}

	@Override
	public void showAxis(boolean b) {
		gui.showAxis(b);		
	}
	
}
