package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphicloader.Graphic3DLoader;
import graphicloader.prefs.RectPreference;
import graphicloader.prefs.ShapePreference;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Grapic3DLoaderTest {

  private File testFile;

  @Before
  public void setup() {
    testFile = new File( "test/graphicloader/test/test.dxml" );
  }

  @Test
  public void testPreferenceCount() {
    List<ShapePreference> preferencesFromFile = Graphic3DLoader.loadPreferencesFromFile( testFile );
    assertTrue( "Falsche Anzahl gelesen", preferencesFromFile.size() == 1 );
  }

  @Test
  public void testPixelPreferencesFromPixel() {
    List<ShapePreference> preferencesFromFile = Graphic3DLoader.loadPreferencesFromFile( testFile );
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
