package boundaries;

import java.util.HashMap;

import batiment.Boulangerie;
import controleur.ControlStock;

public class BoundaryStock {
	private ControlStock controlStock;

	public BoundaryStock(Boulangerie boulangerie) {
		this.controlStock = new ControlStock(boulangerie);
		
	}
	
	//Les méthodes
	public boolean enoughtProducts(String produit, int qty) {
		return controlStock.enoughtProducts(produit, qty);
	}
	
	public HashMap<String,Double> getStockMap() {
		return controlStock.getStockMap();
	}
	
	public HashMap<String,String> getStockUnite() {
		return controlStock.getStockUnite();
	}
	
	public HashMap<String,Double> getEtalageMap() {
		return controlStock.getEtalageMap();
	}
	
	public HashMap<String,Integer> getProductDone(String nom){
		nom=nom.toLowerCase();
		return controlStock.getProductDone(nom);
	}
	
	public void ajouterProduit(String nom,int qty) {
		nom = nom.toLowerCase();
		double addQty = qty*1.0;
		controlStock.ajouterProduit(nom,addQty);
	}

}
