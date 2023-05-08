package boundaries;

import java.util.Scanner;

import controleur.ControlAcheterIngredients;


public class BoundaryAcheterIngredient {
	private ControlAcheterIngredients controlAcheterIngredient;
	private Scanner scan = new Scanner(System.in);
	
	public BoundaryAcheterIngredient(ControlAcheterIngredients controlAcheterIngredient) {
		this.controlAcheterIngredient = controlAcheterIngredient;
	}
	
	public void acheterIngredients() {
		StringBuilder message = new StringBuilder();
		message.append("Que voulez-vous acheter ?");
		System.out.println(message);
		String ingredient = scan.nextLine();
		
		if(controlAcheterIngredient.ingredientExist(ingredient)) {
			Double qty = scan.nextDouble();
			
			if(controlAcheterIngredient.enoughtFunds(ingredient, qty)) {
			}
		}else {
			message.setLength(0);
			message.append("Désolé mais ce produit n'existe pas");
			System.out.println(message);
		}
		
	}


}
