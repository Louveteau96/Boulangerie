package controleurTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.Boulangerie;
import controleur.ControlVente;

class ControlVenteTest {
	private ControlVente control;
	private Boulangerie boulangerie;

	@BeforeEach
	void setUp(){
		Boulangerie boulangerie1 = new Boulangerie("Boulangerie");
		this.boulangerie=boulangerie1;
		this.control = new ControlVente(boulangerie1);
	}

	@Test
	void testControlVente() {
		assertNotNull(control);
	}

	@Test
	void testGetPrice() {
		assertEquals(control.getPrice(0, 0, 1), 1);
		assertEquals(control.getPrice(1, 0, 1), 8.55);
		assertEquals(control.getPrice(0, 1, 0), 8.0);
		assertNotEquals(control.getPrice(0, 0, 1), 10.0);
		assertNotEquals(control.getPrice(0, 0, 1), 0.0);
	}

	@Test
	void testPerdreArgent() {
		boulangerie.gagnerArgent(10);
		control.perdreArgent(0);
		assertEquals(boulangerie.afficherArgent(), 10.0);
		control.perdreArgent(5.2);
		assertEquals(boulangerie.afficherArgent(), 4.8);
	}

	@Test
	void testEnoughtArgent() {
		boulangerie.gagnerArgent(10);
		assertTrue(control.enoughtArgent(5.2));
		assertTrue(control.enoughtArgent(10));
		assertFalse(control.enoughtArgent(100));
	}

}
