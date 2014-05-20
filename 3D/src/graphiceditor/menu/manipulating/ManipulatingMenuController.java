package graphiceditor.menu.manipulating;

import graphiceditor.business.Object3D;
import graphiceditor.gui.PaintingArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ManipulatingMenuController{

	@FXML
	public Label xPosition;
	@FXML
	public Label yPosition;
	@FXML
	public Label zPosition;
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

	public void setActualPainting(Object3D painting) {
		this.painting = painting;
		xPosition.textProperty().bind(painting.getXPositionProperty());
		yPosition.textProperty().bind(painting.getYPositionProperty());
		zPosition.textProperty().bind(painting.getZPositionProperty());
		editHeight.textProperty().bindBidirectional(painting.getHeightProperty(), new MyNumberToStringConverter());
		editWidth.textProperty().bindBidirectional(painting.getWidthProperty(), new MyNumberToStringConverter());
	}

}
