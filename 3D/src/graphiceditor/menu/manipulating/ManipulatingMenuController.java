package graphiceditor.menu.manipulating;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.Object3D;
import graphiceditor.util.NumberToStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class ManipulatingMenuController {

	@FXML
	public TextField xPosition;
	@FXML
	public TextField yPosition;
	@FXML
	public TextField zPosition;
	@FXML
	public TextField xRotation;
	@FXML
	public TextField yRotation;
	@FXML
	public TextField zRotation;
	@FXML
	public TextField editHeight;
	@FXML
	public TextField editWidth;
	@FXML
	public TextField red;
	@FXML
	public TextField green;
	@FXML
	public TextField blue;
	@FXML
	public Slider redSlider;
	@FXML
	public Slider greenSlider;
	@FXML
	public Slider blueSlider;
	@FXML
	private ListView<String> lvComponents;

	private PaintingArea actualPaintingArea;
	private Object3D painting;

	public void setPaintingArea(PaintingArea paintingArea) {
		this.actualPaintingArea = paintingArea;
		updateComponents();
	}

	public void updateComponents() {
		lvComponents.getItems().setAll(
				this.actualPaintingArea.getAllGraphicObjectsAsString());
	}

	@FXML
	public void componentSelected() {
		if (painting != null) {
			unbindProperties();
		}
		actualPaintingArea.setActualPaintingById(lvComponents
				.getSelectionModel().getSelectedIndex());
	}

	@FXML
	public void removeHeight() {
		painting.changeHeightTo(painting.getHeightProperty().get() - 1);
	}

	@FXML
	public void addHeight() {
		painting.changeHeightTo(painting.getHeightProperty().get() + 1);
	}

	@FXML
	public void removeWidth() {
		painting.changeWidthTo(painting.getWidthProperty().get() - 1);
	}

	@FXML
	public void addWidth() {
		painting.changeWidthTo(painting.getWidthProperty().get() + 1);
	}

	@FXML
	public void removeX() {
		painting.moveX(-1);
	}

	@FXML
	public void removeY() {
		painting.moveY(-1);
	}

	@FXML
	public void removeZ() {
		painting.moveZ(-1);
	}

	@FXML
	public void addX() {
		painting.moveX(1);
	}

	@FXML
	public void addY() {
		painting.moveY(1);
	}

	@FXML
	public void addZ() {
		painting.moveZ(1);
	}

	@FXML
	public void removeXRotation() {
		painting.rotateX(-1);
	}

	@FXML
	public void removeYRotation() {
		painting.rotateY(-1);
	}

	@FXML
	public void removeZRotation() {
		painting.rotateZ(-1);
	}

	@FXML
	public void addXRotation() {
		painting.rotateX(1);
	}

	@FXML
	public void addYRotation() {
		painting.rotateY(1);
	}

	@FXML
	public void addZRotation() {
		painting.rotateZ(1);
	}

	public void setActualPainting(Object3D painting) {
		this.painting = painting;
		bindProperties();
	}

	private void bindProperties() {
		xPosition.textProperty().bindBidirectional(
				painting.getXPositionProperty(), new NumberToStringConverter());
		yPosition.textProperty().bindBidirectional(
				painting.getYPositionProperty(), new NumberToStringConverter());
		zPosition.textProperty().bindBidirectional(
				painting.getZPositionProperty(), new NumberToStringConverter());
		xRotation.textProperty().bindBidirectional(
				painting.getXRotationProperty(), new NumberToStringConverter());
		yRotation.textProperty().bindBidirectional(
				painting.getYRotationProperty(), new NumberToStringConverter());
		zRotation.textProperty().bindBidirectional(
				painting.getZRotationProperty(), new NumberToStringConverter());
		editHeight.textProperty().bindBidirectional(
				painting.getHeightProperty(), new NumberToStringConverter());
		editWidth.textProperty().bindBidirectional(painting.getWidthProperty(),
				new NumberToStringConverter());
		red.textProperty().bindBidirectional(painting.getColor().getR(),
				new NumberToStringConverter());
		green.textProperty().bindBidirectional(painting.getColor().getG(),
				new NumberToStringConverter());
		blue.textProperty().bindBidirectional(painting.getColor().getB(),
				new NumberToStringConverter());
	}

	private void unbindProperties() {
		xPosition.textProperty().unbindBidirectional(
				painting.getXPositionProperty());
		yPosition.textProperty().unbindBidirectional(
				painting.getYPositionProperty());
		zPosition.textProperty().unbindBidirectional(
				painting.getZPositionProperty());
		xRotation.textProperty().unbindBidirectional(
				painting.getXRotationProperty());
		yRotation.textProperty().unbindBidirectional(
				painting.getYRotationProperty());
		zRotation.textProperty().unbindBidirectional(
				painting.getZRotationProperty());
		editHeight.textProperty().unbindBidirectional(
				painting.getHeightProperty());
		editWidth.textProperty().unbindBidirectional(
				painting.getWidthProperty());
		red.textProperty().unbindBidirectional(painting.getColor().getR());
		green.textProperty().unbindBidirectional(painting.getColor().getG());
		blue.textProperty().unbindBidirectional(painting.getColor().getB());
	}

}
