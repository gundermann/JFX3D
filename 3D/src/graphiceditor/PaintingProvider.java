package graphiceditor;

import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.Rectangle3D;

import java.util.HashMap;
import java.util.Map;

public class PaintingProvider {

	public static Map<Painting, Class<? extends Object3D>> getPaintingClasses() {
		Map<Painting, Class<? extends Object3D>> paintingStartListener = new HashMap<Painting, Class<? extends Object3D>>();
		paintingStartListener.put(Painting.Rectangle,
				Rectangle3D.class);
		return paintingStartListener;
	}

}
