package graphiceditor.menu.manipulation;

import graphiceditor.business.Object3D;
import graphiceditor.util.NumberToStringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ManipulatingMenuController extends
		ComplexManipulatingMenuController {

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

	protected void bindProperties() {
		super.bindProperties();
		editHeight.textProperty().bindBidirectional(
				painting.getHeightProperty(), new NumberToStringConverter());
		editWidth.textProperty().bindBidirectional(painting.getWidthProperty(),
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

	protected void unbindProperties() {
		super.unbindProperties();
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
