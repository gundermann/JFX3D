package graphiceditor.menu;

import java.awt.Toolkit;

import javax.tools.Tool;

import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MenuBar extends AnchorPane {

	private static MenuBar _instance;

	public static MenuBar getInstance() {
		if (_instance == null) {
			_instance = new MenuBar();
		}
		return _instance;
	}
	
	public MenuBar(){
		setWidth(250);
		initAllMenus();
	}

	private void initAllMenus() {
		VBox vb = new VBox();
		ScrollPane sb = new ScrollPane();
		sb.setHbarPolicy(ScrollBarPolicy.NEVER);
		sb.setPrefWidth(280);
		sb.setPrefHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-70);
		sb.setContent(vb);
		for(AbstractGUIMenu menu :  MenuCollector.getInstance().getMenus()){
			TitledPane tp = new TitledPane(menu.getTitle(), menu);
			tp.setCollapsible(true);
			vb.getChildren().add(tp);
		}
		
		getChildren().add(sb);
	}
}
