package boundaries;

import java.util.HashMap;
import java.util.Scanner;

import controleur.ControlAcheterIngredients;


public class BoundaryAcheterIngredient {
	private ControlAcheterIngredients controlAcheterIngredient;
	private Scanner scan = new Scanner(System.in);
	
	public BoundaryAcheterIngredient(ControlAcheterIngredients controlAcheterIngredient) {
		this.controlAcheterIngredient = controlAcheterIngredient;
	}
	
	public int acheterIngredients(String ingredient, Double qty) {
		if(controlAcheterIngredient.ingredientExist(ingredient)) {
			if(controlAcheterIngredient.enoughtFunds(ingredient, qty)) {
				return 2;
			}else {
				return 1;
			}
		}else {
			return 0;
		}
		
	}
	
	public void obtentionIngredients(String ingredient, double qty) {
		controlAcheterIngredient.obtenirIngredients(ingredient, qty);
		controlAcheterIngredient.depenserArgent(ingredient, qty);
	}


}
