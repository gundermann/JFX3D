package graphiceditor.menu.dimension;

import java.net.URL;
import java.util.ResourceBundle;

import graphiceditor.gui.DimensionArea;
import graphiceditor.menu.MenuDisabler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.util.converter.NumberStringConverter;

public class DimensionMenuController implements Initializable {

	private DimensionArea dimensionArea;

	@FXML
	private Slider slXRotation;

	@FXML
	private Slider slYRotation;

	@FXML
	private Slider slZRotation;

	@FXML
	private ToggleButton btXRotation;

	@FXML
	private ToggleButton btYRotation;

	@FXML
	private ToggleButton btZRotation;

	@FXML
	private Label lbXRotation;

	@FXML
	private Label lbYRotation;

	@FXML
	private Label lbZRotation;

	public void setDimensionArea(DimensionArea dimensionArea) {
		if (this.dimensionArea != null)
			resetSliders();
		this.dimensionArea = dimensionArea;
		updateSliders();
	}

	private void updateSliders() {
		slXRotation.valueProperty().setValue(
				dimensionArea.getXRotationProperty().getValue());
		slYRotation.valueProperty().setValue(
				dimensionArea.getYRotationProperty().getValue());
		slZRotation.valueProperty().setValue(
				dimensionArea.getZRotationProperty().getValue());
		slXRotation.valueProperty().bindBidirectional(
				dimensionArea.getXRotationProperty());
		slYRotation.valueProperty().bindBidirectional(
				dimensionArea.getYRotationProperty());
		slZRotation.valueProperty().bindBidirectional(
				dimensionArea.getZRotationProperty());
	}

	private void resetSliders() {
		slXRotation.valueProperty().unbindBidirectional(
				dimensionArea.getXRotationProperty());
		slYRotation.valueProperty().unbindBidirectional(
				dimensionArea.getYRotationProperty());
		slZRotation.valueProperty().unbindBidirectional(
				dimensionArea.getZRotationProperty());
		slXRotation.valueProperty().set(0);
		slYRotation.valueProperty().set(0);
		slZRotation.valueProperty().set(0);
	}

	@FXML
	public void resetDimensions() {
		dimensionArea.resetDimensions();
	}

	@FXML
	public void showAxisOfElement() {
		dimensionArea.showAxis();
	}

	@FXML
	public void toggleXRotation() {
		if (!btXRotation.isSelected()) {
			dimensionArea.disableRotation();
			MenuDisabler.setDisableForRotation(false);
			enableRotationButtons();
		} else {
			dimensionArea.enableXRotation();
			MenuDisabler.setDisableForRotation(true);
			btYRotation.setDisable(true);
			btZRotation.setDisable(true);
		}
	}

	private void enableRotationButtons() {
		btXRotation.setDisable(false);
		btYRotation.setDisable(false);
		btZRotation.setDisable(false);
	}

	@FXML
	public void toggleYRotation() {
		if (!btYRotation.isSelected()) {
			dimensionArea.disableRotation();
			MenuDisabler.setDisableForRotation(false);
			enableRotationButtons();
		} else {
			dimensionArea.enableYRotation();
			MenuDisabler.setDisableForRotation(true);
			btXRotation.setDisable(true);
			btZRotation.setDisable(true);
		}
	}

	@FXML
	public void toggleZRotation() {
		if (!btZRotation.isSelected()) {
			dimensionArea.disableRotation();
			MenuDisabler.setDisableForRotation(false);
			enableRotationButtons();
		} else {
			dimensionArea.enableZRotation();
			MenuDisabler.setDisableForRotation(true);
			btYRotation.setDisable(true);
			btXRotation.setDisable(true);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbXRotation.textProperty().bindBidirectional(
				slXRotation.valueProperty(), new NumberStringConverter());
		lbYRotation.textProperty().bindBidirectional(
				slYRotation.valueProperty(), new NumberStringConverter());
		lbZRotation.textProperty().bindBidirectional(
				slZRotation.valueProperty(), new NumberStringConverter());
	}

}