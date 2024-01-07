package controleur;

import batiment.Boulangerie;
import personnes.*;

public class ControlPresentation {
	private Boulangerie boulangerie;
	
	public ControlPresentation(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

	//Les méthodes
	public String bienvenue() {
		return boulangerie.bienvenue().toString();
	}
	
	public boolean verifierNom(String nom) {
		return boulangerie.isEmploye(nom);
	}

}
