package graphicloader.test;

import org.mockito.Mockito;

import graphiceditor.business.Object3D;
import graphiceditor.business.impl.Rectangle3D;
import graphicpersistenshandler.prefs.IShapePreference;

public class ShapePrefMock {

	public static IShapePreference createMock() {
		IShapePreference pref = Mockito.mock(IShapePreference.class);
		Object3D object = new Rectangle3D();
		object.moveToX(100);
		object.moveToY(100);
		object.moveToZ(100);
		object.changeHeightTo(100);
		object.changeWidthTo(100);
		object.rotateXTo(90);
		object.rotateYTo(90);
		object.rotateZTo(90);
		Mockito.when(pref.createShape()).thenReturn(object);
		return pref;
	}

}
