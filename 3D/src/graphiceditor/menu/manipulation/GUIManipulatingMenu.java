package graphiceditor.menu.manipulation;

import graphiceditor.business.CommonObject3D;
import graphiceditor.menu.AbstractGUIMenu;
import graphiceditor.menu.animation.GUIAnimationManipulationMenu;
import graphiceditor.util.AdditionButton;
import graphiceditor.util.NumberToStringConverter;
import graphiceditor.util.PropertyHelper;
import graphiceditor.util.SubtractionButton;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GUIManipulatingMenu extends AbstractGUIMenu {

	private static GUIManipulatingMenu _instance;

	public static GUIManipulatingMenu getInstance() {
		if (_instance == null) {
			_instance = new GUIManipulatingMenu();
		}
		if (!_instance.isVisible()) {
			_instance.setVisible(false);
		}
		return _instance;
	}

	protected Scene scene;
	private CommonObject3D actualPainting;

	public GUIManipulatingMenu() {
		setupScene();
		initPropertiesFromActualObject3D();
	}

	public void setupScene() {
		setWidth(150);
	}

	public void setActualPainting(CommonObject3D painting) {
		this.actualPainting = painting;
		initPropertiesFromActualObject3D();
		GUIAnimationManipulationMenu.getInstance().setActualPainting(painting);
	}

	private void initPropertiesFromActualObject3D() {
		GridPane grid = new GridPane();
		int i = 0;
		if (actualPainting != null) {
			for (String name : PropertyHelper.getInstance().getPropertyNames(
					actualPainting)) {
				Label label = new Label(name);
				grid.add(label, 0, i);
				i++;
				grid.addRow(i, initPropertyChangeingUI(name));
				i++;
			}
		}
		updateScene(grid);
		resize(i * 26);
	}

	private void resize(int height) {
		setHeight(height);
	}

	private Node initPropertyChangeingUI(String name) {
		DoubleProperty property = PropertyHelper.getInstance().getProperty(
				name, actualPainting);
		GridPane grid = new GridPane();
		TextField tf = new TextField();
		tf.textProperty().bindBidirectional(property,
				new NumberToStringConverter());
		SubtractionButton btMinus = new SubtractionButton(name, actualPainting);
		AdditionButton btPlus = new AdditionButton(name, actualPainting);
		grid.add(btMinus, 0, 0);
		grid.add(tf, 1, 0);
		grid.add(btPlus, 2, 0);
		return grid;
	}

	public void updateScene(GridPane page) {
		getChildren().clear();
		getChildren().add(page);
	}

	@Override
	public String getTitle() {
		return "Manipulating";
	}

}
