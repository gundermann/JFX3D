package graphicloader;

import graphicloader.prefs.RectPreference;
import graphicloader.prefs.ShapePreference;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Graphic3DSaver {

	private static final String X = "x-coordinate";

	private static final String Y = "y-coordinate";

	private static final String Z = "z-coordinate";

	private static final String COLOR = "color";

	private static final String WIDTH = "width";

	private static final String HEIGHT = "height";

	private static final String XR = "xr";

	private static final String YR = "yr";

	private static final String ZR = "zr";

	public static void savePreferencesToFile(List<ShapePreference> pixelPreferences, File file) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			for (ShapePreference pref :  pixelPreferences) {
				Element element = doc.createElement("rect");
				element.setAttribute(X, String.valueOf(((RectPreference) pref).getBeginningX()));
				element.setAttribute(Y, String.valueOf(((RectPreference) pref).getBeginningY()));
				element.setAttribute(Z, String.valueOf(((RectPreference) pref).getBeginningZ()));
				element.setAttribute(WIDTH, String.valueOf(((RectPreference) pref).getWidth()));
				element.setAttribute(HEIGHT, String.valueOf(((RectPreference) pref).getHeight()));
				element.setAttribute(XR, String.valueOf(((RectPreference) pref).getRotationX()));
				element.setAttribute(YR, String.valueOf(((RectPreference) pref).getRotationY()));
				element.setAttribute(ZR, String.valueOf(((RectPreference) pref).getRotationZ()));
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}
