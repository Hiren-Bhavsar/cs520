package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

public class StatementCoverage {

	@Test
	public void testDefaultConstructor() {
		Triangle t = new Triangle();
	}

	@Test
	public void testEquilateral() {
		Type actual = Triangle.classify(10, 10, 10);
		Type expected = EQUILATERAL;
		assertEquals(actual, expected);
	}

	@Test
	public void testScalene() {
		Type actual = Triangle.classify(3, 4, 5);
		Type expected = SCALENE;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidNegative() {
		Type actual = Triangle.classify(-1, 5, 4);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testInvalidPositiveScalene() {
		Type actual = Triangle.classify(1, 2, 10);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testInvalidPositiveIsosceles() {
		Type actual = Triangle.classify(1, 1, 10);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testABEqual() {
		Type actual = Triangle.classify(5, 5, 4);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}

	@Test
	public void testACEqual() {
		Type actual = Triangle.classify(5, 4, 5);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}

	@Test
	public void testBCEqual() {
		Type actual = Triangle.classify(4, 5, 5);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}
}
