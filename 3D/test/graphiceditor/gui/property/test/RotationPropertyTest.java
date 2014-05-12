package graphiceditor.gui.property.test;

import static org.junit.Assert.*;
import graphiceditor.gui.property.RotationProperty;

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

	public void test181To360() {
		property.set(181.0);
		assertTrue(property.getValue() == -1.0);
		property.set(260.0);
		assertTrue(property.getValue() == -80.0);
		property.set(360.0);
		assertTrue(property.getValue() == 0.0);
	}
	
	public void test361To540() {
		property.set(361.0);
		assertTrue(property.getValue() == 1.0);
		property.set(440.0);
		assertTrue(property.getValue() == 80.0);
		property.set(540.0);
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

	public void test181To360Negated() {
		property.set(-181.0);
		assertTrue(property.getValue() == 179.0);
		property.set(-260.0);
		assertTrue(property.getValue() == 100.0);
		property.set(-360.0);
		assertTrue(property.getValue() == 0.0);
	}
	
	public void test361To540Negated() {
		property.set(-361.0);
		assertTrue(property.getValue() == -1.0);
		property.set(-440.0);
		assertTrue(property.getValue() == -80.0);
		property.set(-540.0);
		assertTrue(property.getValue() == 180.0);
	}
}
