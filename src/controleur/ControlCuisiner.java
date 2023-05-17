package controleur;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import batiment.Boulangerie;

public class ControlCuisiner {
	private Boulangerie boulangerie;
	private JTable jtable;
	
	public ControlCuisiner(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}
	
	//Les méthodes
	
	public void setJTable(JTable jtable) {
		this.jtable = jtable;
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
	
	public void colorCase(String nomIngredient,boolean enought) {
		int x ;
		int y = 1;
		nomIngredient = nomIngredient.toLowerCase();
		switch (nomIngredient) {
		case "beurre": {
			x =0;
			break;
		}
		case "chocolat": {
			x=1;
			break;
		}
		case "farine": {
			x=2;
			break;
		}
		case "lait": {
			x=3;
			break;
		}
		case "levure": {
			x=4;
			break;
		}
		case "oeuf": {
			x=5;
			break;
		}
		case "sel": {
			x=6;
			break;
		}
		case "sucre": {
			x=7;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nomIngredient);
		}
		if(enought) {
			jtable.getComponentAt(x, y).setBackground(Color.green);
			jtable.getComponentAt(x, y).setEnabled(false);
		}else {
			jtable.getComponentAt(x, y).setBackground(Color.red);
		}
	}
	
	public void resetColors() {
		jtable.setBackground(Color.white);
	}
	

		

}
