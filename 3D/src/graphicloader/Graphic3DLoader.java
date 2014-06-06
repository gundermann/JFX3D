package graphicloader;

import graphiceditor.shapes.Object3D;
import graphicloader.prefs.RectPreference;
import graphicloader.prefs.ShapePreference;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Graphic3DLoader extends AbstractGraphic3DPersister {

	private static Graphic3DLoader _instance;
	
	public static Graphic3DLoader getInstace() {
		if(_instance == null){
			_instance = new Graphic3DLoader();
		}
		return _instance;
	}

	public List<ShapePreference> loadPreferencesFromFile(File file) {
		List<ShapePreference> pixelPreferenceList = new ArrayList<ShapePreference>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			NodeList graphicList = doc.getChildNodes();

			for (int temp = 0; temp < graphicList.getLength(); temp++) {
				pixelPreferenceList.add(convertToPreference(graphicList
						.item(temp)));

			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return pixelPreferenceList;
	}

	private ShapePreference convertToPreference(Node item) {
		RectPreference pixelPreference = new RectPreference();
		if (item.getNodeType() == Node.ELEMENT_NODE) {

			Element element = (Element) item;
			pixelPreference.setBeginningX(Double.parseDouble(element
					.getAttribute(X)));
			pixelPreference.setBeginningY(Double.parseDouble(element
					.getAttribute(Y)));
			pixelPreference.setBeginningZ(Double.parseDouble(element
					.getAttribute(Z)));
			pixelPreference.setWidth(Double.parseDouble(element
					.getAttribute(WIDTH)));
			pixelPreference.setHeight(Double.parseDouble(element
					.getAttribute(HEIGHT)));
			pixelPreference.setRotationX(Integer.parseInt(element
					.getAttribute(XR)));
			pixelPreference.setRotationY(Integer.parseInt(element
					.getAttribute(YR)));
			pixelPreference.setRotationZ(Integer.parseInt(element
					.getAttribute(ZR)));
//			Color rgb = hex2Rgb(element.getAttribute(COLOR));
//			pixelPreference.setRed(rgb.getRed());
//			pixelPreference.setGreen(rgb.getGreen());
//			pixelPreference.setBlue(rgb.getBlue());
		}

		return pixelPreference;
	}

	public Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(1, 3), 16),
				Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(
						colorStr.substring(5, 7), 16));
	}

	public List<Object3D> getShapesFromLoader(File file) {
		List<ShapePreference> preferences = loadPreferencesFromFile(file);
		return Graphic3DFactory.convertPreferencesTo3DGraphics(preferences);
	}

	public File initLoading() {
		FileChooser filechooser = new FileChooser();
		return filechooser.showOpenDialog(new Stage());
	}
}
