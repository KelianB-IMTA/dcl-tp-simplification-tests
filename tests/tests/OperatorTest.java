package tests;

import org.junit.Assert;
import org.junit.Test;

import simplification.Operator;

public class OperatorTest {
	Operator op1 = new Operator(".", 2);
	Operator op2 = new Operator(".", 1);
	Operator op3 = new Operator("$", 2);
	
	@Test
	public void testGetName() {
		Assert.assertEquals(op1.getName(), ".");
		Assert.assertEquals(Operator.PLUS.getName(), "+");
		Assert.assertEquals(Operator.DIV.getName(), "/");
		Assert.assertEquals(Operator.MOINS.getName(), "-");
		Assert.assertEquals(Operator.MULT.getName(), "*");
	}

	@Test
	public void testOperator() {
		Assert.assertEquals(new Operator("@", 2).getName(), "@");
		Assert.assertEquals(new Operator("@", 4).getArity(), 4);
	}

	@Test
	public void testEstPlus() {
		Assert.assertTrue(Operator.PLUS.estPlus());
		Assert.assertFalse(op1.estPlus());
	}

	@Test
	public void testEstMult() {
		Assert.assertTrue(Operator.MULT.estMult());
		Assert.assertFalse(op1.estMult());
	}

	@Test
	public void testEstDiv() {
		Assert.assertTrue(Operator.DIV.estDiv());
		Assert.assertFalse(op1.estDiv());
	}

	@Test
	public void testEstMoins() {
		Assert.assertTrue(Operator.MOINS.estMoins());
		Assert.assertFalse(op1.estMoins());
	}

	@Test
	public void testEqualsObject() {
		Assert.assertFalse(op1.equals(op2));
		Assert.assertFalse(op1.equals(op3));
		Assert.assertTrue(op1.equals(op1));
	}

	@Test
	public void testToString() {
		Assert.assertEquals(op1.toString(), ".");
	}

	@Test
	public void testGetArity() {
		Assert.assertEquals(op1.getArity(), 2);
	}

}
