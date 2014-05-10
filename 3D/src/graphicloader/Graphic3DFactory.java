/*   $HeadURL$
 * ----------------------------------------------------------------------------
 *     (c) by data experts gmbh
 *            Postfach 1130
 *            Woldegker Str. 12
 *            17001 Neubrandenburg
 * ----------------------------------------------------------------------------
 *     Dieses Dokument und die hierin enthaltenen Informationen unterliegen
 *     dem Urheberrecht und duerfen ohne die schriftliche Genehmigung des
 *     Herausgebers weder als ganzes noch in Teilen dupliziert, reproduziert
 *     oder manipuliert werden.
 * ----------------------------------------------------------------------------
 *     $Id$
 * ----------------------------------------------------------------------------
 */
package graphicloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

// ---- Importe ---------------------------------------------------------------
public class Graphic3DFactory {

  public static List<Node> convertPreferenceTo3DGraphic( File file ) {
    List<Node> pixelNodes = new ArrayList<Node>();
    for ( PixelPreference pixelPreference : getPixelPreferencesFromFile( file ) ) {
      Rectangle point = pixelPreference.createPoint();
      pixelNodes.add( point );
    }

    return pixelNodes;
  }
}
