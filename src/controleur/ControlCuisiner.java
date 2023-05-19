package controleur;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import batiment.Boulangerie;

public class ControlCuisiner {
	private Boulangerie boulangerie;
	private ArrayList<JTable> tables;
	
	public ControlCuisiner(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}
	
	//Les méthodes
	
	public void setJTable(ArrayList<JTable> tables) {
		this.tables = tables;
	}
	
	public boolean enoughtIngredients(HashMap<String,Double> recette, int qty) {
		HashMap<String,Double> stockMap = boulangerie.getStockMap();
		boolean enought = true;
		resetColors();
		for (HashMap.Entry<String, Double> entry : recette.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			
			//Il y a assez de stock
			if(stockMap.get(key)>= val*qty) {
				colorCase(key,true);
			}else {
				enought = false;
				colorCase(key,false);
			}
		}
		return enought;
	}
	
	//Dépense les ingrédients
	public void useIngredients(HashMap<String,Double>recette,int qty) {
		HashMap<String,Double> stockMap = boulangerie.getStockMap();
		for (HashMap.Entry<String, Double> entry : recette.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			
			Double qtyStock = stockMap.get(key);
			Double perte = val*qty;
			stockMap.put(key, qtyStock - perte);
		}
		
		
	}
	
	public void colorCase(String nomIngredient,boolean enought) {
		nomIngredient = nomIngredient.toLowerCase();
		int i;
		switch (nomIngredient) {
		case "beurre": {
			i=0;
			break;
		}
		case "chocolat": {
			i=3;
			break;
		}
		case "farine": {
			i=2;
			break;
		}
		case "lait": {
			i=1;
			break;
		}
		case "levure": {
			i=5;
			break;
		}
		case "oeuf": {
			i=4;
			break;
		}
		case "sel": {
			i=6;
			break;
		}
		case "sucre": {
			i=7;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nomIngredient);
		}
		if(enought) {
			tables.get(i).setBackground(Color.green);
		}else {
			tables.get(i).setBackground(Color.red);
		}
	}
	
	public void resetColors() {
		for (int i = 0; i < tables.size(); i++) {
			tables.get(i).setBackground(Color.white);
		}
	}
	
	public ArrayList<JTable> getTable(){
		return this.tables;
	}
	

		

}
