package graphiceditor.test;

import static org.junit.Assert.assertTrue;
import graphiceditor.Object3DBuilder;
import graphiceditor.shapes.CommonObject3D;
import graphiceditor.shapes.ComplexObject3D;
import graphiceditor.shapes.Object3D;
import graphiceditor.shapes.impl.Rectangle3D;
import graphiceditor.util.Cloner;

import org.junit.Before;
import org.junit.Test;

public class ClonerTest {

	private Object3D o;
	private ComplexObject3D co;

	@Before
	public void setup(){
		o = Object3DBuilder.create(Rectangle3D.class).x(100).y(200).build();
		co = ComplexObjec3DMock.create();
	}
	
	@Test
	public void testCloneingObject3D() {
		CommonObject3D copy = Cloner.getInstance().createCopy(o);
		
		assertTrue(copy != o);
		assertTrue(o.getXPositionProperty().get() == copy.getXPositionProperty().get());
		assertTrue(o.getYPositionProperty().get() == copy.getYPositionProperty().get());
	}
	
	@Test
	public void testCloneingComplexObject3D() {
		CommonObject3D copy = Cloner.getInstance().createCopy(co);
		
		assertTrue(copy != co);
		assertTrue(((ComplexObject3D)copy).getShapes().equals(co.getShapes()));
		assertTrue(co.getXPositionProperty().get() == copy.getXPositionProperty().get());
		assertTrue(co.getYPositionProperty().get() == copy.getYPositionProperty().get());
	}
}
