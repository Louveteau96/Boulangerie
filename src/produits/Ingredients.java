package produits;

public class Ingredients extends Produits{
	
	protected String nom;
	protected double quantite;
	protected double prix;
	protected String unite;
	
	public Ingredients(String nom, double quantite, double prix, String unite){
    	super(nom,prix,unite);
    	this.quantite = 0;
    }
	
    

}