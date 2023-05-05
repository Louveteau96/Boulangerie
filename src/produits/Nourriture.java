package produits;

public class Nourriture extends Produits{
	public String nom;
	public int quantite;
	public double prix = 1.05;
	public String unite = "unites";	
	
	
	public Nourriture(String nom, int quantite, double prix, String unite){
    	super(nom,prix,unite);
    	this.quantite = 0;
	}

    
    

}
