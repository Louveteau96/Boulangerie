package personnes;
import produits.*;
import batiment.*;

public class Boulanger extends Employe{
	private Boulangerie boulangerie;
	private String nom;
	
	public Boulanger(Boulangerie boulangerie, String nom){
		super(boulangerie,nom);
	};
	

	
	public Recettes recetteForNmbr(int nbr) {
		switch(nbr) {
		case 1:
			return Recettes.BAGUETTE;
		case 2:
			return Recettes.CHOCOLATINE;
		case 3:
			return Recettes.CROISSANT;
		default:
			afficher("Problème recetteForNmbr");
			return Recettes.BAGUETTE;
		}
	}
	
	private void ConsommerIngredients(Recettes recettes,int qty) {
		this.boulangerie.reserve.beurre.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getBeurreQty()* qty);
		this.boulangerie.reserve.chocolat.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getChocolatQty()*qty);
		this.boulangerie.reserve.farine.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getFarineQty()*qty);
		this.boulangerie.reserve.lait.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getLaitQty()*qty);
		this.boulangerie.reserve.levure.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getLevureQty()*qty);
		this.boulangerie.reserve.oeuf.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getOeufQty()*qty);
		this.boulangerie.reserve.sel.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getSelQty()*qty);
		this.boulangerie.reserve.sucre.setQty(this.boulangerie.reserve.beurre.getQty()-recettes.getSucreQty()*qty);
	}
	
	public void FaireRecette() {
		int NumNourriture = this.QuelleNourriture();
		int qty = this.QuelleQtyInt();
		Recettes recettes = this.recetteForNmbr(NumNourriture);
		//Je sais pas pourquoi ça buggait et il veut que je mette ça sinon boulangerie=null
		boulangerie = this.getBoulangerie(); 
		Boolean entree = boulangerie.reserve.enoughtIngredient(recettes,qty);
		if (entree) {
			this.boulangerie.etalage.AddQtyForNumber(NumNourriture, qty);
			this.ConsommerIngredients(recettes,qty);
		}
		else {
			afficher("Il n'y a pas assez d'ingredients. \n" + "Elles n'ont pas été réalisée \n");
		}
	}

}
