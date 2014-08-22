package graphiceditor;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;

public class HelperShapeFactory {
	
	private static final double STANDARD_SIZE = 1000;
	
	private static HelperShapeFactory _instance;
	
	public static HelperShapeFactory getInstance(){
		if(_instance == null)
			_instance = new HelperShapeFactory();
		return _instance;
	}

	public List<Node> createGridShapes(Point3D pivot) {
		List<Node> grids = new ArrayList<Node>();
		Rectangle xyLevel = RectangleBuilder.create().x(pivot.getX())
				.y(pivot.getY() - STANDARD_SIZE).fill(Color.rgb(0, 100, 100, 0.09)).build();
		xyLevel.setHeight(STANDARD_SIZE);
		xyLevel.setWidth(STANDARD_SIZE);

		Rectangle xzLevel = RectangleBuilder.create().x(pivot.getX())
				.y(pivot.getY()).fill(Color.rgb(0, 100, 100, 0.09)).build();
		xzLevel.setHeight(STANDARD_SIZE);
		xzLevel.setWidth(STANDARD_SIZE);
		xzLevel.getTransforms().add(
				RotateBuilder.create().angle(-90).axis(Rotate.X_AXIS)
						.pivotX(pivot.getX()).pivotY(pivot.getY()).build());

		Rectangle yzLevel = RectangleBuilder.create().x(pivot.getX())
				.y(pivot.getY() - STANDARD_SIZE).fill(Color.rgb(0, 100, 100, 0.09)).build();
		yzLevel.setHeight(STANDARD_SIZE);
		yzLevel.setWidth(STANDARD_SIZE);
		yzLevel.getTransforms().add(
				RotateBuilder.create().angle(90).axis(Rotate.Y_AXIS)
						.pivotX(pivot.getX()).pivotY(pivot.getY()).build());

		
		grids.add(xyLevel);
		grids.add(xzLevel);
		grids.add(yzLevel);
		return grids;
	}

	public List<Node> createAxisShapes(Point3D pivot) {
		List<Node> shapes = new ArrayList<Node>();
		Line xAxisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(pivot.getX() + STANDARD_SIZE)
				.endY(pivot.getY()).strokeWidth(3.0).build();
		
		Line yAxisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(pivot.getX() + STANDARD_SIZE)
				.endY(pivot.getY()).strokeWidth(3.0).build();
		yAxisShape.getTransforms().add(RotateBuilder.create().angle(-90).axis(Rotate.Z_AXIS)
				.pivotX(pivot.getX()).pivotY(pivot.getY()).build());

		Line zAxisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(pivot.getX() + STANDARD_SIZE)
				.endY(pivot.getY()).strokeWidth(3.0).build();
		zAxisShape.getTransforms().add(RotateBuilder.create().angle(90).axis(Rotate.Y_AXIS)
				.pivotX(pivot.getX()).pivotY(pivot.getY()).build());
		
		shapes.add(zAxisShape);
		shapes.add(yAxisShape);
		shapes.add(xAxisShape);
		return shapes;
	}

}
