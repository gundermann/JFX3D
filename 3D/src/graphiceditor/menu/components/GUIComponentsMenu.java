package graphiceditor.menu.components;

import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.AbstractGUIMenu;

import java.awt.Toolkit;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCameraBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;


public class GUIComponentsMenu extends AbstractGUIMenu{
	 private static GUIComponentsMenu _instance;

	  private final ComponentsMenuController controller;

	  public GUIComponentsMenu( ComponentsMenuController componentsMenuController ) {
	    controller = componentsMenuController;
	    FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "componentsmenu.fxml" ) );
	    fxmlLoader.setController( componentsMenuController );
	    AnchorPane page;
	    try {
	      page = (AnchorPane) fxmlLoader.load();
	      Scene scene = SceneBuilder.create().root( page ).camera( PerspectiveCameraBuilder.create().build() )
	          .depthBuffer( true ).build();
	      setScene( scene );
	      initStyle( StageStyle.UNDECORATED );
	      setY( 70 );
	      show();
	      setX( Toolkit.getDefaultToolkit().getScreenSize().getWidth()-getWidth() );
	    }
	    catch ( IOException e ) {
	      e.printStackTrace();
	    }
	  }

	  public static GUIComponentsMenu getInstance() {
	    if ( _instance == null ) {
	      _instance = new GUIComponentsMenu( new ComponentsMenuController() );
	    }
	    if ( !_instance.isVisible() ) {
	      _instance.setVisible( false );
	    }
	    return _instance;

	  }

	  public void setPaintingArea( PaintingArea paintingArea ) {
	    controller.setPaintingArea( paintingArea );
	  }

	  public void setDisable( boolean disable ) {
	    getScene().getRoot().setDisable( disable );
	  }

	public void updateComponents() {
		controller.updateComponents();
	}


}
