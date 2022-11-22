import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {
		Integer a = 11;
		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);

		assertTrue(c.equals(d));
	}

	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		assertEquals(5, hello.length());
	}

	@Test
	@Disabled
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("1 h p", "1hp  "));
		assertTrue(Strings.isAnagram("  1hp", "1hp  "));
		assertTrue(Strings.isAnagram("1231hp", "1h321p"));
		assertTrue(Strings.isAnagram("-6ghj jk", " jkgh-6j"));

		assertFalse(Strings.isAnagram("1h p", "1hp  ")); // different length
		assertFalse(Strings.isAnagram("1h pi", "1hp  ")); // same length different letters

		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));
	}

	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] strNumArr = { Integer.toString(Byte.MAX_VALUE), "24", "-10", "78", "0", "11", "24", "-100", "-100",
				Integer.toString(Byte.MIN_VALUE) };
		Strings.sortStringNumbers(strNumArr);
		assertArrayEquals(new String[] { Integer.toString(Byte.MIN_VALUE), "-100", "-100", "-10", "0", "11", "24", "24",
				"78", Integer.toString(Byte.MAX_VALUE) }, strNumArr);
	}

	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}

	@Test
	void ip4OctetTest() {
		assertTrue("0".matches(Strings.ip4Octet()));
		assertTrue("10".matches(Strings.ip4Octet()));
		assertTrue("25".matches(Strings.ip4Octet()));
		assertTrue("99".matches(Strings.ip4Octet()));
		assertTrue("255".matches(Strings.ip4Octet()));
		assertTrue("155".matches(Strings.ip4Octet()));

		assertFalse("0000".matches(Strings.ip4Octet()));
		assertFalse("256".matches(Strings.ip4Octet()));
		assertFalse("-15".matches(Strings.ip4Octet()));
		assertFalse("-125".matches(Strings.ip4Octet()));
		assertFalse("54j".matches(Strings.ip4Octet()));
	}

	@Test
	void ipV4Test() {
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("0.120.20.255".matches(Strings.ipV4())); 		
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("10.0.0.0".matches(Strings.ipV4()));		
		assertFalse("256.0.0.0".matches(Strings.ipV4()));
		assertFalse("-25.0.0.0".matches(Strings.ipV4()));
		assertFalse("".matches(Strings.ipV4()));
		assertFalse("-25.0.0".matches(Strings.ipV4()));
		assertFalse("256.256.256.256".matches(Strings.ipV4()));
	}
}
