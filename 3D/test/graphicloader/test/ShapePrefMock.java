package graphicloader.test;

import org.mockito.Mockito;

import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.Rectangle3D;
import graphicpersistenshandler.prefs.ShapePreference;

public class ShapePrefMock {

	public static ShapePreference createMock() {
		ShapePreference pref = Mockito.mock(ShapePreference.class);
		Object3D object = new Rectangle3D();
		object.moveX(100);
		object.moveY(100);
		object.moveZ(100);
		object.changeHeightTo(100);
		object.changeWidthTo(100);
		object.rotateX(90);
		object.rotateY(90);
		object.rotateZ(90);
		Mockito.when(pref.createShape()).thenReturn(object);
		return pref;
	}

}
