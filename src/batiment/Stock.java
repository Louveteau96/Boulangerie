package batiment;

import java.util.HashMap;

public abstract class Stock {
	HashMap<String,Double> qtyProduit = new HashMap<>();
	HashMap<String,Double> prixProduit = new HashMap<>();
	HashMap<String,String> uniteProduit = new HashMap<>();
	StringBuilder inventaire = new StringBuilder();
	
	//Les méthodes de qtyProduit
	public double getQty(String produit) {
		return qtyProduit.get(produit);
	}
	private void setQty(String produit, double qty) {
		qtyProduit.put(produit, qty);
	}
			
	//La méthode de prixProduit
	private double getPrix(String produit) {
		return prixProduit.get(produit);
	}
	
	//La méthode de uniteProduit
	private String getUnite(String produit) {
		return uniteProduit.get(produit);
	}
	
	//La méthode d'ajout de Produit
	public void ajouterQty(String produit, double qty) {
		qtyProduit.put(produit, qtyProduit.get(produit)+qty);
	}
	//La méthode dépense de Produit
	public void depenseQty(String produit, double qty) {
		qtyProduit.put(produit, qtyProduit.get(produit)-qty);
	}
	
	//La méthode faire l'inventaire
	private StringBuilder faireInventaire() {
		inventaire.append("Il y a : \n");
		for (HashMap.Entry<String, Double> entry : qtyProduit.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			String unite = uniteProduit.get(key);
			inventaire.append("- "+key+" : "+val.toString()+" "+unite+"\n");
		}
		return inventaire;
	}
}

