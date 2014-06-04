package graphiceditor.util;

import graphiceditor.PaintingAreaFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class TextFieldDialog extends AbstractDialog{

	private PaintingAreaFactory paintingAreaFactory;
	
	@FXML
	public TextField tf;

	public TextFieldDialog(PaintingAreaFactory paintingAreaFactory) {
		super();
		this.paintingAreaFactory = paintingAreaFactory;
	}

	@FXML
	public void ok(){
		if(paintingAreaFactory.createPaintingArea(tf.getText())){
			getStage().close();
		}
		else{
			new TextDialog();
		}
	}

	@FXML
	private void cancel() {
		getStage().close();
	}

	@Override
	protected FXMLLoader initLoader() {
		return new FXMLLoader( getClass().getResource( "fxml/tfDialog.fxml" ) );
	}
}
