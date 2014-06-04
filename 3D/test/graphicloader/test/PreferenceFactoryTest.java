package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.Rectangle3D;
import graphicloader.PreferenceFactory;
import graphicloader.prefs.RectPreference;
import graphicloader.prefs.ShapePreference;

import org.junit.Before;
import org.junit.Test;

public class PreferenceFactoryTest {

	private Object3D object3D;

	@Before
	public void setup() {
		object3D = new Rectangle3D();
		object3D.setupX(100);
		object3D.setupY(100);
		object3D.moveZ(100);
		object3D.changeHeight(100);
		object3D.changeWidth(100);
		object3D.rotateX(90);
		object3D.rotateY(90);
		object3D.rotateZ(90);
	}

	@Test
	public void testPreferencesCreationFromRectangle() {
		ShapePreference preferences = PreferenceFactory
				.createPrefFromObject3D(object3D);
		
		assertTrue("Falsche X-Coordiante",
				((RectPreference) preferences).getBeginningX() == 100);
		assertTrue("Falsche Y-Coordiante",
				((RectPreference) preferences).getBeginningY() == 100);
		assertTrue("Falsche Z-Coordiante", ((RectPreference) preferences).getBeginningZ() == 100);
		assertTrue("Falsche L�nge", ((RectPreference) preferences).getWidth() == 100);
		assertTrue("Falsche H�he", ((RectPreference) preferences).getHeight() == 100);
		assertTrue("Falsche X-Rotation", ((RectPreference) preferences).getRotationX() == 90);
		assertTrue("Falsche Y-Rotation", ((RectPreference) preferences).getRotationY() == 90);
		assertTrue("Falsche Z-Rotation", ((RectPreference) preferences).getRotationZ() == 90);
	}
}