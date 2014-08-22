package graphiceditor.gui.controller;

import graphiceditor.PaintingAreaFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.components.GUIComponentsMenu;
import graphiceditor.menu.dimension.GUIDimensionMenu;
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
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
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
	private ProgressBar progressBar;
	
	@FXML
	private ProgressIndicator progressIndicator;

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
		final File file = Graphic3DLoader.getInstace().initLoading();
		PaintingAreaFactory.getInstance().load(this, file.getName());
		final List<CommonObject3D> shapesFromLoader = Graphic3DLoader
				.getInstace().loadShapes(file);
		getSelectedPaintingArea().addAll(shapesFromLoader);
	}

	@FXML
	public void save() {
		Graphic3DSaver.getInstance().initSaving(getSelectedPaintingArea());
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

	public void setCurrentProgress(ReadOnlyDoubleProperty progressProperty) {
		progressIndicator.progressProperty().bind(progressProperty);
		progressBar.progressProperty().bind(progressProperty);
	}
}
