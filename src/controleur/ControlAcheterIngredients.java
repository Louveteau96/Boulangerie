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
	
	//Ajoute la quantité de l'ingrédient au stock
	public void obtenirIngredients(String ingredient, Double qty) {
		boulangerie.ajouterIngredient(ingredient, qty);
	}
	
	//Enleve l'argent à la caisse correspondant a la quantité d'ingrédient voulu
	public void depenserArgent(String ingredient, Double qty) {
		Double perte = boulangerie.prixIngredient(ingredient)*qty;
		boulangerie.perdreArgent(perte);
		
	}
	
}
