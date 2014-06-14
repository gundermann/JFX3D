package graphiceditor.domainspecific;

import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.Rotation;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point3D;

public class RotationBundle {

	private List<Rotation> rotationList;

	private Point3D pivot;

	public RotationBundle() {
		rotationList = new ArrayList<Rotation>();
	}

	public void addRotationOfAxis(Axis... axis) {
		for (Axis newAxis : axis) {
			Rotation newRotation = new Rotation(newAxis);
			rotationList.add(newRotation);
		}
		if (pivot != null)
			updatePivot();
	}

	public Rotation getRotation(int rotationIndex) {
		return rotationList.get(rotationIndex);
	}

	public void disableAll() {
		for (Rotation rotation : rotationList) {
			rotation.disable();
		}
	}

	public Axis getAxis(int axisIndex) {
		return rotationList.get(axisIndex).getRotationAxis();
	}

	public void clear() {
		rotationList.clear();
	}

	public void resetAll() {
		for (Rotation rotation : rotationList) {
			rotation.setAngle(0);
		}
	}

	public void setPivot(Point3D pivot) {
		this.pivot = pivot;
		updatePivot();
	}

	private void updatePivot() {
		for (Rotation rotation : rotationList) {
			rotation.setPivotX(pivot.getX());
			rotation.setPivotY(pivot.getY());
			rotation.setPivotZ(pivot.getZ());
		}
	}
}
