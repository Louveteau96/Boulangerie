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
		System.out.println(nom);
		return boulangerie.getEmploye(nom).getProductDone();
	}


}
