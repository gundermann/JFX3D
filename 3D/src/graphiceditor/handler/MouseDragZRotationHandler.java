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
package graphiceditor.handler;

import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// ---- Importe ---------------------------------------------------------------
public class MouseDragZRotationHandler implements EventHandler<MouseEvent> {

  private final DoubleProperty zRotationProperty;

  public MouseDragZRotationHandler( DoubleProperty zRotationProperty ) {
    this.zRotationProperty = zRotationProperty;
  }

  @Override
  public void handle( MouseEvent event ) {

    zRotationProperty.set( event.getSceneX() );
  }
}
