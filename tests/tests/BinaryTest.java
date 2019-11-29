package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import simplification.Binary;
import simplification.Entier;
import simplification.InvalidVariableNameException;
import simplification.Operator;
import simplification.Variable;

public class BinaryTest {
	Variable x, y, z;
	Entier trois, deux, cinq, six;
	Operator otherOperator;
	
	Binary b1, b3, b4;
	Binary simpleAdd1, simpleAdd2;
	Binary simpleSubstract1, simpleSubstract2;
	Binary simpleMult, simpleDiv;
	Binary exp, exp1, exp2, exp3, exp4, exp5, exp7;
	Binary c, e, f;
	Binary duo, trio, t, fi;
	
	Binary simplifyable1, simplifyable2, simplifyable3,
		simplifyable4, simplifyable5, simplifyable6,
		simplifyable7, simplifyable8, simplifyable9;

	Binary otherOperatorBin;
	Binary equalZero;
	Binary complexSimplifyable;
	
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
	
		trois = new Entier(3);
		deux = new Entier(2);
		cinq = new Entier(5);
		six = new Entier(6);
		
		otherOperator = new Operator("#", 2);
		
		// 1-x
		simpleSubstract1 = new Binary(Entier.UN,Operator.MOINS,x);
		simpleSubstract2 = new Binary(x,Operator.MOINS,Entier.UN);
		// 1+x
		simpleAdd1 = new Binary(Entier.UN,Operator.PLUS,x);
		simpleAdd2 = new Binary(x,Operator.PLUS,Entier.UN);
		// x*2
		simpleMult = new Binary(x, Operator.MULT, deux);
		// x/2
		simpleDiv = new Binary(x, Operator.DIV, deux);
		
		// b1+b2
		b1 = new Binary(x,Operator.MULT,x);
		b3 =  new Binary(b1,Operator.PLUS,simpleAdd1);
		b4 = new Binary(simpleSubstract1,Operator.MULT,b3);
		// x+z
		exp1 = new Binary(x,Operator.PLUS,z);
		e = new Binary(x,Operator.MOINS,z);
		f = new Binary(e,Operator.MULT,exp1);
		exp2 = new Binary(z,Operator.MOINS,x);
		exp3 = new Binary(exp2,Operator.MULT,exp1);
		// 3+6
		exp4 = new Binary(trois,Operator.PLUS,six);
		exp5 = new Binary(exp4,Operator.MULT,exp3);
		// 1+2
		exp = new Binary(Entier.UN,Operator.PLUS,deux);
		// exp4*exp
		exp7 = new Binary(exp4,Operator.MULT,exp);
		 
		
		duo = new Binary(simpleSubstract1,Operator.MULT,exp);
		trio = new Binary(cinq,Operator.MOINS,y);
		t = new Binary(duo,Operator.MULT,trio);
		fi = new Binary(exp2,Operator.MULT,duo);		
		
		simplifyable1 = new Binary(Entier.UN, Operator.MULT, x);
		simplifyable2 = new Binary(Entier.ZERO, Operator.MULT, x);
		simplifyable3 = new Binary(x, Operator.DIV, Entier.UN);
		simplifyable4 = new Binary(x,Operator.PLUS,Entier.ZERO);
		simplifyable5 = new Binary(z,Operator.MOINS,Entier.ZERO);
		simplifyable6 = new Binary(Entier.ZERO,Operator.PLUS,x);
		simplifyable7 = new Binary(x,Operator.MULT,Entier.ZERO);
		simplifyable8 = new Binary(x,Operator.MULT,Entier.UN);
		simplifyable9 = new Binary(Entier.ZERO,Operator.DIV,x);
		
		otherOperatorBin = new Binary(x, otherOperator, Entier.UN);
		
		equalZero = new Binary(cinq, Operator.MOINS, cinq);
		complexSimplifyable = new Binary(
				new Binary(equalZero, Operator.MULT, simpleMult),
				Operator.PLUS,
				simplifyable5
		);
		
