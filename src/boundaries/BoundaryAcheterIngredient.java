package boundaries;

import batiment.Boulangerie;
import controleur.ControlAcheterIngredients;


public class BoundaryAcheterIngredient {
	private ControlAcheterIngredients controlAcheterIngredient;
	
	public BoundaryAcheterIngredient(Boulangerie boulangerie) {
		this.controlAcheterIngredient = new ControlAcheterIngredients(boulangerie);
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
