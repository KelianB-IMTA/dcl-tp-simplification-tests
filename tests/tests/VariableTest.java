package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import simplification.InvalidVariableNameException;
import simplification.Variable;

public class VariableTest {
	Variable x, y, z;
	
	@Before
	public void set() {
		try {
			x = new Variable("x");
			z = new Variable("z");
			y = new Variable("y");
		}
		catch(InvalidVariableNameException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(x.getName(), "x");
	}

	@Test
	public void testVariable() {
		try {
			Assert.assertEquals(new Variable("p").getName(), "p");
		} catch (InvalidVariableNameException e) {
			e.printStackTrace();
		}
		Assertions.assertThrows(NullPointerException.class, () -> new Variable(null));
		Assertions.assertThrows(InvalidVariableNameException.class, () -> new Variable(""));
		Assertions.assertThrows(InvalidVariableNameException.class, () -> new Variable("3.14159265"));
		
	}

	@Test
	public void testToString() {
		Assert.assertEquals(x.toString(), "x");
	}

	@Test
	public void testCompute() {
		Assert.assertTrue(y.compute() == 0);
	}

	@Test
	public void testIsZero() {
		Assert.assertFalse(x.isZero());
	}

	@Test
	public void testIsUnit() {
		Assert.assertFalse(x.isUnit());
	}

	@Test
	public void testEngine() {
		Assert.assertTrue(x.engine() == x);
	}

	@Test
	public void testEqualsObject() {
		Assert.assertFalse(x.equals(y));
		Assert.assertTrue(x.equals(x));
	}

	@Test
	public void testIsComputable() {
		Assert.assertFalse(x.isComputable());
	}

	@Test
	public void testOneReduction() {
		Assert.assertTrue(x.oneReduction() == x);
	}

}
