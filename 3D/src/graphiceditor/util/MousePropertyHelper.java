package graphiceditor.util;

import com.sun.glass.ui.Application;

public class MousePropertyHelper {

	public static double getMouseX(){
		return Application.GetApplication().createRobot().getMouseX();
	}
	
	public static double getMouseY(){
		return Application.GetApplication().createRobot().getMouseY();
	}
}
