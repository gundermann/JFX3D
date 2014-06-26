package graphiceditor.domainspecific;

import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.Rotation;
import graphiceditor.domainspecific.values.observable.AngleProperty;
import graphiceditor.domainspecific.values.observable.RotationProperty;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;

public class RotationBundle {

	public static final int X = 0;

	public static final int Y = 1;

	public static final int Z = 2;

	private List<Rotation> rotationList;

	private Rotation[] rotations;

	private Point3D pivot;

	public RotationBundle() {
		rotationList = new ArrayList<Rotation>();
		rotations = new Rotation[3];
	}

	public RotationBundle(Point3D pivot) {
		this.pivot = pivot;
		rotations = new Rotation[3];
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

	public void addRotationAxis(int axisnumber, Axis axis) {
		rotations[axisnumber] = new Rotation(axis);
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

	public void setXAxisRotation(RotationProperty rootAngleX) {
		setRotation(X,Rotate.X_AXIS, rootAngleX);
	}

	private void setRotation(int r, Point3D axisPoint, RotationProperty rp) {
		AngleProperty angleProperty = new AngleProperty(rp);
		Axis axis = new Axis(axisPoint, angleProperty);
		rotations[r] = new Rotation(axis);
		rotations[r].setPivot(pivot);
	}

	public void setYAxisRotation(RotationProperty rootAngleY) {
		setRotation(Y,Rotate.Y_AXIS, rootAngleY);
	}
	
	public void setZAxisRotation(RotationProperty rootAngleZ) {
		setRotation(Z,Rotate.Z_AXIS, rootAngleZ);
	}

	public Rotation[] getRotations() {
		return rotations;
	}

	public void enableXAxisRotation() {
		rotations[X].enable();
	}
	
	public void enableYAxisRotation() {
		rotations[Y].enable();
	}
	
	public void enableZAxisRotation() {
		rotations[Z].enable();
	}
}
