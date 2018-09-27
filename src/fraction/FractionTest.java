package fraction;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

public class FractionTest {
	/*@Test
	public void testGCD(){  // Test the helper function.
		assertEquals(Fraction.GCD(12, 0), 12);
		assertEquals(Fraction.GCD(12, 9), 3);
		assertEquals(Fraction.GCD(-12, 9), 3);
		assertEquals(Fraction.GCD(-1, 0), 1);
	}*/
	
	@Test
	public void testConstructors(){
		assertEquals("3/5", new Fraction(3, 5).toString() );
		assertEquals("3", new Fraction(3).toString());
		assertEquals("0", new Fraction("0/-2").toString());
		assertEquals("-2/3", new Fraction("8   / -12").toString());
		assertEquals(new Fraction(0, 100), new Fraction(0));
		assertEquals(new Fraction("3/ 4"), new Fraction(6, 8));
		assertEquals(new Fraction(-3, 4), new Fraction(6, -8));
		assertEquals(new Fraction(0/2), 0);
		//assertEquals(new Fraction(1/3), new Fraction(1, 3));
		assertEquals(new Fraction(" +   1/1"), new Fraction(1));
	}
	
	@Test
	public void testAdd(){
		assertEquals(new Fraction(2, 3).add(new Fraction("8/  -12")), 0);
		assertEquals(new Fraction(7).add(new Fraction(" 8 /  -1 ")), -1);
	}
	
	@Test
	public void testSubtract(){
		assertEquals(new Fraction(2, 3).subtract(new Fraction("8/  12")), 0);
		assertEquals(new Fraction(0).subtract(new Fraction("1/  1")), -1);
	}
	
	@Test
	public void testMultiply(){
		assertEquals(new Fraction(2, 3).multiply(new Fraction("12/  -   8")), -1);
		assertEquals(new Fraction(2, 3).multiply(new Fraction("12/  +  8")), 1);
	}
	
	@Test
	public void testDivide(){
		assertEquals(new Fraction("-1").divide(new Fraction("1")), -1);
		assertEquals(new Fraction(-3).divide(new Fraction(" -  3  /  + 1")), 1);
	}
	
	@Test
	public void testAbs(){
		assertEquals(new Fraction("-1").abs(), new Fraction(" +   1"));
	}
	
	@Test
	public void testNegate(){
		assertEquals(new Fraction("-  12/  8").negate(), new Fraction("3/2"));
		assertEquals(new Fraction("-  12/  8").negate(), new Fraction(3, 2));
		assertEquals(new Fraction("0/12").negate(), new Fraction(0, 1));
	}
	
	@Test
	public void testEqual(){
		assertTrue(new Fraction("- 12/3").equals(-4));
	}
	
	@Test
	public void testCompareTo(){
		assertTrue(new Fraction("12/  -8").compareTo(12) < 0);
		assertTrue(new Fraction("12/  8").compareTo(-1) > 0);
	}
	
	@Test
	public void testInverse(){
		assertEquals(new Fraction("-  12/  8").inverse(), new Fraction("-2/3"));
		assertEquals(new Fraction("+  12/  - 8").inverse(), new Fraction(-2, 3));
	}
	
	@Test
	public void testToString(){
		assertEquals(new Fraction(" - 13/23").toString(), "-13/23");
	}
	
	@Test(expected = ArithmeticException.class)
	public void testArithmeticException() {
		new Fraction("-1").divide(new Fraction("0000/12"));
		new Fraction("0/1").inverse();
		new Fraction(0).inverse();
	}
	
	@Test(expected = NumberFormatException.class)
	public void testMalformedInput() {
		 new Fraction("123abc");
	     new Fraction("- /");
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testIndex(){
		new Fraction("////");
	}
}
