package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

public class BranchCoverage {

	@Test
	public void testDefaultConstructor() {
		Triangle t = new Triangle();
	}

	@Test
	public void testInvalidNegativeA() {
		Type actual = Triangle.classify(-3, 5, 4);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidNegativeB() {
		Type actual = Triangle.classify(3, -5, 4);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidNegativeC() {
		Type actual = Triangle.classify(3, 5, -4);
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

	@Test
	public void testInvalidScaleneLargeA() {
		Type actual = Triangle.classify(10, 1, 2);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneLargeB() {
		Type actual = Triangle.classify(1, 10, 2);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneLargeC() {
		Type actual = Triangle.classify(1, 2, 10);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesAB() {
		Type actual = Triangle.classify(1, 1, 10);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesAC() {
		Type actual = Triangle.classify(1, 10, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesBC() {
		Type actual = Triangle.classify(10, 1, 1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
}
