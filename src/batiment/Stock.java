package batiment;

import java.util.HashMap;

public abstract class Stock {
	HashMap<String,Integer> qtyProduit = new HashMap<>();
	HashMap<String,Double> prixProduit = new HashMap<>();
	
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

