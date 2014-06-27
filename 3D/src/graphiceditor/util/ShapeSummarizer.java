package graphiceditor.util;

import graphiceditor.Object3DBuilder;
import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.CommonObject3D;

import java.util.ArrayList;
import java.util.List;

public class ShapeSummarizer {

	private static ShapeSummarizer _instance;

	public static ShapeSummarizer getInstance() {
		if(_instance==null)
			_instance = new ShapeSummarizer();
		return _instance;
	}

	public void summazire(PaintingArea actualPaintingArea,
			List<Integer> selectedIndices) {
		List<CommonObject3D> shapes = new ArrayList<CommonObject3D>();
		for(Integer i : selectedIndices){
			shapes.add(actualPaintingArea.getAllGraphicObjects().get(i));
		}
		actualPaintingArea.removeByIndex(selectedIndices);
		
		actualPaintingArea.add(Object3DBuilder.createKomplexShape(shapes, "Complex"));
	}

}
