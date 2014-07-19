package graphiceditor.gui.controller;

import graphiceditor.PaintingAreaFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.components.GUIComponentsMenu;
import graphiceditor.menu.dimension.GUIDimensionMenu;
import graphiceditor.menu.manipulation.GUIAnimationManipulationMenu;
import graphiceditor.menu.manipulation.GUIManipulatingMenu;
import graphiceditor.menu.painting.GUIPaintingMenu;
import graphiceditor.util.ComplexGraphicInserter;
import graphicpersistenshandler.Graphic3DLoader;
import graphicpersistenshandler.Graphic3DSaver;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;

public class MainController implements Initializable {

	@FXML
	private ToggleButton btDimensionMenu;

	@FXML
	private ToggleButton btPaintingMenu;

	@FXML
	private ChoiceBox<String> paintingAreaSelection;

	private final List<PaintingArea> paintingAreas = new ArrayList<PaintingArea>();

	@FXML
	public ToggleButton btManipulatingMenu;

	@FXML
	private ToggleButton btComponentsMenu;
	
	@FXML
	private ToggleButton btAniamtionMenu;

	@FXML
	public void initNewObject() {
		PaintingAreaFactory.getInstance().initCreation(this);
	}

	public void addArea(PaintingArea paintingArea) {
		paintingAreas.add(paintingArea);
		// FIXME use binding
		paintingAreaSelection.getItems().add(paintingArea.toString());
		paintingAreaSelection.getSelectionModel().selectLast();
		paintingAreaSelection.setDisable(false);
		btDimensionMenu.setDisable(false);
		btPaintingMenu.setDisable(false);
		btManipulatingMenu.setDisable(false);
		btComponentsMenu.setDisable(false);
	}

	public PaintingArea getSelectedPaintingArea() {
		int selectedIndex = paintingAreaSelection.getSelectionModel()
				.getSelectedIndex();
		return paintingAreas.get(selectedIndex);
	}

	public void selectPaintingArea() {
		GUIDimensionMenu.getInstance().setDimensionArea(
				getSelectedPaintingArea());
		GUIPaintingMenu.getInstance()
				.setPaintingArea(getSelectedPaintingArea());
		GUIComponentsMenu.getInstance().setPaintingArea(
				getSelectedPaintingArea());
		getSelectedPaintingArea().getUI().toFront();
	}

	@FXML
	public void initInsertFromFile() {
		ComplexGraphicInserter.getInstance().insertFromFile(
				getSelectedPaintingArea());
	}

	@FXML
	public void load() {
		File file = Graphic3DLoader.getInstace().initLoading();
		PaintingAreaFactory.getInstance().load(this, file.getName());
		List<CommonObject3D> shapesFromLoader = Graphic3DLoader.getInstace()
				.getShapesFromLoader(file);
		getSelectedPaintingArea().addAll(shapesFromLoader);
	}

	@FXML
	public void save() {
		Graphic3DSaver.getInstance().initSaving(getSelectedPaintingArea());
	}

	@FXML
	public void toggleDimensionMenu() {
		if (!btDimensionMenu.isSelected()) {
			GUIDimensionMenu.getInstance().setVisible(false);
		} else {
			GUIDimensionMenu.getInstance().setDimensionArea(
					getSelectedPaintingArea());
			GUIDimensionMenu.getInstance().setVisible(true);
		}
	}

	@FXML
	public void toggleManipulatingMenu() {
		if (!btManipulatingMenu.isSelected()) {
			GUIManipulatingMenu.getInstance().setVisible(false);
		} else {
			GUIManipulatingMenu.getInstance().setVisible(true);
		}
	}

	@FXML
	public void togglePaintingMenu() {
		if (!btPaintingMenu.isSelected()) {
			GUIPaintingMenu.getInstance().setVisible(false);
		} else {
			GUIPaintingMenu.getInstance().setPaintingArea(
					getSelectedPaintingArea());
			GUIPaintingMenu.getInstance().setVisible(true);
		}
	}

	@FXML
	public void toggleComponentsMenu() {
		if (!btComponentsMenu.isSelected()) {
			GUIComponentsMenu.getInstance().setVisible(false);
		} else {
			GUIComponentsMenu.getInstance().setPaintingArea(
					getSelectedPaintingArea());
			GUIComponentsMenu.getInstance().setVisible(true);
		}
	}
	
	@FXML
	public void close() {
		Platform.exit();
	}

	@Override
	public void initialize(URL paramURL, ResourceBundle paramResourceBundle) {
		// FIXME
		paintingAreaSelection.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> paramObservableValue,
							String paramT1, String paramT2) {
						selectPaintingArea();
					}
				});
	}

	public boolean doesNameExist(String name) {
		if (paintingAreaSelection.getItems().contains(name)) {
			return true;
		} else {
			return false;
		}
	}
}
