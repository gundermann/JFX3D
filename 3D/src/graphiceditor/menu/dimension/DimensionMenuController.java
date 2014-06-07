package graphiceditor.menu.dimension;

import graphiceditor.gui.DimensionArea;
import graphiceditor.menu.MenuDisabler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.util.converter.NumberStringConverter;

public class DimensionMenuController{

	private DimensionArea dimensionArea;

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
		this.dimensionArea = dimensionArea;
		lbXRotation.textProperty().bindBidirectional(dimensionArea.getXRotationProperty(), new NumberStringConverter());
		lbYRotation.textProperty().bindBidirectional(dimensionArea.getYRotationProperty(), new NumberStringConverter());
		lbZRotation.textProperty().bindBidirectional(dimensionArea.getZRotationProperty(), new NumberStringConverter());;
	}

	@FXML
	public void resetDimensions(){
		dimensionArea.resetDimensions();
	}
	 @FXML
	  public void showAxisOfElement(){
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

}