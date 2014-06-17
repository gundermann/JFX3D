package graphiceditor.menu.manipulating;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;
import graphiceditor.util.NumberToStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
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
	private ListView<String> lvComponents;

	private PaintingArea actualPaintingArea;
	private CommonObject3D painting;

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
		((Object3D) painting).changeHeightTo(((Object3D) painting)
				.getHeightProperty().get() - 1);
	}

	@FXML
	public void addHeight() {
		((Object3D) painting).changeHeightTo(((Object3D) painting)
				.getHeightProperty().get() + 1);
	}

	@FXML
	public void removeWidth() {
		((Object3D) painting).changeWidthTo(((Object3D) painting)
				.getWidthProperty().get() - 1);
	}

	@FXML
	public void addWidth() {
		((Object3D) painting).changeWidthTo(((Object3D) painting)
				.getWidthProperty().get() + 1);
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

	public void setActualPainting(CommonObject3D painting) {
		this.painting = painting;
		setEditableProperties();
		bindProperties();
	}

	private void setEditableProperties() {
		boolean isObject3D = (painting instanceof Object3D);
		editHeight.setDisable(!isObject3D);
		editWidth.setDisable(!isObject3D);
		red.setDisable(!isObject3D);
		green.setDisable(!isObject3D);
		blue.setDisable(!isObject3D);
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

		if (painting instanceof Object3D) {
			editHeight.textProperty().bindBidirectional(
					((Object3D) painting).getHeightProperty(),
					new NumberToStringConverter());
			editWidth.textProperty().bindBidirectional(
					((Object3D) painting).getWidthProperty(),
					new NumberToStringConverter());
			red.textProperty().bindBidirectional(
					((Object3D) painting).getColor().getR(),
					new NumberToStringConverter());
			green.textProperty().bindBidirectional(
					((Object3D) painting).getColor().getG(),
					new NumberToStringConverter());
			blue.textProperty().bindBidirectional(
					((Object3D) painting).getColor().getB(),
					new NumberToStringConverter());
		}
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
		if (painting instanceof Object3D) {
			editHeight.textProperty().unbindBidirectional(
					((Object3D) painting).getHeightProperty());
			editWidth.textProperty().unbindBidirectional(
					((Object3D) painting).getWidthProperty());
			red.textProperty().unbindBidirectional(
					((Object3D) painting).getColor().getR());
			green.textProperty().unbindBidirectional(
					((Object3D) painting).getColor().getG());
			blue.textProperty().unbindBidirectional(
					((Object3D) painting).getColor().getB());
		}
	}

}
