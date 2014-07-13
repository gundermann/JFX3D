package graphiceditor.util;

import graphiceditor.Object3DBuilder;
import graphiceditor.gui.PaintingArea;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;

import java.util.ArrayList;
import java.util.List;

public class ShapeSummarizer implements Setup {

	private static ShapeSummarizer _instance;
	private PaintingArea actualPaintingArea;
	private List<Integer> selectedIndices;

	public static ShapeSummarizer getInstance() {
		if (_instance == null)
			_instance = new ShapeSummarizer();
		return _instance;
	}

	public void summazire(PaintingArea actualPaintingArea,
			List<Integer> selectedIndices) {
		this.actualPaintingArea = actualPaintingArea;
		this.selectedIndices = selectedIndices;
		TextFieldDialog.showSetup(this);
	}

	@Override
	public void setText(String text) {
		List<CommonObject3D> shapes = new ArrayList<CommonObject3D>();
		for (Integer i : selectedIndices) {
			shapes.add(actualPaintingArea.getAllGraphicObjects().get(i));
		}
		actualPaintingArea.removeByIndex(selectedIndices);

		actualPaintingArea
				.add(Object3DBuilder.createKomplexShape(shapes, text));

	}

	public void split(PaintingArea actualPaintingArea,
			List<Integer> selectedIndices) {
		this.actualPaintingArea = actualPaintingArea;
		this.selectedIndices = selectedIndices;
		ComplexObject3D complexGraphic = (ComplexObject3D) actualPaintingArea.getActualPainting();
		List<CommonObject3D> splitedShapes = complexGraphic.getShapes();
		for(CommonObject3D shape : splitedShapes){
			shape.moveX(complexGraphic.getXPositionProperty().get());
			shape.moveY(complexGraphic.getYPositionProperty().get());
			shape.moveZ(complexGraphic.getZPositionProperty().get());
		}
		actualPaintingArea.removeByIndex(selectedIndices);
		actualPaintingArea.addAll(splitedShapes );
	}

}
