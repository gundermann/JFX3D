package graphicpersistenshandler;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.Object3D;
import graphicpersistenshandler.prefs.RectPreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Graphic3DSaver extends AbstractGraphic3DPersister {

	private static Graphic3DSaver _instance;

	public static Graphic3DSaver getInstance() {
		if (_instance == null) {
			_instance = new Graphic3DSaver();
		}
		return _instance;
	}

	public void savePreferencesToFile(List<ShapePreference> prefs, File file) {
		Document doc = buildDoc(prefs);

		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(new DOMSource(doc), new StreamResult(file));

		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
	}

	private Document buildDoc(List<ShapePreference> pixelPreferences) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();

			Element root = doc.createElement(ROOT);
			doc.appendChild(root);
			for (ShapePreference pref : pixelPreferences) {
				Element element = buildElement(pref, doc);
				root.appendChild(element);
			}
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Element buildElement(ShapePreference pref, Document doc) {
		Element element = doc.createElement("rect");
		element.setAttribute(X,
				String.valueOf(((RectPreference) pref).getBeginningX()));
		element.setAttribute(Y,
				String.valueOf(((RectPreference) pref).getBeginningY()));
		element.setAttribute(Z,
				String.valueOf(((RectPreference) pref).getBeginningZ()));
		element.setAttribute(WIDTH,
				String.valueOf(((RectPreference) pref).getWidth()));
		element.setAttribute(HEIGHT,
				String.valueOf(((RectPreference) pref).getHeight()));
		element.setAttribute(XR,
				String.valueOf(((RectPreference) pref).getRotationX()));
		element.setAttribute(YR,
				String.valueOf(((RectPreference) pref).getRotationY()));
		element.setAttribute(ZR,
				String.valueOf(((RectPreference) pref).getRotationZ()));
		element.setAttribute(COLOR,Rgb2hex(((RectPreference) pref)));
		return element;
	}

	public String Rgb2hex(RectPreference pref) {
		StringBuilder c = new StringBuilder("#");
		if(pref.getRed() <= 16)
			c.append(0);
		c.append(Integer.toHexString(pref.getRed()));
		if(pref.getGreen() <= 16)
			c.append(0);
		c.append(Integer.toHexString(pref.getGreen()));
		if(pref.getBlue() <= 16)
			c.append(0);
		c.append(Integer.toHexString(pref.getBlue()));
		return c.toString();
	}
	public void initSaving(PaintingArea paintingArea) {
		FileChooser fc = new FileChooser();
		List<String> extentions = new ArrayList<String>();
		extentions.add("dxml");
		fc.getExtensionFilters().add(
				new ExtensionFilter("DimesionXML", extentions));
		File file = fc.showSaveDialog(new Stage());
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		savePaintingArea(paintingArea, file);
	}

	public void savePaintingArea(PaintingArea paintingArea, File file) {
		List<ShapePreference> shapePreferences = new ArrayList<ShapePreference>();
		for (Object3D graphicObject : paintingArea.getAllGraphicObjects()) {
			ShapePreference pref = PreferenceFactory
					.createPrefFromObject3D(graphicObject);
			shapePreferences.add(pref);
		}
		savePreferencesToFile(shapePreferences, file);
	}
}
