package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphicpersistenshandler.Graphic3DLoader;
import graphicpersistenshandler.prefs.CommonShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;
import graphicpersistenshandler.prefs.impl.RectPreference;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Grapic3DLoaderTest {

  private File testFile;

  private Graphic3DLoader loader;
  @Before
  public void setup() {
    testFile = new File( "test/graphicloader/test/test.dxml" );
    loader = Graphic3DLoader.getInstace();
  }

  @Test
  public void testPreferenceCount() {
    List<CommonShapePreference> preferencesFromFile = loader.loadPreferencesFromFile( testFile );
    assertTrue( "Falsche Anzahl gelesen", preferencesFromFile.size() == 1 );
  }

  @Test
  public void testPixelPreferencesFromPixel() {
    List<CommonShapePreference> preferencesFromFile = loader.loadPreferencesFromFile( testFile );
    RectPreference pixelPreference = (RectPreference) preferencesFromFile.get( 0 );
    assertTrue( "Falsche X-Coordiante", pixelPreference.getBeginningX() == 123 );
    assertTrue( "Falsche Y-Coordiante", pixelPreference.getBeginningY() == 321 );
    assertTrue( "Falsche Z-Coordiante", pixelPreference.getBeginningZ() == 0 );
    assertTrue( "Falsche Länge", pixelPreference.getWidth() == 100);
    assertTrue( "Falsche Höhe", pixelPreference.getHeight() == 100 );
    assertTrue( "Falsche X-Rotation", pixelPreference.getRotationX() == 45 );
    assertTrue( "Falsche Y-Rotation", pixelPreference.getRotationY() == 90 );
    assertTrue( "Falsche Z-Rotation", pixelPreference.getRotationZ() == 2 );
    assertTrue( "Falscher Rot-Wert", pixelPreference.getRed() == 255 );
    assertTrue( "Falscher Gruen-Wert", pixelPreference.getGreen() == 255 );
    assertTrue( "Falscher Blau-Wert", pixelPreference.getBlue() == 255 );
  }
}
