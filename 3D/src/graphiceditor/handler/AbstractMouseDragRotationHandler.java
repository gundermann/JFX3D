package graphiceditor.handler;

import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class AbstractMouseDragRotationHandler implements
		EventHandler<MouseEvent> {

	private final DoubleProperty rootAngle;

	private final MouseMovement mouseMovement;

	private double previousMousePosition = -1;

	public AbstractMouseDragRotationHandler(DoubleProperty rootAngle,
			MouseMovement mouseMovement) {
		this.rootAngle = rootAngle;
		this.mouseMovement = mouseMovement;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {

			if (mouseMovement == MouseMovement.Horizontal) {
				rotate(mouseEvent.getSceneX());
			} else if (mouseMovement == MouseMovement.Vertical) {
				rotate(mouseEvent.getSceneY());
			}
		} else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
			previousMousePosition = -1;
		}
	}

	private void rotate(double sceneCoordinate) {
		if (previousMousePosition >= 0) {
			rootAngle.set(rootAngle.get() + sceneCoordinate
					- previousMousePosition);
		}
		previousMousePosition = sceneCoordinate;
	}
}
