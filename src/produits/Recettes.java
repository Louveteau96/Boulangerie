package produits;

public enum Recettes {
	//Quantité d'ingrédients pour un produit :
	//Beurre, Chocolat, Farine, Lait, Levure, Oeuf, Sel, Sucre
	BAGUETTE(0,  0,  0.1635,  0,  0.00375,  0,  0.00333,  0.00166),
	CROISSANT(0.042,  0,  0.084,  0.0467,  0.0034,  0.2,  0.0017,  0.01),
	CHOCOLATINE(0.055,  0.01066,  0.125,  0.7,  0.025,  0.5,  0.0025,  0.010);
	
	
	private double beurreQty;
	private double chocolatQty;
	private double farineQty;
	private double laitQty;
	private double levureQty;
	private double oeufQty;
	private double selQty;
	private double sucreQty;
	
	
	
	//Le constructeur
	Recettes(double beurre, double chocolat, double farine, double lait, double levure, double oeuf, 
			double sel, double sucre){
		this.beurreQty = beurre;
		this.chocolatQty = chocolat;
		this.farineQty = farine;
		this.laitQty = lait;
		this.levureQty = levure;
		this.oeufQty = oeuf;
		this.selQty = sel;
		this.sucreQty = sucre;
	}

	
	//Tout les Getters
	public double getBeurreQty() {
		return beurreQty;
	}
	public double getChocolatQty() {
		return chocolatQty;
	}
	public double getFarineQty() {
		return farineQty;
	}
	public double getLaitQty() {
		return laitQty;
	}
	public double getLevureQty() {
		return levureQty;
	}
	public double getOeufQty() {
		return oeufQty;
	}
	public double getSelQty() {
		return selQty;
	}
	public double getSucreQty() {
		return sucreQty;
	}
	
	

}
