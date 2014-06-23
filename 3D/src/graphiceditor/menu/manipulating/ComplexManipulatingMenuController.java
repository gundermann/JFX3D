package graphiceditor.menu.manipulating;

import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.Object3D;
import graphiceditor.util.NumberToStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ComplexManipulatingMenuController {

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

	protected CommonObject3D painting;

	@FXML
	public void componentSelected() {
		if (painting != null) {
			unbindProperties();
		}
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
		bindProperties();
	}

	protected void bindProperties() {
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
	}

	protected void unbindProperties() {
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
	}

}
