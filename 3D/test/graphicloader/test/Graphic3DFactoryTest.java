package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;
import graphicpersistenshandler.Graphic3DConverter;
import graphicpersistenshandler.prefs.CommonShapePreference;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Graphic3DFactoryTest {

	@Test
	public void factoryTest() {
		List<CommonShapePreference> mockedPrefs = new ArrayList<CommonShapePreference>();
		
		mockedPrefs.add(ShapePrefMock.createMock());

		List<CommonObject3D> convertPreferences = Graphic3DConverter.getInstance()
				.convertPreferencesTo3DGraphics(mockedPrefs);

		for (CommonObject3D object : convertPreferences) {
			assertTrue(object.getXPositionProperty().getValue() == 100);
			assertTrue(object.getYPositionProperty().getValue() == 100);
			assertTrue(object.getZPositionProperty().getValue() == 100);
			assertTrue(((Object3D) object).getHeightProperty().getValue() == 100);
			assertTrue(((Object3D) object).getWidthProperty().getValue() == 100);
			assertTrue(object.getXRotationProperty().getValue() == 90);
			assertTrue(object.getYRotationProperty().getValue() == 90);
			assertTrue(object.getZRotationProperty().getValue() == 90);
			assertTrue(((Object3D) object).getColor().getR().getValue() == 0);
			assertTrue(((Object3D) object).getColor().getG().getValue() == 0);
			assertTrue(((Object3D) object).getColor().getB().getValue() == 0);
		}
	}

}
