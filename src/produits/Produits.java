package produits;

import java.util.Scanner;

public class Produits {
	protected String nom;
	protected double quantite;
	protected double prix;
	protected String unite;
	
	protected Produits(String nom,double prix, String unite){
    	this.nom = nom;
    	this.prix = prix;
    	this.quantite = 0;
    	this.unite = unite;
    }
	
	// Le Getter
		public double getQty() {
			return this.quantite;
		}
	    
	    //Le Setter
	    public void setQty(double qty) {
	    	this.quantite = qty;
	    	}
	    
	  //Ajout d'ingrédients
	    public void ajouter(double qty) {
	    	this.quantite += qty;
	    }
	
	
	public String getNom() {
		return this.nom;
	}
	
	public String getUnite() {
		return this.unite;
	}
	
	public double getPrix() {
		return this.prix;
	}

	
	//Pour lire les entrées de la console
    Scanner sc= new Scanner(System.in);
    
    public int entrerPositif(){
    	int nbr = -1;
    	while (nbr < 0){
    		System.out.println("Entrez un nombre positif");
    		nbr = sc.nextInt();    		
    	}
    	return nbr;
    }
    
    public String InfoProduit() {
    	String texte = this.getNom() + " : " + this.getQty()+ " " + this.getUnite();
    	return texte;
    }

}
