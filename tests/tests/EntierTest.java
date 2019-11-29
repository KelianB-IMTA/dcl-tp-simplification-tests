package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simplification.Entier;

public class EntierTest {
	Entier trois, huit;

	@Before
	public void set() {
		trois = new Entier(3);
		huit = new Entier(8);
	}
	
	@Test
	public void testGetValeur() {
		assertTrue(trois.getValue() == 3);
		assertTrue(Entier.ZERO.getValue() == 0);
		assertTrue(Entier.UN.getValue() == 1);
	}

	@Test
	public void testEntier() {
		assertEquals(new Entier(3), trois);
	}


	@Test
	public void testIsZero() {
		assertTrue(Entier.ZERO.isZero());
		assertFalse(Entier.UN.isZero());
	}

	@Test
	public void testIsUnit() {
		assertFalse(Entier.ZERO.isUnit());
		assertTrue(Entier.UN.isUnit());
	}
	
	@Test
	public void testToString() {
		assertEquals(trois.toString(), "3");
	}

	@Test
	public void testIsComputable() {
		assertTrue(trois.isComputable());
	}

	@Test
	public void testCompute() {
		assertTrue(trois.getValue() == trois.compute());
	}

	@Test
	public void testOneReduction() {
		assertTrue(trois.oneReduction() == trois);
	}

	@Test
	public void testEngine() {
		assertTrue(Entier.ZERO.engine() == Entier.ZERO);
		assertTrue(trois.engine() == trois);
	}
	
	@Test
	public void testEquals() {
		assertTrue(Entier.ZERO.equals(new Entier(0)));
		assertFalse(trois.equals(3));
		assertFalse(trois.equals(huit));
	}
	
	@After
	public void unset() {
		trois = null;
	}
}
