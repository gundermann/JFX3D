package graphiceditor.domainspecific.values;

import graphiceditor.domainspecific.values.observable.AngleProperty;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;

public class PaintableAxis extends Axis {

	private Line axisShape;

	public PaintableAxis(Point3D pivot, Point3D direction,
			AngleProperty angleProperty) {
		super(pivot, direction, angleProperty);
		axisShape = LineBuilder.create().startX(pivot.getX())
				.startY(pivot.getY()).endX(direction.getX() + pivot.getX())
				.endY(direction.getY() + pivot.getY()).build();
		if (direction.getZ() != 0){
			axisShape.setEndX(1000);
			axisShape.getTransforms().add(
					RotateBuilder.create().axis(Rotate.Y_AXIS)
							.pivotX(getPivotX()).pivotY(getPivotY())
							.pivotZ(getPivotZ()).angle(90).build());
		}
		axisShape.setFill(Color.RED);
	}

	public Line getAxisShape() {
		return axisShape;
	}

}
