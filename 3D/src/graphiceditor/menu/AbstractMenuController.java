package graphiceditor.menu;

import java.awt.Button;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Robot;

public abstract class AbstractMenuController {

	protected static final int Y = 1;

	protected static final int X = 0;

	private boolean moveable = false;

	protected double[] mousePosition;

	@FXML
	public Button movingActivator;

	@FXML
	public void changeMoving() {
		moveable = !moveable;
	}


	@FXML
	public void move() {
		if (moveable) {
			Robot robot = Application.GetApplication().createRobot();
			getUI().setX(robot.getMouseX() - 25);
			getUI().setY(robot.getMouseY() - 15);
			robot.mouseMove(Double.valueOf(getUI().getX() + 25).intValue(),
					Double.valueOf(getUI().getY() + 15).intValue());
		}
	}

	abstract protected Stage getUI();
}
