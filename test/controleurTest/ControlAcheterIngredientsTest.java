package controleurTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.Boulangerie;
import controleur.ControlAcheterIngredients;

class ControlAcheterIngredientsTest {
	private ControlAcheterIngredients control;
	private Boulangerie boulangerie;

	@BeforeEach
	void setUp(){
		Boulangerie boulangerie = new Boulangerie("Boulangerie");
		control = new ControlAcheterIngredients(boulangerie);
		this.boulangerie=boulangerie;
		
	}

	@Test
	void testControlAcheterIngredients() {
		assertNotNull(control,"control null");
	}

	@Test
	void testEnoughtFundsWithNoFunds() {
		assertTrue(control.enoughtFunds("farine", 0),"On a assez pour acheter 0 farine");
		assertFalse(control.enoughtFunds("farine", 10),"On a pas l'argent pour acheter 10 farine");
		
	}
	
	@Test
	void testEnoughtFundsWithFunds() {
		boulangerie.gagnerArgent(50);
		control = new ControlAcheterIngredients(boulangerie);
		assertTrue(control.enoughtFunds("chocolat", 2),"Il y a l'argent pour acheter le chocolat normalement");
		assertFalse(control.enoughtFunds("oeuf", 200),"Il n'y a pas assez d'argent pour acheter 200 oeufs");
	}

	@Test
	void testIngredientExist() {
		assertTrue(control.ingredientExist("farine"),"La farine est un ingrédient existant");
		assertFalse(control.ingredientExist("eau"),"L'eau n'est pas un ingrédient qui existe");
		assertFalse(control.ingredientExist("farines"),"farines avec un s ne devrait pas exister");
	}

	@Test
	void testObtenirIngredients() {
		boulangerie.gagnerArgent(200);
		control = new ControlAcheterIngredients(boulangerie);
		control.obtenirIngredients("farine", 10.0);
		assertEquals(10.0, boulangerie.getStockMap().get("farine"));
		assertNotEquals(10.0, boulangerie.getStockMap().get("chocolat"));
	}

	@Test
	void testDepenserArgent() {
		boulangerie.gagnerArgent(10);
		control = new ControlAcheterIngredients(boulangerie);
		control.depenserArgent("beurre", 1.0);
		assertEquals(2.45,boulangerie.afficherArgent());
		assertNotEquals(10, boulangerie.afficherArgent());
	}

}
