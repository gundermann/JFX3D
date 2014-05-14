package graphiceditor.gui.transform;

import graphiceditor.gui.observable.AngleProperty;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.transform.Rotate;

public class PaintableAxis extends Axis{

	private Line axisShape;

	public PaintableAxis(Point3D pivot, Point3D direction, AngleProperty angleProperty) {
		super(pivot, direction, angleProperty);
		axisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(direction.getX() + pivot.getX())
				.endY(direction.getY() + pivot.getY()).build();
		if (direction.getZ() != 0)
			axisShape.getTransforms().add(new Rotate(-90, pivot));
		axisShape.translateZProperty().add(pivot.getZ());
		axisShape.setFill(Color.RED);
	}

	public Line getAxisShape() {
		return axisShape;
	}

}
