package graphiceditor.domainspecific.values;

import graphiceditor.domainspecific.values.observable.AngleProperty;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PaintableAxis extends Axis {

	private Line axisShape;

	public PaintableAxis(Point3D axis,
			AngleProperty angleProperty) {
		super(axis, angleProperty);
//		axisShape = LineBuilder.create().startX(pivot.getX())
//				.startY(pivot.getY()).endX(axis.getX() + pivot.getX())
//				.endY(axis.getY() + pivot.getY()).build();
//		if (axis.getZ() != 0){
//			axisShape.setEndX(1000);
//			axisShape.getTransforms().add(
//					RotateBuilder.create().axis(Rotate.Y_AXIS)
//							.pivotX(getPivotX()).pivotY(getPivotY())
//							.pivotZ(getPivotZ()).angle(90).build());
//		}
//		axisShape.setFill(Color.RED);
	}

	public Line getAxisShape() {
		return axisShape;
	}

}
