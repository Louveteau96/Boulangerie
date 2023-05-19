package controleurTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batiment.Boulangerie;
import controleur.ControlCuisiner;

class ControlCuisinerTest {
	private ControlCuisiner control;
	private Boulangerie boulangerie;
	private HashMap<String,Double> recetteBaguette;
	private HashMap<String,Double> recetteChocolatine;

	@BeforeEach
	void setUp(){
		this.boulangerie = new Boulangerie("La boulangerie");
		this.control = new ControlCuisiner(boulangerie);
		
		boulangerie.ajouterIngredient("farine", 10.0);
		boulangerie.ajouterIngredient("levure", 10.0);
		boulangerie.ajouterIngredient("sucre", 10.0);
		boulangerie.ajouterIngredient("sel", 10.0);
		
		HashMap<String,Double> recetteBaguette = new HashMap<>();
		HashMap<String,Double> recetteChocolatine = new HashMap<>();
		recetteBaguette.put("farine", 0.1635);
		recetteBaguette.put("levure", 0.00375);
		recetteBaguette.put("sucre", 0.00333);
		recetteBaguette.put("sel", 0.00166);
		
		recetteChocolatine.put("chocolat", 1.0);
		this.recetteBaguette=recetteBaguette;
		this.recetteChocolatine=recetteChocolatine;
		
		ArrayList<JTable> table = new ArrayList<JTable>();
		JTable table0 = new JTable();
		JTable table1 = new JTable();
		JTable table2 = new JTable();
		JTable table3 = new JTable();
		JTable table4 = new JTable();
		JTable table5 = new JTable();
		JTable table6 = new JTable();
		JTable table7 = new JTable();
		table.add(table0);
		table.add(table1);
		table.add(table2);
		table.add(table3);
		table.add(table4);
		table.add(table5);
		table.add(table6);
		table.add(table7);
		
		control.setJTable(table);
	}

	@Test
	void testControlCuisiner() {
		assertNotNull(control,"control null");
	}

	@Test
	void testSetJTable() {
		ArrayList<JTable> table = new ArrayList<JTable>();
		control.setJTable(table);
		assertNotNull(control.getTable(),"tables null");
	}

	@Test
	void testEnoughtIngredients() {
		assertTrue(control.enoughtIngredients(recetteBaguette, 1));
		assertTrue(control.enoughtIngredients(recetteChocolatine, 0));
		assertFalse(control.enoughtIngredients(recetteChocolatine, 1));
	}

	@Test
	void testUseIngredients() {
		boulangerie.ajouterIngredient("chocolat", 10.0);
		control.useIngredients(recetteBaguette, 1);
		assertTrue(boulangerie.getStockMap().get("farine") != 10.0);
		assertFalse(boulangerie.getStockMap().get("levure") == 10.0);
		assertTrue(boulangerie.getStockMap().get("chocolat") == 10.0);
	}

	@Test
	void testColorCase() {
		control.resetColors();
		control.colorCase("farine", true);
		control.colorCase("chocolat", false);
		assertTrue(control.getTable().get(2).getBackground()==Color.green);
		assertTrue(control.getTable().get(3).getBackground()==Color.red);
		assertTrue(control.getTable().get(1).getBackground()==Color.white);
		assertFalse(control.getTable().get(4).getBackground()==Color.red);
	}

	@Test
	void testResetColors() {
		control.colorCase("farine", true);
		control.colorCase("chocolat", false);
		control.resetColors();
		assertTrue(control.getTable().get(2).getBackground()==Color.white);
		assertFalse(control.getTable().get(3).getBackground()==Color.red);
	}

}
