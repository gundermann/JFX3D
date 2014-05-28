package graphiceditor.menu.manipulating;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.Object3D;
import graphiceditor.util.NumberToStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ManipulatingMenuController{

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
	private ListView<String> lvComponents;

	private PaintingArea actualPaintingArea;
	private Object3D painting;

	public void setPaintingArea(PaintingArea paintingArea) {
		this.actualPaintingArea = paintingArea;
		updateComponents();
	}

	public void updateComponents() {
		lvComponents.getItems().setAll(
				this.actualPaintingArea.getAllGraphicObjects());
	}


	@FXML
	public void componentSelected() {
		actualPaintingArea.setActualPaintingById(lvComponents
				.getSelectionModel().getSelectedIndex());
	}
	
	@FXML
	public void removeHeight() {
		painting.changeHeight(-1);
	}

	@FXML
	public void addHeight() {
		painting.changeHeight(1);
	}

	@FXML
	public void removeWidth() {
		painting.changeWidth(-1);
	}

	@FXML
	public void addWidth() {
		painting.changeWidth(1);
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
		xPosition.textProperty().bindBidirectional(painting.getXPositionProperty(), new NumberToStringConverter());
		yPosition.textProperty().bindBidirectional(painting.getYPositionProperty(), new NumberToStringConverter());
		zPosition.textProperty().bindBidirectional(painting.getZPositionProperty(), new NumberToStringConverter());
		xRotation.textProperty().bindBidirectional(painting.getXRotationProperty(), new NumberToStringConverter());
		yRotation.textProperty().bindBidirectional(painting.getYRotationProperty(), new NumberToStringConverter());
		zRotation.textProperty().bindBidirectional(painting.getZRotationProperty(), new NumberToStringConverter());
		editHeight.textProperty().bindBidirectional(painting.getHeightProperty(), new NumberToStringConverter());
		editWidth.textProperty().bindBidirectional(painting.getWidthProperty(), new NumberToStringConverter());
	}

}
