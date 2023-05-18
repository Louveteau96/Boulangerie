package controleur;

public class ControlVerifContent {
	
	
	//Les méthodes
	
	//Vérifie qu'un texte ne contienne que des double
	public boolean testDouble(String text) {
		try {
			double chiffre = Double.parseDouble(text);
	         return chiffre>0;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	}
	
	//Vérifie qu'un texte ne contienne que des integer
	public boolean testInteger(String text) {
		try {
			int chiffre = Integer.parseInt(text);
			return chiffre>0;
		}catch(NumberFormatException e) {
			return false;
		}
	}

}
