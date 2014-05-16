package graphiceditor.gui.property.test;

import static org.junit.Assert.*;
import graphiceditor.domainspecific.values.observable.RotationProperty;

import org.junit.Before;
import org.junit.Test;

public class RotationPropertyTest {

	private RotationProperty property;
	
	@Before
	public void setup(){
		property = new RotationProperty();
	}
	
	@Test
	public void test0To180() {
		property.set(0.0);
		assertTrue(property.getValue() == 0.0);
		property.set(50.0);
		assertTrue(property.getValue() == 50.0);
		property.set(180.0);
		assertTrue(property.getValue() == 180.0);
	}

	
	@Test
	public void test0To180Negated() {
		property.set(0.0);
		assertTrue(property.getValue() == 0.0);
		property.set(-50.0);
		assertTrue(property.getValue() == -50.0);
		property.set(-180.0);
		assertTrue(property.getValue() == 180.0);
	}

}
