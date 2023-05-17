package boundaries;

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
	public boolean enoughtIngredients(HashMap<String,Double> recette, int qty,JTable jtable) {
		controlCuisiner.setJTable(jtable);
		return controlCuisiner.enoughtIngredients(recette, qty);
	}
	
	//Dépense les ingredients

}
