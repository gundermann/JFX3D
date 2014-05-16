package graphiceditor.gui.controller;

import graphiceditor.RotationHandlerFactory;
import graphiceditor.business.Object3D;
import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.handler.AbstractMouseDragRotationHandler;
import javafx.beans.value.ObservableValue;
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
	public void add(Object3D shape) {
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
	public ObservableValue<? extends String> getXRotationTextProperty() {
		return gui.getXRotationProperty().asString();
	}

	@Override
	public ObservableValue<? extends String> getYRotationTextProperty() {
		return gui.getYRotationProperty().asString();
	}

	@Override
	public ObservableValue<? extends String> getZRotationTextProperty() {
		return gui.getZRotationProperty().asString();
	}

	@Override
	public void resetDimensions() {
		gui.resetDimensions();
	}

	@Override
	public void showAxis() {
		getUI().showAxis();
	}
}
