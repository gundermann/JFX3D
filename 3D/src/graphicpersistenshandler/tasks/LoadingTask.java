package graphicpersistenshandler.tasks;

import graphiceditor.gui.GUIMain;
import graphicpersistenshandler.PreferenceFactory;
import graphicpersistenshandler.prefs.ComplexShapePreference;
import graphicpersistenshandler.prefs.ShapePreference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.concurrent.Task;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LoadingTask extends Task<List<ShapePreference>> {

	protected static final String ROOT = "shape_definition";
	
	protected static final String COMPLEX = "complex";
	private File file;

	public LoadingTask(File file) {
		this.file = file;
		GUIMain.getInstance().addProgressProperty(progressProperty());
	}

	@Override
	protected List<ShapePreference> call() throws Exception {
		return loadPreferencesFromFile(file);
	}

	public List<ShapePreference> loadPreferencesFromFile(File file) {
		List<ShapePreference> pixelPreferenceList = new ArrayList<ShapePreference>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			NodeList graphicList = doc.getChildNodes();

			if (graphicList.item(0).getNodeName().equals(ROOT)) {
				graphicList = graphicList.item(0).getChildNodes();
			}
			int length = graphicList.getLength();
			for (int temp = 0; temp < length; temp++) {
				ShapePreference convertedPreference = convertToPreference(graphicList
						.item(temp));
				if (convertedPreference != null)
					pixelPreferenceList.add(convertedPreference);
				updateProgress(temp+1, length);
				
				
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return pixelPreferenceList;
	}

	private ComplexShapePreference convertToComplexPreference(Node item) {
		List<ShapePreference> listOfPreferenceMaps = extractComplex(item
				.getChildNodes());
		Map<String, String> preferenceMap = extract((Element) item);
		return PreferenceFactory.getInstance().createComplexPrefFromPrefMap(
				preferenceMap, listOfPreferenceMaps);
	}

	private List<ShapePreference> extractComplex(NodeList childNodes) {
		List<ShapePreference> listOfPreferenceMap = new ArrayList<ShapePreference>();
		for (int i = 0; i < childNodes.getLength(); i++) {
			listOfPreferenceMap
					.add(convertToPreference(childNodes
							.item(i)));

		}
		return listOfPreferenceMap;
	}

	private ShapePreference convertToPreference(Node item) {
		ShapePreference preference = null;
		if (item.getNodeName().equals(COMPLEX)) {
			preference = convertToComplexPreference(item);
		} else {
			if (item.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) item;
				Map<String, String> prefMap = extract(element);
				preference = PreferenceFactory.getInstance()
						.createPrefFromPrefMap(item.getNodeName(), prefMap);
			}
		}
		return preference;
	}

	private Map<String, String> extract(Element e) {
		Map<String, String> prefMap = new HashMap<String, String>();
		NamedNodeMap attributes = e.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node item = attributes.item(i);
			prefMap.put(item.getNodeName(), item.getNodeValue());
		}
		return prefMap;
	}

}
