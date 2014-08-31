package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphiceditor.business.Object3D;
import graphiceditor.business.impl.Rectangle3D;
import graphicpersistenshandler.PreferenceFactory;
import graphicpersistenshandler.prefs.IShapePreference;
import graphicpersistenshandler.prefs.impl.RectPreference;

import org.junit.Before;
import org.junit.Test;

public class PreferenceFactoryTest {

	private Object3D object3D;

	@Before
	public void setup() {
		object3D = new Rectangle3D();
		object3D.moveToX(100);
		object3D.moveToY(100);
		object3D.moveToZ(100);
		object3D.changeHeightTo(100);
		object3D.changeWidthTo(100);
		object3D.rotateXTo(90);
		object3D.rotateYTo(90);
		object3D.rotateZTo(90);
	}

	@Test
	public void testPreferencesCreationFromRectangle() {
		IShapePreference preferences = PreferenceFactory.getInstance()
				.createPrefFromObject3D(object3D);
		
		
		assertTrue("Falsche X-Coordiante",
				((RectPreference) preferences).getBeginningX() == 100);
		assertTrue("Falsche Y-Coordiante",
				((RectPreference) preferences).getBeginningY() == 100);
		assertTrue("Falsche Z-Coordiante", ((RectPreference) preferences).getBeginningZ() == 100);
		assertTrue("Falsche Länge", ((RectPreference) preferences).getWidth() == 100);
		assertTrue("Falsche Höhe", ((RectPreference) preferences).getHeight() == 100);
		assertTrue("Falsche X-Rotation", ((RectPreference) preferences).getRotationX() == 90);
		assertTrue("Falsche Y-Rotation", ((RectPreference) preferences).getRotationY() == 90);
		assertTrue("Falsche Z-Rotation", ((RectPreference) preferences).getRotationZ() == 90);
	}
}
