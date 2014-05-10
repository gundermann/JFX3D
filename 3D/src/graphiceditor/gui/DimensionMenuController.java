package graphiceditor.gui;

import java.util.List;

import javafx.fxml.FXML;

public class DimensionMenuController implements DimensionMenu {

  private final DimensionArea dimensionArea;

  private List<DimensionArea> dimensionAreas;

  private final GUIDimensionMenu gui;

  public DimensionMenuController( DimensionArea dimensionArea ) {
    this.dimensionArea = dimensionArea;

    gui = new GUIDimensionMenu( this );
  }

  @FXML
  public void toggleXRotaion() {
    dimensionArea.enableXRotation();
  }

  @Override
  public DimensionArea getDimensionArea() {
    return dimensionArea;
  }

}
