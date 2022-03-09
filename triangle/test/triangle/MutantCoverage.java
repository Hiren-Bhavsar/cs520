package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

public class MutantCoverage {

	@Test
	public void testDefaultConstructor() {
		Triangle t = new Triangle();
	}

	@Test
	public void testSmallestTriangle() {
		Type actual = Triangle.classify(1, 1, 1);
		Type expected = EQUILATERAL;
		assertEquals(actual, expected);
	}

	@Test
	public void testAllZero() {
		Type actual = Triangle.classify(0, 0, 0);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testNegativeAB() {
		Type actual = Triangle.classify(-1, -1, -5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testNegativeAC() {
		Type actual = Triangle.classify(-1, -5, -1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testNegativeBC() {
		Type actual = Triangle.classify(-5, -1, -1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneMultiPassAB() {
		Type actual = Triangle.classify(3, 4, 8);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneMultiPassAC() {
		Type actual = Triangle.classify(3, 8, 4);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneMultiPassBC() {
		Type actual = Triangle.classify(8, 4, 3);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneABEqualC() {
		Type actual = Triangle.classify(3, 4, 7);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneACEqualB() {
		Type actual = Triangle.classify(3, 7, 4);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidScaleneBCEqualA() {
		Type actual = Triangle.classify(7, 4, 3);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testValidScaleneLargeA() {
		Type actual = Triangle.classify(5, 4, 3);
		Type expected = SCALENE;
		assertEquals(actual, expected);
	}

	@Test
	public void testValidScaleneLargeB() {
		Type actual = Triangle.classify(4, 5, 3);
		Type expected = SCALENE;
		assertEquals(actual, expected);
	}

	@Test
	public void testValidScaleneLargeC() {
		Type actual = Triangle.classify(3, 4, 5);
		Type expected = SCALENE;
		assertEquals(actual, expected);
	}

	@Test
	public void testValidIsoscelesLargeC() {
		Type actual = Triangle.classify(5, 5, 8);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}

	@Test
	public void testValidIsoscelesLargeA() {
		Type actual = Triangle.classify(8, 5, 5);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}

	@Test
	public void testValidIsoscelesLargeB() {
		Type actual = Triangle.classify(5, 8, 5);
		Type expected = ISOSCELES;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesABEqualC() {
		Type actual = Triangle.classify(5, 5, 10);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesACEqualB() {
		Type actual = Triangle.classify(5, 10, 5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesBCEqualA() {
		Type actual = Triangle.classify(10, 5, 5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesNegativeA() {
		Type actual = Triangle.classify(-1, 5, 5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesNegativeB() {
		Type actual = Triangle.classify(5, -1, 5);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}

	@Test
	public void testInvalidIsoscelesNegativeC() {
		Type actual = Triangle.classify(5, 5, -1);
		Type expected = INVALID;
		assertEquals(actual, expected);
	}
}
