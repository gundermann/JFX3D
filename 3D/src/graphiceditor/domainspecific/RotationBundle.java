package graphiceditor.domainspecific;

import graphiceditor.domainspecific.values.Axis;
import graphiceditor.domainspecific.values.PaintableAxis;
import graphiceditor.domainspecific.values.Rotation;

import java.util.ArrayList;
import java.util.List;

public class RotationBundle {

	private List<Rotation> rotationList;

	public RotationBundle() {
		rotationList = new ArrayList<Rotation>();
	}

	public void addRotationOfAxis(Axis... axis) {
		for (Axis newAxis : axis) {
			Rotation newRotation = new Rotation(newAxis);
			rotationList.add(newRotation);
		}
	}

	public Rotation getRotation(int rotationIndex) {
		return rotationList.get(rotationIndex);
	}

	public void disableAll() {
		for(Rotation rotation : rotationList){
			rotation.disable();
		}
	}

	public PaintableAxis getAxis(int axisIndex) {
		return (PaintableAxis) rotationList.get(axisIndex).getRotationAxis();
	}
}
