package graphiceditor;

import graphiceditor.business.Painting;

import java.util.HashMap;
import java.util.Map;

public class PaintingProvider {


	private static PaintingProvider _instance;

	public Map<Painting, Object3DFactory> getFactoryFormPaintingMode() {
		Map<Painting, Object3DFactory> paintingStartListener = new HashMap<Painting, Object3DFactory>();
		paintingStartListener.put(Painting.Rectangle,
				Rectangle3DFactory.getInstance());
		paintingStartListener.put(Painting.Ellipse,
				Ellipse3DFactory.getInstance());
		return paintingStartListener;
	}

	public static PaintingProvider getInstance() {
		if(_instance == null)
			_instance = new PaintingProvider();
		return _instance;
	}

}
