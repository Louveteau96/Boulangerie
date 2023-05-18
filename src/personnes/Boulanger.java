package personnes;
import batiment.*;
import java.util.HashMap;

public class Boulanger implements Employe{
	private Boulangerie boulangerie;
	private String nom;
	HashMap<String,HashMap<String,Double>> recettes = new HashMap<>();
	HashMap<String,Double> recetteBaguette = new HashMap<>();
	HashMap<String,Double> recetteChocolatine = new HashMap<>();
	HashMap<String,Double> recetteCroissant = new HashMap<>();
	HashMap<String, Integer> produitCuisine = new HashMap<>();
	
	//Le constructeur
	public Boulanger(Boulangerie boulangerie, String nom){
		this.boulangerie = boulangerie;
		this.nom = nom;
		//Initialisation de la recette de la baguette
		recetteBaguette.put(FARINE, 0.1635);
		recetteBaguette.put(LEVURE, 0.00375);
		recetteBaguette.put(SEL, 0.00333);
		recetteBaguette.put(SUCRE, 0.00166);
		
		//Initialisation de la recette de la chocolatine
		recetteChocolatine.put(BEURRE, 0.055);
		recetteChocolatine.put(CHOCOLAT, 0.01066);
		recetteChocolatine.put(FARINE, 0.125);
		recetteChocolatine.put(LAIT, 0.7);
		recetteChocolatine.put(LEVURE, 0.025);
		recetteChocolatine.put(OEUF, 0.5);
		recetteChocolatine.put(SEL, 0.0025);
		recetteChocolatine.put(SUCRE, 0.010);
		
		//Initialisation de la recette de la chocolatine
		recetteCroissant.put(BEURRE, 0.042);
		recetteCroissant.put(FARINE, 0.084);
		recetteCroissant.put(LAIT, 0.0467);
		recetteCroissant.put(LEVURE, 0.0034);
		recetteCroissant.put(OEUF, 0.2);
		recetteCroissant.put(SEL, 0.0017);
		recetteCroissant.put(SUCRE, 0.01);
		
		//Mise des recettes dans la liste de recettes
		recettes.put(BAGUETTE,recetteBaguette);
		recettes.put(CHOCOLATINE,recetteChocolatine);
		recettes.put(CROISSANT,recetteCroissant);
		
		//Initialisation des produits Cuisinés
		produitCuisine.put(BAGUETTE, 0);
		produitCuisine.put(CHOCOLATINE, 0);
		produitCuisine.put(CROISSANT, 0);

	}

	//Le boulanger donne sa map de produits cuisinés
	@Override
	public HashMap<String, Integer> getProductDone(){
		return this.produitCuisine;
	}
	
	
	//Métier du boulanger
	@Override
	public String metier() {
		return "boulanger";
	}
	
	//Getteur de ses recettes
	@Override
	public HashMap<String,Double> getRecipe(String nomRecette) {
		nomRecette = nomRecette.toLowerCase();
		switch (nomRecette) {
		case "baguette": {
			return recetteBaguette;
		}
		case "chocolatine":{
			return recetteChocolatine;
		}
		default:
			return recetteCroissant;
		}
	}

}
