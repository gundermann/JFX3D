package graphiceditor.sample;

import graphiceditor.business.Object3D;
import graphiceditor.domainspecific.values.Rotation;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;

public class ComplexObject3DImpl extends Group implements Object3D{

	@Override
	public Node asNode() {
		return this;
	}

	@Override
	public void addTransforms(Rotation rootRotateX, Rotation rootRotateY,
			Rotation rootRotateZ) {
		getTransforms().addAll(rootRotateX, rootRotateY, rootRotateZ);
	}

	@Override
	public void enableRotation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableRotation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveZ(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveY(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObservableValue<? extends String> getXPositionProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableValue<? extends String> getYPositionProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableValue<? extends String> getZPositionProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeWidth(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeHeight(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DoubleProperty getHeightProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoubleProperty getWidthProperty() {
		// TODO Auto-generated method stub
		return null;
	}



}
