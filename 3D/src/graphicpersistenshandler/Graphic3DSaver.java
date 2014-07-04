package graphicpersistenshandler;

import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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

	private static final String NAME = "name";
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
				Element element = buildElement( pref, doc);
				
				root.appendChild(element);
			}
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Element buildElement(ShapePreference pref, Document doc) {
		Element element;
		if (pref instanceof ComplexShapePreference)
			element = buildComplexElement(
					(ComplexShapePreference) pref, doc);
		else
			element = buildSingleElement((ShapePreference) pref, doc);
		
		return element;
	}

	private Element buildComplexElement(ComplexShapePreference pref,
			Document doc) {
		Element element = buildSingleElement(pref, doc);
		for (ShapePreference singlePref : pref.getGraphicPrefs()) {
			Element singleElement = buildElement(singlePref, doc);
			element.appendChild(singleElement);
		}
		return element;
	}

	private Element buildSingleElement(ShapePreference pref, Document doc) {
		Element element = doc.createElement(pref.getPrefType());
		for (String attr : pref.getPreferences().keySet()) {
			element.setAttribute(attr, pref.getPreferences().get(attr));

		}
		// element.setAttribute(X,
		// String.valueOf(((RectPreference) pref).getBeginningX()));
		// element.setAttribute(Y,
		// String.valueOf(((RectPreference) pref).getBeginningY()));
		// element.setAttribute(Z,
		// String.valueOf(((RectPreference) pref).getBeginningZ()));
		// element.setAttribute(WIDTH,
		// String.valueOf(((RectPreference) pref).getWidth()));
		// element.setAttribute(HEIGHT,
		// String.valueOf(((RectPreference) pref).getHeight()));
		// element.setAttribute(XR,
		// String.valueOf(((RectPreference) pref).getRotationX()));
		// element.setAttribute(YR,
		// String.valueOf(((RectPreference) pref).getRotationY()));
		// element.setAttribute(ZR,
		// String.valueOf(((RectPreference) pref).getRotationZ()));
		// element.setAttribute(COLOR,Rgb2hex(((RectPreference) pref)));
		return element;
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
		for (CommonObject3D graphicObject : paintingArea.getAllGraphicObjects()) {
			if (graphicObject instanceof ComplexObject3D) {
				shapePreferences.add(PreferenceFactory.getInstance()
						.createPrefFromComplexObject3D(
								(ComplexObject3D) graphicObject));
			} else {
				shapePreferences.add(PreferenceFactory.getInstance()
						.createPrefFromObject3D(graphicObject));
			}
		}
		savePreferencesToFile(shapePreferences, file);
	}
}
