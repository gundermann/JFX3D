package graphiceditor.shapes;

import java.util.List;


public interface ComplexObject3D extends CommonObject3D {

	void scale(double heigt, double width);
	
	List<CommonObject3D> getShapes();
	
}
