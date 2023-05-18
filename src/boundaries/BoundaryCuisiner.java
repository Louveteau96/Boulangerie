package boundaries;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import controleur.ControlCuisiner;

public class BoundaryCuisiner {
	private ControlCuisiner controlCuisiner;
	
	public BoundaryCuisiner(ControlCuisiner controlCuisiner) {
		this.controlCuisiner = controlCuisiner;
	}
	
	//Les méthodes
	
	//Colorie les cases et dit si il y a assez d'ingredients
	public boolean enoughtIngredients(HashMap<String,Double> recette, int qty,ArrayList<JTable> tables) {
		controlCuisiner.setJTable(tables);
		return controlCuisiner.enoughtIngredients(recette, qty);
	}
	
	//Dépense les ingredients
	public void depenserIngredients(HashMap<String,Double> recette, int qty) {
		controlCuisiner.useIngredients(recette, qty);
	}

}
