package personnes;

public interface Employe {	
	public static final String BEURRE = "beurre";
	public static final String CHOCOLAT = "chocolat";
	public static final String FARINE = "farine";
	public static final String LAIT = "lait";
	public static final String LEVURE = "levure";
	public static final String OEUF = "oeuf";
	public static final String SEL = "sel";
	public static final String SUCRE = "sucre";
	
	public static final String BAGUETTE = "baguette";
	public static final String CHOCOLATINE = "chocolatine";
	public static final String CROISSANT = "croissant";
	

	//Les methodes
	
	public void acheterIngredients(String ingredient, Double qty);
	
	public String presentation();

	public String metier();
}
