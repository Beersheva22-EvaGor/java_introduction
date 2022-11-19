import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
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
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		assertEquals(5, hello.length());
	}

	@Test
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
		assertFalse(Strings.isAnagram(word,""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word,"yello"));
		assertFalse(Strings.isAnagram(word,"yelllo"));
	}

	@Test
	void sortStringNumbersTest() {
		String[] strNumArr = {Integer.toString(Byte.MAX_VALUE),"24", "-10", "78", "0", "11", "24", "-100", "-100", Integer.toString(Byte.MIN_VALUE)};
		Strings.sortStringNumbers(strNumArr);
		assertArrayEquals(new String[]{Integer.toString(Byte.MIN_VALUE), "-100", "-100", "-10",  "0", "11", "24", "24", "78", Integer.toString(Byte.MAX_VALUE) }, strNumArr);
	}
}
