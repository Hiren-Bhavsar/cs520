package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {
	
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
	public void testIsoscelesAB() {
		Type actual = Triangle.classify(5, 5, 4);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIsoscelesInvalidAB() {
		Type actual = Triangle.classify(5, 5, 11);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testIsoscelesAC() {
		Type actual = Triangle.classify(5, 4, 5);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIsoscelesInvalidAC() {
		Type actual = Triangle.classify(5, 11, 5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testIsoscelesBC() {
		Type actual = Triangle.classify(4, 5, 5);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIsoscelesInvalidBC() {
		Type actual = Triangle.classify(11, 5, 5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaPositiveNumbers() {
		Type actual = Triangle.classify(1, 1, 6);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testInvalidViaUniquePositiveNumbersAB() {
		Type actual = Triangle.classify(1, 2, 6);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testInvalidViaUniquePositiveNumbersAC() {
		Type actual = Triangle.classify(1, 6, 2);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testInvalidViaUniquePositiveNumbersBC() {
		Type actual = Triangle.classify(6, 2, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaNegativeA() {
		Type actual = Triangle.classify(-1, 1, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaNegativeB() {
		Type actual = Triangle.classify(1, -1, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaNegativeC() {
		Type actual = Triangle.classify(1, 1, -1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaZeroA() {
		Type actual = Triangle.classify(0, 1, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaZeroB() {
		Type actual = Triangle.classify(1, 0, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidViaZeroC() {
		Type actual = Triangle.classify(1, 1, 0);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidCatchAll() {
		Type actual = Triangle.classify(5, 5, 11);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
}