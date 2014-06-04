package graphiceditor.util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class TextDialog extends AbstractDialog{

	@FXML
	public void ok(){
		getStage().close();
	}

	@Override
	protected FXMLLoader initLoader() {
		return new FXMLLoader( getClass().getResource( "fxml/textDialog.fxml" ) );
	}

}
