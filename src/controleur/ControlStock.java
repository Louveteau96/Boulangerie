package controleur;

import java.util.HashMap;

import personnes.*;
import batiment.Boulangerie;

public class ControlStock {
	private Boulangerie boulangerie;

	public ControlStock(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

	public HashMap<String,Double> getStockMap() {
		return boulangerie.getStockMap();
	}
	
	public HashMap<String,String> getStockUnite() {
		return boulangerie.getStockUnite();
	}
	
	public HashMap<String,Double> getEtalageMap() {
		return boulangerie.getEtalageMap();
	}
	
	public HashMap<String,Integer> getProductDone(String nom){
		return boulangerie.getEmploye(nom).getProductDone();
	}
	
	//Vérifie si il y a assez de produits dans l'étalage
	public boolean enoughtProducts(String produit, int qty) {
		HashMap<String,Double> etaleMap = getEtalageMap();
		Double productStock = etaleMap.get(produit);
		return productStock >= qty;
	}
	
	//Ajoute des produits à l'étalage
	public void ajouterProduit(String nom,double qty) {
		boulangerie.ajoutProduit(nom, qty);
	}


}
