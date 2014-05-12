package graphiceditor.gui.controller;

import graphiceditor.RotationHandlerFactory;
import graphiceditor.gui.DimensionArea;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.handler.AbstractMouseDragRotationHandler;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DimensionAreaController implements DimensionArea {

	private final GUIDimensionArea gui;

	private EventHandler<MouseEvent> mouseDragRotationHandler;

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
	public void add(Node shape) {
		gui.add(shape);
	}

	@Override
	public void enableZRotation() {
		setMouseDragRotationHandler(RotationHandlerFactory.getInstance()
				.createHorizontalRotationHandler(gui.getZRotationProperty()));
	}

	private void setMouseDragRotationHandler(
			AbstractMouseDragRotationHandler mouseDragRotationHandler) {
		removeMouseDragRotationHandler();
		this.mouseDragRotationHandler = mouseDragRotationHandler;
		gui.addEventHandler(MouseEvent.MOUSE_DRAGGED,
				this.mouseDragRotationHandler);
	}

	@Override
	public void setMainPane(AnchorPane mainPane) {
		gui.setMainPane(mainPane);
	}

	@Override
	public void enableXRotation() {
		setMouseDragRotationHandler(RotationHandlerFactory.getInstance()
				.createVerticalRotationHandler(gui.getXRotationProperty()));
	}

	@Override
	public void enableYRotation() {
		setMouseDragRotationHandler(RotationHandlerFactory.getInstance()
				.createHorizontalRotationHandler(gui.getYRotationProperty()));
	}

	@Override
	public void disableRotation() {
		removeMouseDragRotationHandler();
	}

	private void removeMouseDragRotationHandler() {
		if (mouseDragRotationHandler != null)
			gui.removeEventHandler(MouseEvent.MOUSE_DRAGGED,
					mouseDragRotationHandler);
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


}
