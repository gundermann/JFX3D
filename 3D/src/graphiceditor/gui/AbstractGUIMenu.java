package graphiceditor.gui;

import javafx.stage.Stage;

public abstract class AbstractGUIMenu extends Stage {

  private boolean visible = false;

  public boolean isVisible() {
    return visible;
  }

  public void setVisible( boolean visible ) {
    this.visible = visible;
    if ( visible ) {
      this.show();
    }
    else {
      this.hide();
    }
  }

}
