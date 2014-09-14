package graphiceditor.test;

import static org.junit.Assert.assertTrue;
import graphiceditor.Rectangle3DFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.ComplexObject3D;
import graphiceditor.util.Cloner;

import org.junit.Before;
import org.junit.Test;

public class ClonerTest {

	private CommonObject3D o;
	private ComplexObject3D co;

	@Before
	public void setup(){
		o = Rectangle3DFactory.getInstance().create(100,200);
		co = ComplexObjec3DMock.getInstance().create();
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
