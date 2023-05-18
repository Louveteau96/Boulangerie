package controleur;

public class ControlVerifContent {
	
	
	//Les méthodes
	
	//Vérifie qu'un texte ne contienne que des double
	public boolean testDouble(String text) {
		try {
	         return Double.parseDouble(text)>0;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	}
	
	//Vérifie qu'un texte ne contienne que des integer
	public boolean testInteger(String text) {
		try {
			return Integer.parseInt(text)>0;
		}catch(NumberFormatException e) {
			return false;
		}
	}

}
