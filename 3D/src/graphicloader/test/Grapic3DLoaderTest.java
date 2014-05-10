package graphicloader.test;

import static org.junit.Assert.assertTrue;
import graphicloader.Graphic3DLoader;
import graphicloader.PixelPreference;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Grapic3DLoaderTest {

  private File testFile;

  @Before
  public void setup() {
    testFile = new File( "src/graphicloader/test/test.dxml" );
  }

  @Test
  public void testPreferenceCount() {
    List<PixelPreference> preferencesFromFile = Graphic3DLoader.loadPixelPreferencesFromFile( testFile );
    assertTrue( "Falsche Anzahl gelesen", preferencesFromFile.size() == 1 );
  }

  @Test
  public void testPixelPreferencesFromPixel() {
    List<PixelPreference> preferencesFromFile = Graphic3DLoader.loadPixelPreferencesFromFile( testFile );
    PixelPreference pixelPreference = preferencesFromFile.get( 0 );
    assertTrue( "Falsche X-Coordiante", pixelPreference.getX() == 123 );
    assertTrue( "Falsche Y-Coordiante", pixelPreference.getY() == 321 );
    assertTrue( "Falsche Z-Coordiante", pixelPreference.getZ() == 0 );
    assertTrue( "Falscher Rot-Wert", pixelPreference.getRed() == 255 );
    assertTrue( "Falscher Gruen-Wert", pixelPreference.getGreen() == 255 );
    assertTrue( "Falscher Blau-Wert", pixelPreference.getBlue() == 255 );
  }
}
