package controleurTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controleur.ControlVerifContent;

class ControlVerifContentTest {
	private ControlVerifContent control;

	@BeforeEach
	void setUp(){
		this.control = new ControlVerifContent();
	}

	@Test
	void testTestDouble() {
		assertFalse(control.testDouble("a"));
		assertFalse(control.testDouble("0"));
		assertFalse(control.testDouble("1.2.3"));
		assertTrue(control.testDouble("10"));
		assertTrue(control.testDouble("2.3"));
	}

	@Test
	void testTestInteger() {
		assertFalse(control.testInteger("a"));
		assertFalse(control.testInteger("0"));
		assertFalse(control.testInteger("1.2.3"));
		assertFalse(control.testInteger("1.2"));
		assertTrue(control.testInteger("1"));
	}

}
