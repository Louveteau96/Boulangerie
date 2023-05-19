package controleurTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.Boulangerie;
import controleur.ControlGestionEmploye;
import personnes.Employe;

class ControlGestionEmployeTest {
	private ControlGestionEmploye control;
	private Boulangerie boulangerie;
	private HashMap<String,Double> recetteBaguette;

	@BeforeEach
	void setUp(){
		Boulangerie boulangerie = new Boulangerie("Boulangerie");
		this.boulangerie=boulangerie;
		control = new ControlGestionEmploye(boulangerie);	
		
		HashMap<String,Double> recetteBaguette = new HashMap<>();
		recetteBaguette.put("farine", 0.1635);
		recetteBaguette.put("levure", 0.00375);
		recetteBaguette.put("sel", 0.00333);
		recetteBaguette.put("sucre", 0.00166);
		this.recetteBaguette=recetteBaguette;
		
	}

	@Test
	void testControlGestionEmploye() {
		assertNotNull(control,"control null");
	}

	@Test
	void testAjouterEmploye() {
		control.ajouterEmploye("jose", "boulanger");
		HashMap<String,Employe> employeMap = boulangerie.getEmployeMap();
		assertNotNull(employeMap.get("jose"));
		assertNull(employeMap.get("fabrice"));
	}

	@Test
	void testSupprimerEmploye() {
		control.ajouterEmploye("jose", "boulanger");
		control.supprimerEmploye("jose");
		HashMap<String,Employe> employeMap = boulangerie.getEmployeMap();
		assertNull(employeMap.get("jose"));
	}

	@Test
	void testIsEmploye() {
		control.ajouterEmploye("jose", "boulanger");
		assertTrue(control.isEmploye("jose"));
		assertFalse(control.isEmploye("marc"));
	}

	@Test
	void testGetMetier() {
		control.ajouterEmploye("jose", "boulanger");
		assertEquals(control.getMetier("jose"), boulangerie.getEmployeMap().get("jose"));
	}

	@Test
	void testGetRecipe() {
		control.ajouterEmploye("jose", "boulanger");
		assertEquals(control.getRecipe("jose", "baguette"), recetteBaguette);
	}

	@Test
	void testGetProductsDone() {
		control.ajouterEmploye("jose", "boulanger");
		control.ajouterEmploye("marc", "caissier");
		assertEquals(control.getProductsDone("marc"),new HashMap<>());
		HashMap<String,Integer> productsDone = new HashMap<>();
		productsDone.put("baguette", 1);
		control.setProductsDone("jose", productsDone);
		assertNotEquals(control.getProductsDone("jose"), new HashMap<>());
		
	}

	@Test
	void testSetProductsDone() {
		control.ajouterEmploye("jose", "boulanger");
		HashMap<String,Integer> productsDone = new HashMap<>();
		productsDone.put("baguette", 1);
		HashMap<String,Integer> emptyMap = new HashMap<>();
		emptyMap.put("baguette", 0);
		emptyMap.put("croissant", 0);
		emptyMap.put("chocolatine", 0);
		assertEquals(control.getProductsDone("jose"),emptyMap);
		control.setProductsDone("jose", productsDone);
		assertNotEquals(control.getProductsDone("jose"), new HashMap<>());
	}

	@Test
	void testAddProductsDone() {
		control.ajouterEmploye("jose", "boulanger");
		HashMap<String,Integer> productsDone = new HashMap<>();
		productsDone.put("baguette", 1);
		control.addProductsDone(productsDone, "jose");
		assertEquals(control.getMetier("jose").getProductDone().get("baguette"), 1);
	}

}
