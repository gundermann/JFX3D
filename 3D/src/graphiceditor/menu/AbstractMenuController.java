package graphiceditor.menu;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Robot;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public abstract class AbstractMenuController implements Initializable {

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

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		// getMovingActivationNode().setOnDragEntered(new
		// EventHandler<DragEvent>() {
		// @Override
		// public void handle(DragEvent event) {
		// moveable = true;
		// mousePosition[X] = event.getScreenX();
		// mousePosition[Y] = event.getScreenY();
		// }
		// });
		//
		// getMainPain().setOnDragExited(new EventHandler<DragEvent>() {
		//
		// @Override
		// public void handle(DragEvent arg0) {
		// moveable = false;
		// }
		// });

		// getMovingActivationNode().setOnDragOver(new EventHandler<DragEvent>()
		// {
		//
		// @Override
		// public void handle(DragEvent event) {
		// // if(moveable){
		// getUI().setX(event.getScreenX()-mousePosition[X]);
		// mousePosition[X] = event.getScreenX();
		// // }
		// }
		// });
	}

	abstract protected Stage getUI();
}
