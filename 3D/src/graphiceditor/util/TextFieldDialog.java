package graphiceditor.util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class TextFieldDialog extends AbstractDialog {

	private Setup setup;

	@FXML
	public TextField tf;

	public TextFieldDialog(Setup setup) {
		super();
		this.setup = setup;
	}

	@FXML
	public void ok() {
		setup.setText(tf.getText());
		getStage().close();
	}

	@FXML
	private void cancel() {
		getStage().close();
	}

	@Override
	protected FXMLLoader initLoader() {
		return new FXMLLoader(getClass().getResource("fxml/tfDialog.fxml"));
	}

	public static void showSetup(Setup setup) {
		new TextFieldDialog(setup);
	}
}
