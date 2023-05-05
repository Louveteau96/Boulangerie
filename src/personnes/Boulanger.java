package personnes;
import produits.*;
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
	
	public static final String BEURRE = "beurre";
	public static final String CHOCOLAT = "chocolat";
	public static final String FARINE = "farine";
	public static final String LAIT = "lait";
	public static final String LEVURE = "levure";
	public static final String OEUF = "oeuf";
	public static final String SEL = "sel";
	public static final String SUCRE = "sucre";
	
	public static final String BAGUETTE = "baguette";
	public static final String CHOCOLATINE = "chocolatine";
	public static final String CROISSANT = "croissant";
	

	
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
	
	//Le boulanger cuisine une quantité de produit
	public void ConsommerIngredients(String recette,int qty) {
		for (HashMap.Entry<String, Double> entry : recettes.get(recette).entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue()*qty;
			this.boulangerie.depenseIngredient(key,val);
		}
		double qtyProduit = 0.0 + qty;
		this.boulangerie.ajoutProduit(recette, qtyProduit);
		produitCuisine.put(recette, produitCuisine.get(recette)+qty);
	}
	
	//Le récap de produits cuisinés par le boulanger
	public StringBuilder recapitulatif() {
		StringBuilder recap = new StringBuilder();
		recap.append("Moi "+nom+" j'ai cuisiné : \n");
		for (HashMap.Entry<String, Integer> entry : produitCuisine.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			recap.append(key + " : " +val + "\n");
		}
		return recap;
	}
	

	


	@Override
	public void afficher(String texte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int QuelIngredient() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int QuelleNourriture() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double QuelleQtyDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int QuelleQtyInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void acheterIngredients() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boulangerie getBoulangerie() {
		// TODO Auto-generated method stub
		return null;
	}

}
