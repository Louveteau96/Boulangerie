package batiment;

import produits.*;



public class Reserve {
	
	public Ingredients beurre = new Ingredients("beurre", 0, 7.55, "kilogrammes");
	public Ingredients chocolat = new Ingredients("chocolat", 0, 8.0, "kilogrammes");
	public Ingredients farine = new Ingredients("farine", 0, 1.0, "kilogrammes");
	public Ingredients lait = new Ingredients("lait", 0, 1.24, "litres");
	public Ingredients levure = new Ingredients("levure", 0, 8.42, "kilogrammes");
	public Ingredients oeuf = new Ingredients("oeuf", 0, 0.34, "unites");
	public Ingredients sel = new Ingredients("sel", 0, 0.57, "kilogrammes");
	public Ingredients sucre = new Ingredients("sucre", 0, 0.85, "kilogrammes");
	
	
	//Constructeur
	public Reserve(){}
	
	//Afficher l'inventaire
	public void afficher(String texte) {
		System.out.println(texte);
	}
	
	
	
	public void FaireInventaire() {
		String texte = "Dans la reserve il y a :\n";
		texte += beurre.InfoProduit() + "\n";
		texte += chocolat.InfoProduit()+ "\n";
		texte += farine.InfoProduit()+ "\n";
		texte += lait.InfoProduit()+ "\n";
		texte += levure.InfoProduit()+ "\n";
		texte += oeuf.InfoProduit()+ "\n";
		texte += sel.InfoProduit()+ "\n";
		texte += sucre.InfoProduit()+ "\n";
		afficher(texte);
	}
	
	public void AddQtyForNumber(int ingredient,double qty) {
		switch(ingredient) {
			case 1:
				this.beurre.ajouter(qty);
				break;
			case 2:
				this.chocolat.ajouter(qty);
				break;
			case 3:
				this.farine.ajouter(qty);
				break;
			case 4:
				this.lait.ajouter(qty);
				break;
			case 5:
				this.levure.ajouter(qty);
				break;
			case 6:
				this.oeuf.ajouter(qty);
				break;
			case 7:
				this.sel.ajouter(qty);
				break;
			case 8:
				this.sucre.ajouter(qty);
				break;
			default :
				System.out.println("Erreure dans AddQtyForNumber");
				break;
	}
	}

	public double PrixForNumber(int nbr) {
		switch(nbr) {
		case 1:
			return this.beurre.getPrix();
		case 2:
			return this.chocolat.getPrix();
		case 3:
			return this.farine.getPrix();
		case 4:
			return this.lait.getPrix();
		case 5:
			return this.levure.getPrix();
		case 6:
			return this.oeuf.getPrix();
		case 7:
			return this.sel.getPrix();
		case 8:
			return this.sucre.getPrix();
		default :
			System.out.println("Erreure dans PrixForNumber");
			return 0.0;
		}
		
	
}
	
	
	public Boolean enoughtIngredient(Recettes recettes,int qty) {
		if (this.beurre.getQty() >= recettes.getBeurreQty()*qty&&
				this.chocolat.getQty() >= recettes.getChocolatQty()*qty&&
				this.farine.getQty() >= recettes.getFarineQty()*qty&&
				this.lait.getQty() >= recettes.getLaitQty()*qty&&
				this.levure.getQty() >= recettes.getLevureQty()*qty&&
				this.oeuf.getQty() >= recettes.getOeufQty()*qty&&
				this.sel.getQty() >= recettes.getSelQty()*qty&&
				this.sucre.getQty() >= recettes.getSucreQty()*qty) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	
}