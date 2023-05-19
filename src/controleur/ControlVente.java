package controleur;

import batiment.Boulangerie;

public class ControlVente {
	private Boulangerie boulangerie;

	public ControlVente(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}
	
	//Les méthodes
	public double getPrice(int qtyChocolatine,int qtyCroissant, int qtyBaguette) {
		double prix = 0;
		prix += boulangerie.prixProduit("chocolatine")*qtyChocolatine;
		prix += boulangerie.prixProduit("croissant")*qtyCroissant;
		prix += boulangerie.prixProduit("baguette")*qtyBaguette;
		return prix;
	}
	
	public void perdreArgent(double perte) {
		boulangerie.perdreArgent(perte);
	}
	
	public boolean enoughtArgent(double perte) {
		double caisse = boulangerie.afficherArgent();
		return caisse-perte>=0;
	}

}