		c = new Binary(simplifyable4,Operator.PLUS,simplifyable5);
	}
	
	@Test
	public void testBinary() {
		Assert.assertEquals(b1.getLeft(), x);
		Assert.assertFalse(b1.getRight().equals(y));
	}

	@Test
	public void testGetLeft() {
		Assert.assertTrue(simplifyable4.getLeft() == x);
	}

	@Test
	public void testGetRight() {
		Assert.assertTrue(simplifyable4.getRight().isZero());
	}

	@Test
	public void testGetOp() {
		Assert.assertFalse(simplifyable4.getOp().getName().equals("-"));
		Assert.assertTrue(simplifyable4.getOp().getName().equals("+"));
	}

	@Test
	public void testToString() {
		Assert.assertEquals("(x + 0)", simplifyable4.toString());
	}

	@Test
	public void testIsComputable() {
		Assert.assertFalse(simplifyable4.isComputable());
		Assert.assertTrue(exp4.isComputable());
	}

	@Test
	// exemple interessant passage du niveau methode
	// au niveau instructions est instructifs
	public void testCompute() {
		Assert.assertTrue(exp4.compute() == 9);
		Assert.assertTrue(exp7.compute() == 27);
		Assert.assertTrue(new Binary(exp4,Operator.MOINS,exp).compute() == 6);
		Assert.assertTrue(new Binary(exp4,Operator.DIV,exp).compute() == 3);
	}

	@Test
	public void testIsZero() {
		Assert.assertFalse(exp4.isZero());
	}

	@Test
	public void testIsUnit() {
		Assert.assertFalse(exp4.isUnit());
	}

	@Test
	public void testOneReduction() {
		/// 3+6 = 9
		Assert.assertEquals("9", exp4.oneReduction().toString());
		// (3+6)*(1+2) = 27
		Assert.assertEquals("27", exp7.oneReduction().toString());
		// 1*x = x
		Assert.assertEquals(simplifyable1.oneReduction(), x);
		// 0*x = 0
		Assert.assertEquals(simplifyable2.oneReduction(), Entier.ZERO);
		// x/1 = x
		Assert.assertEquals(simplifyable3.oneReduction(), x);
		// x+0 = x
		Assert.assertEquals(simplifyable4.oneReduction(), x);
		// z-0 = z
		Assert.assertEquals(simplifyable5.oneReduction(), z);
		// 0+x = x
		Assert.assertEquals(simplifyable6.oneReduction(), x);
		// x*0 = 0
		Assert.assertEquals(simplifyable7.oneReduction(), Entier.ZERO);
		// x*1 = x
		Assert.assertEquals(simplifyable8.oneReduction(), x);
		// 0/x = 0
		Assert.assertEquals(simplifyable9.oneReduction(), Entier.ZERO);
		// Non-simplifyable additions
		Assert.assertEquals(simpleAdd1.oneReduction(), simpleAdd1);
		Assert.assertEquals(simpleAdd2.oneReduction(), simpleAdd2);
		// Non-simplifyable substractions
		Assert.assertEquals(simpleSubstract1.oneReduction(), simpleSubstract1);
		Assert.assertEquals(simpleSubstract2.oneReduction(), simpleSubstract2);
		// Non-simplifyable multiplication
		Assert.assertEquals(simpleMult.oneReduction(), simpleMult);
		// Non-simplifyable division
		Assert.assertEquals(simpleDiv.oneReduction(), simpleDiv);
		// Operation with an unknown operator
		Assert.assertEquals(otherOperatorBin.oneReduction(), otherOperatorBin);
	}
	

	@Test
	public void testEngine() {
		Assert.assertEquals(simplifyable1.engine(), x);
		Assert.assertEquals(simplifyable2.engine(), Entier.ZERO);
		Assert.assertEquals(simplifyable3.engine(), x);
		Assert.assertEquals(simplifyable4.engine(), x);
		Assert.assertEquals(simplifyable5.engine(), z);
		Assert.assertEquals(complexSimplifyable.engine(), z);
	}

}
