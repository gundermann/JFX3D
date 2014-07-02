package graphicpersistenshandler.util;

import java.awt.Color;

public class ColorConverter {

	private static ColorConverter _instance;
	
	public static ColorConverter getInstance(){
		if(_instance == null){
			_instance = new ColorConverter();
		}
		return _instance;
	}
	
	public Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(1, 3), 16),
				Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(
						colorStr.substring(5, 7), 16));
	}
	
	public String Rgb2hex(int r, int g, int b) {
		StringBuilder c = new StringBuilder("#");
		if(r <= 16)
			c.append(0);
		c.append(Integer.toHexString(r));
		if(g <= 16)
			c.append(0);
		c.append(Integer.toHexString(g));
		if(b <= 16)
			c.append(0);
		c.append(Integer.toHexString(b));
		return c.toString();
	}
}
