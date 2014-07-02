package graphicpersistenshandler;

import graphiceditor.shapes.CommonObject3D;
import graphicpersistenshandler.prefs.CommonShapePreference;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;
import graphicpersistenshandler.prefs.impl.RectPreference;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Graphic3DLoader extends AbstractGraphic3DPersister {

	private static final String NAME = "name";
	private static Graphic3DLoader _instance;

	public static Graphic3DLoader getInstace() {
		if (_instance == null) {
			_instance = new Graphic3DLoader();
		}
		return _instance;
	}

	public List<CommonShapePreference> loadPreferencesFromFile(File file) {
		List<CommonShapePreference> pixelPreferenceList = new ArrayList<CommonShapePreference>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			NodeList graphicList = doc.getChildNodes();

			if (graphicList.item(0).getNodeName().equals(ROOT)) {
				graphicList = graphicList.item(0).getChildNodes();
			}
			
			for (int temp = 0; temp < graphicList.getLength(); temp++) {
				CommonShapePreference convertedPreference = convertToPreference(graphicList
						.item(temp));
				if (convertedPreference != null)
					pixelPreferenceList.add(convertedPreference);

			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return pixelPreferenceList;
	}

	private ComplexShapePreference convertToComplexPreference(Node item) {
		List<ShapePreference> listOfPreferenceMaps =  extractComplex(item.getChildNodes());
		String title = ((Element)item).getAttribute(NAME);
		return PreferenceFactory.getInstance().createComplexPrefFromPrefMap(title, listOfPreferenceMaps);
	}

	private List<ShapePreference> extractComplex(
			NodeList childNodes) {
		List<ShapePreference> listOfPreferenceMap = new ArrayList<ShapePreference>();
		for(int i = 0; i< childNodes.getLength();i++){
			listOfPreferenceMap.add((ShapePreference) convertToPreference(childNodes.item(i)));
			
		}
		return listOfPreferenceMap;
	}

	private CommonShapePreference convertToPreference(Node item) {
		CommonShapePreference preference = null;
		if (item.getNodeName().equals(COMPLEX)) {
			preference =  convertToComplexPreference(item);
		}
		else{
			if(item.getNodeType() == Node.ELEMENT_NODE){
			Element element = (Element) item;
			Map<String, String> prefMap = extract(element);
//				pixelPreference.setBeginningX(Double.parseDouble(element
//						.getAttribute(X)));
//				pixelPreference.setBeginningY(Double.parseDouble(element
//						.getAttribute(Y)));
//				pixelPreference.setBeginningZ(Double.parseDouble(element
//						.getAttribute(Z)));
//				pixelPreference.setWidth(Double.parseDouble(element
//						.getAttribute(WIDTH)));
//				pixelPreference.setHeight(Double.parseDouble(element
//						.getAttribute(HEIGHT)));
//				pixelPreference.setRotationX(Double.parseDouble(element
//						.getAttribute(XR)));
//				pixelPreference.setRotationY(Double.parseDouble(element
//						.getAttribute(YR)));
//				pixelPreference.setRotationZ(Double.parseDouble(element
//						.getAttribute(ZR)));
//				pixelPreference.setRed(rgb.getRed());
//				pixelPreference.setGreen(rgb.getGreen());
//				pixelPreference.setBlue(rgb.getBlue());
			preference =PreferenceFactory.getInstance().createPrefFromPrefMap(item.getNodeName(), prefMap);
			}
		}
		return preference;
	}

	private Map<String, String> extract(Element e) {
		Map<String, String> prefMap = new HashMap<String, String>();
		NamedNodeMap attributes = e.getAttributes();
		for(int i = 0; i< attributes.getLength();i++){
			Node item = attributes.item(i);
			prefMap.put(item.getNodeName(), item.getNodeValue());
		}
		return prefMap ;
	}

	public List<CommonObject3D> getShapesFromLoader(File file) {
		List<CommonShapePreference> preferences = loadPreferencesFromFile(file);
		return Graphic3DConverter.getInstance().convertPreferencesTo3DGraphics(preferences);
	}

	public File initLoading() {
		FileChooser filechooser = new FileChooser();
		return filechooser.showOpenDialog(new Stage());
	}
}
