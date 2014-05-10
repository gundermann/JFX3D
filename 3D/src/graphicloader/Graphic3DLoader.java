package graphicloader;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Graphic3DLoader {

  private static final String X = "x-coordinate";

  private static final String Y = "y-coordinate";

  private static final String Z = "z-coordinate";

  private static final String COLOR = "color";

  public static List<PixelPreference> loadPixelPreferencesFromFile( File file ) {
    List<PixelPreference> pixelPreferenceList = new ArrayList<PixelPreference>();
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    try {
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse( file );

      doc.getDocumentElement().normalize();

      NodeList graphicList = doc.getChildNodes();

      for ( int temp = 0; temp < graphicList.getLength(); temp++ ) {
        pixelPreferenceList.add( convertToPreference( graphicList.item( temp ) ) );

      }
    }
    catch ( SAXException | IOException | ParserConfigurationException e ) {
      e.printStackTrace();
    }
    return pixelPreferenceList;
  }

  private static PixelPreference convertToPreference( Node item ) {
    PixelPreference pixelPreference = new PixelPreference();
    if ( item.getNodeType() == Node.ELEMENT_NODE ) {

      Element element = (Element) item;
      pixelPreference.setX( Double.parseDouble( element.getAttribute( X ) ) );
      pixelPreference.setY( Double.parseDouble( element.getAttribute( Y ) ) );
      pixelPreference.setZ( Double.parseDouble( element.getAttribute( Z ) ) );
      Color rgb = hex2Rgb( element.getAttribute( COLOR ) );
      pixelPreference.setRed( rgb.getRed() );
      pixelPreference.setGreen( rgb.getGreen() );
      pixelPreference.setBlue( rgb.getBlue() );
    }

    return pixelPreference;
  }

  public static Color hex2Rgb( String colorStr ) {
    return new Color( Integer.valueOf( colorStr.substring( 1, 3 ), 16 ), Integer.valueOf( colorStr.substring( 3, 5 ),
        16 ), Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
  }
}
