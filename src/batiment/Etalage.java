package batiment;

import produits.*;

public class Etalage extends Reserve{
	
	public Nourriture chocolatine = new Nourriture("chocolatine", 0, 7.55, "unites");
	public Nourriture croissant = new Nourriture("croissant", 0, 8.0, "unites");
	public Nourriture baguette = new Nourriture("baguette", 0, 1.0, "unites");
	
	public Etalage() {
		super();
	}
	
	public void FaireInventaire() {
		String texte = "Dans l'étalage il y a :\n";
		texte += chocolatine.InfoProduit() + "\n";
		texte += croissant.InfoProduit()+ "\n";
		texte += baguette.InfoProduit()+ "\n";
		afficher(texte);
	}
	
	public double PrixForNumber(int nbr) {
		if (nbr == 1){
			System.out.println(this.beurre.getPrix());
			return this.beurre.getPrix();
		}
		else if (nbr==2){
			return this.baguette.getPrix();
		}
		else if (nbr==3){
			return this.chocolatine.getPrix();
		}
		else if (nbr==4){
			return this.croissant.getPrix();
		}
		else {
			System.out.println("Il y a un problème pour PrixForNumber (Etalage)");
			return 0.0;
		}
		
	}
	
	
	
	public void AddQtyForNumber(int ingredient,int qty) {
		switch(ingredient) {
			case 1:
				this.baguette.ajouter(qty);
				break;
			case 2:
				this.chocolatine.ajouter(qty);
				break;
			case 3:
				this.croissant.ajouter(qty);
				break;
			default :
				System.out.println("Erreure dans AddQtyForNumber(Etalage)");
				break;
	}
	}
	
	public Boolean enoughtNourriture(int num, int qty) {
		switch(num) {
		case 1:
			return this.baguette.getQty()>=qty;
		case 2:
			return this.chocolatine.getQty()>=qty;
		case 3:
			return this.croissant.getQty()>=qty;
		default:
			System.out.println("Erreur à enoughtNourriture");
			return this.baguette.getQty()>=qty;
		}
	}

}
