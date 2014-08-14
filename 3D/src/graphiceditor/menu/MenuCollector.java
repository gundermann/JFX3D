package graphiceditor.menu;

import graphiceditor.menu.animation.GUIAnimationManipulationMenu;
import graphiceditor.menu.components.GUIComponentsMenu;
import graphiceditor.menu.dimension.GUIDimensionMenu;
import graphiceditor.menu.painting.GUIPaintingMenu;

import java.util.ArrayList;
import java.util.List;

import preferencemenu.gui.GUIManipulatingMenu;

public class MenuCollector {

	private static MenuCollector _instance;

	private List<AbstractGUIMenu> menus;

	public static MenuCollector getInstance() {
		if (_instance == null) {
			_instance = new MenuCollector();
		}
		return _instance;
	}

	public MenuCollector() {
		setupMenus();
	}

	private void setupMenus() {
		menus = new ArrayList<AbstractGUIMenu>();
		menus.add(GUIDimensionMenu.getInstance());
		menus.add(GUIPaintingMenu.getInstance());
		menus.add(GUIComponentsMenu.getInstance());
		menus.add(GUIManipulatingMenu.getInstance());
		menus.add(GUIAnimationManipulationMenu.getInstance());
	}

	public List<AbstractGUIMenu> getMenus() {
		return menus;
	}
}
