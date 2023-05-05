package Scenario;
import java.util.*;
import batiment.*;
import personnes.*;
import produits.*;


public class Histoire {
	public static void main(String[] args) {
		
		
		
		
		
		
		Boulangerie boulangerie = new Boulangerie("La boulangerie d'Elijah");
		Boulanger patrick = new Boulanger(boulangerie,"Patrick");
		Caissier joseph = new Caissier(boulangerie,"Joseph");
		System.out.println(patrick.getBoulangerie());
		boulangerie.caisse.gagnerArgent(900);
		
		boulangerie.reserve.beurre.setQty(100);
		boulangerie.reserve.chocolat.setQty(100);
		boulangerie.reserve.farine.setQty(100);
		boulangerie.reserve.lait.setQty(100);
		boulangerie.reserve.levure.setQty(100);
		boulangerie.reserve.oeuf.setQty(100);
		boulangerie.reserve.sel.setQty(100);
		boulangerie.reserve.sucre.setQty(100);

//		boulangerie.Bienvenue();
//		boulangerie.reserve.FaireInventaire();
//		boulangerie.etalage.FaireInventaire();
//		
//		joseph.acheterIngredients();
//		boulangerie.etalage.AddQtyForNumber(1, 10);
//		
//		boulangerie.reserve.FaireInventaire();
//		boulangerie.etalage.FaireInventaire();
//		boulangerie.caisse.getArgent();
		

		patrick.FaireRecette();
		boulangerie.reserve.FaireInventaire();
		boulangerie.etalage.FaireInventaire();
		
		joseph.vendreNourriture(2.15);
	
	}
}
