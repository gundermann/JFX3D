package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphiceditor.shapes.Object3D;
import graphicloader.Graphic3DFactory;
import graphicloader.prefs.ShapePreference;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class Graphic3DFactoryTest {

	@Test
	public void factoryTest() {
		List<ShapePreference> mockedPrefs = new ArrayList<ShapePreference>();
		
		mockedPrefs.add(ShapePrefMock.createMock());

		List<Object3D> convertPreferences = Graphic3DFactory
				.convertPreferencesTo3DGraphics(mockedPrefs);

		for (Object3D object : convertPreferences) {
			assertTrue(object.getXPositionProperty().getValue() == 100);
			assertTrue(object.getYPositionProperty().getValue() == 100);
			assertTrue(object.getZPositionProperty().getValue() == 100);
			assertTrue(object.getHeightProperty().getValue() == 100);
			assertTrue(object.getWidthProperty().getValue() == 100);
			assertTrue(object.getXRotationProperty().getValue() == 90);
			assertTrue(object.getYRotationProperty().getValue() == 90);
			assertTrue(object.getZRotationProperty().getValue() == 90);
		}
	}

}