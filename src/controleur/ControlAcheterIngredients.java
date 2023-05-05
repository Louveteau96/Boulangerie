package controleur;

import batiment.*;

public class ControlAcheterIngredients {
	private Boulangerie boulangerie;
	
	public ControlAcheterIngredients(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}
	
	//La méthode pour savoir il y a assez d'argent pour acheter une quantité d'ingrédients
	public boolean enoughtFunds(String ingredient, double qty) {
		double perte = boulangerie.prixIngredient(ingredient)*qty;
		return (boulangerie.enoughtFunds(perte));
	}
	
	//Vérifie que l'ingrédient demandé existe
	public boolean ingredientExist(String ingredient) {
		ingredient = ingredient.toLowerCase();
		return boulangerie.ingredientExiste(ingredient);
	}

}
