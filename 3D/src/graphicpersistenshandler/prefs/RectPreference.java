package graphicpersistenshandler.prefs;

import graphiceditor.shapes.impl.Rectangle3D;

public class RectPreference implements ShapePreference {

	private double beginningX;

	private double beginningY;

	private double beginningZ;

	private double height;

	private double width;

	private double rotationX;

	private double rotationY;

	private double rotationZ;

	private int red;

	private int green;

	private int blue;

	@Override
	public Rectangle3D createShape() {
		Rectangle3D rect = new Rectangle3D();
		rect.setupX(beginningX);
		rect.setupY(beginningY);
		rect.moveZ(beginningZ);
		rect.getWidthProperty().set(width);
		rect.getHeightProperty().set(height);
		rect.rotateX(rotationX);
		rect.rotateY(rotationY);
		rect.rotateZ(rotationZ);
		rect.getColor().getR().set(red);
		rect.getColor().getG().set(green);
		rect.getColor().getB().set(blue);
		return rect;
	}

	public double getBeginningX() {
		return beginningX;
	}

	public void setBeginningX(double beginningX) {
		this.beginningX = beginningX;
	}

	public double getBeginningY() {
		return beginningY;
	}

	public void setBeginningY(double beginningY) {
		this.beginningY = beginningY;
	}

	public double getBeginningZ() {
		return beginningZ;
	}

	public void setBeginningZ(double beginningZ) {
		this.beginningZ = beginningZ;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getRotationX() {
		return rotationX;
	}

	public void setRotationX(double rotationX) {
		this.rotationX = rotationX;
	}

	public double getRotationY() {
		return rotationY;
	}

	public void setRotationY(double rotationY) {
		this.rotationY = rotationY;
	}

	public double getRotationZ() {
		return rotationZ;
	}

	public void setRotationZ(double rotationZ) {
		this.rotationZ = rotationZ;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	

}
