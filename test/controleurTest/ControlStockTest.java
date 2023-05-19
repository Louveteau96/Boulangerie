package controleurTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.Boulangerie;
import controleur.ControlGestionEmploye;
import controleur.ControlStock;

class ControlStockTest {
	private ControlStock control;
	private ControlGestionEmploye controlEmploye;
	private Boulangerie boulangerie;

	@BeforeEach
	void setUp(){
		Boulangerie boulangerie1 = new Boulangerie("Boulangerie");
		this.boulangerie=boulangerie1;
		this.control = new ControlStock(boulangerie);
		this.controlEmploye = new ControlGestionEmploye(boulangerie1);
	}

	@Test
	void testControlStock() {
		assertNotNull(control,"control null");
	}

	@Test
	void testGetStockMap() {
		HashMap<String,Double> emptyMap = new HashMap<>();
		assertEquals(control.getStockMap(), boulangerie.getStockMap());
		assertNotEquals(control.getStockMap(), emptyMap);
	}

	@Test
	void testGetStockUnite() {
		HashMap<String,Double> emptyMap = new HashMap<>();
		assertNotEquals(control.getStockMap(), emptyMap);
		assertEquals(control.getStockUnite(), boulangerie.getStockUnite());
	}

	@Test
	void testGetEtalageMap() {
		HashMap<String,Double> emptyMap = new HashMap<>();
		assertNotEquals(control.getEtalageMap(), emptyMap);
		assertEquals(control.getEtalageMap(), boulangerie.getEtalageMap());
	}

	@Test
	void testGetProductDone() {
		HashMap<String,Double> emptyMap = new HashMap<>();
		HashMap<String,Integer> productdone = new HashMap<>();
		productdone.put("baguette", 1);
		productdone.put("chocolatine", 0);
		productdone.put("croissant", 0);
		controlEmploye.ajouterEmploye("jose", "boulanger");
		controlEmploye.addProductsDone(productdone, "jose");
		assertNotEquals(control.getProductDone("jose"), emptyMap);
		assertEquals(control.getProductDone("jose"),productdone);
	}

	@Test
	void testEnoughtProducts() {
		boulangerie.ajoutProduit("baguette", 1.0);
		assertTrue(control.enoughtProducts("baguette", 1));
		assertFalse(control.enoughtProducts("chocolatine", 1));
	}

	@Test
	void testAjouterProduit() {
		assertFalse(control.enoughtProducts("chocolatine", 1));
		control.ajouterProduit("chocolatine", 1);
		assertTrue(control.enoughtProducts("chocolatine", 1));
	}

	@Test
	void testRetirerProduit() {
		control.ajouterProduit("chocolatine", 1);
		control.retirerProduit("chocolatine", 0);
		assertTrue(control.enoughtProducts("chocolatine", 1));
		control.retirerProduit("chocolatine", 1);
		assertFalse(control.enoughtProducts("chocolatine", 1));
	}

	@Test
	void testAjouterMapProduit() {
		HashMap<String,Integer> mapProduit = new HashMap<>();
		mapProduit.put("chocolatine", 1);
		mapProduit.put("baguette", 1);
		mapProduit.put("croissant", 0);
		control.ajouterMapProduit(mapProduit);
		assertNotEquals(boulangerie.getEtalageMap(), mapProduit);
		HashMap<String,Double> mapDouble = new HashMap<>();
		for (HashMap.Entry<String, Integer> entry : mapProduit.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			mapDouble.put(key, val*1.0);
		}
		
		assertEquals(boulangerie.getEtalageMap(), mapDouble);
		
	}

}
