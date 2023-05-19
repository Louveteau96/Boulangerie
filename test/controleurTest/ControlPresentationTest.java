package controleurTest;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.Boulangerie;
import controleur.ControlPresentation;
import personnes.Boulanger;

class ControlPresentationTest {
	private ControlPresentation control;
	private Boulangerie boulangerie;

	@BeforeEach
	void setUp(){
		Boulangerie boulangerie = new Boulangerie("Boulangerie");
		this.boulangerie=boulangerie;
		control = new ControlPresentation(boulangerie);
	}

	@Test
	void testControlPresentation() {
		assertNotNull(control,"control null");
	}

	@Test
	void testBienvenue() {
		assertNotNull(control.bienvenue());
		assertEquals(control.bienvenue(), "Bienvenue à : Boulangerie");
	}

	@Test
	void testVerifierNom() {
		boulangerie.addEmploye(new Boulanger(boulangerie,"jose"), "jose");
		assertTrue(control.verifierNom("jose"));
		assertFalse(control.verifierNom("marc"));
		
	}

}
