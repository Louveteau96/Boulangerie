package batiment;

import java.util.HashMap;

public class Boulangerie {
	private String nom;
	private Reserve reserve;
	private Caisse caisse;
	private Etalage etalage;
	
	public Boulangerie(String nom){
		this.reserve = new Reserve();
		this.etalage = new Etalage();
		this.caisse = new Caisse();
		this.nom=nom;

	}
	
	public void Bienvenue() {
		String texte = "Bienvenue à : " + this.nom + ".\n";
		System.out.println(texte);
	}
	
	
//=====================================================================//
//					La reserve est une classe interne			   	   //
//=====================================================================//
	
	
	private static class Reserve{
		HashMap<String,Integer> qtyIngredient = new HashMap<>();
		HashMap<String,Double> prixIngredient = new HashMap<>();
		HashMap<String,String> uniteIngredient = new HashMap<>();
		
		public static final String BEURRE = "beurre";
		public static final String CHOCOLAT = "chocolat";
		public static final String FARINE = "farine";
		public static final String LAIT = "lait";
		public static final String LEVURE = "levure";
		public static final String OEUF = "oeuf";
		public static final String SEL = "sel";
		public static final String SUCRE = "sucre";
		public static final String KILOGRAMMES = "kilogrammes";
		
		
		private Reserve() {
			//Initialisation des éléments de qtyIngredient
			qtyIngredient.put(BEURRE, 0);
			qtyIngredient.put(CHOCOLAT, 0);
			qtyIngredient.put(FARINE, 0);
			qtyIngredient.put(LAIT, 0);
			qtyIngredient.put(LEVURE, 0);
			qtyIngredient.put(OEUF, 0);
			qtyIngredient.put(SEL, 0);
			qtyIngredient.put(SUCRE, 0);
			
			//Initialisation des éléments de prixIngredient
			prixIngredient.put(BEURRE, 7.55);
			prixIngredient.put(CHOCOLAT, 8.0);
			prixIngredient.put(FARINE, 1.0);
			prixIngredient.put(LAIT, 1.24);
			prixIngredient.put(LEVURE, 8.42);
			prixIngredient.put(OEUF, 0.34);
			prixIngredient.put(SEL, 0.57);
			prixIngredient.put(SUCRE, 0.85);
			
			//Initialisation des éléments de uniteIngredient
			uniteIngredient.put(BEURRE, KILOGRAMMES);
			uniteIngredient.put(CHOCOLAT, KILOGRAMMES);
			uniteIngredient.put(FARINE, KILOGRAMMES);
			uniteIngredient.put(LAIT, "litres");
			uniteIngredient.put(LEVURE, KILOGRAMMES);
			uniteIngredient.put(OEUF, "unites");
			uniteIngredient.put(SEL, KILOGRAMMES);
			uniteIngredient.put(SUCRE, KILOGRAMMES);

		}
		
		//Les méthodes de qtyIngredient
		private int getQty(String ingredient) {
			return qtyIngredient.get(ingredient);
		}
		private void setQty(String ingredient, int qty) {
			qtyIngredient.put(ingredient, qty);
		}
		
		//La méthode de prixIngredient
		private double getPrix(String ingredient) {
			return prixIngredient.get(ingredient);
		}
		
		//La méthode de uniteIngredient
		private String getUnite(String ingredient) {
			return uniteIngredient.get(ingredient);
		}
		
		
	}
	
	
//=====================================================================//
// 				L'étalage est une classe interne	   		   	       //
//=====================================================================//
	private static class Etalage{
		HashMap<String,Integer> qtyProduit = new HashMap<>();
		HashMap<String,Double> prixProduit = new HashMap<>();
		
		public static final String BAGUETTE = "baguette";
		public static final String CHOCOLATINE = "chocolatine";
		public static final String CROISSANT = "croissant";
		
		
		private Etalage() {
			//Initialisation de qtyProduit
			qtyProduit.put(BAGUETTE, 0);
			qtyProduit.put(CHOCOLATINE, 0);
			qtyProduit.put(CROISSANT, 0);
			
			//Initialisation de prixProduit
			prixProduit.put(BAGUETTE, 1.0);
			prixProduit.put(CHOCOLATINE, 7.55);
			prixProduit.put(CROISSANT, 8.0);
		}
		
		//Les méthodes de qtyIngredient
		private int getQty(String produit) {
			return qtyProduit.get(produit);
		}
		private void setQty(String produit, int qty) {
			qtyProduit.put(produit, qty);
		}
		
		//La méthode de prixIngredient
		private double getPrix(String produit) {
			return prixProduit.get(produit);
		}
	}
	

	
//=====================================================================//
//			 	La caisse est une classe interne	   		   	       //
//=====================================================================//
	
	private static class Caisse{
		private double argent;
		
		
		private Caisse() {
			this.argent=0;
		}
		
		//Les méthodes de la caisse
		private double getArgent() {
			return this.argent;
		}
		
		private void gagnerArgent(double gain) {
			this.argent+=gain;
		}
		
		private void perdreArgent(double perte) {
			this.argent-=perte;
		}
		
		private boolean enoughtFunds(double perte) {
			return this.argent-perte >=0;
		}
	}

}
