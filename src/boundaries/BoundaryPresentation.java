package boundaries;

import batiment.Boulangerie;
import controleur.ControlPresentation;

public class BoundaryPresentation {
	
	private ControlPresentation controlPresentation;
	
	//Constructeur
	public BoundaryPresentation(Boulangerie boulangerie) {
		this.controlPresentation = new ControlPresentation(boulangerie);
	}

	//Méthodes
	public String bienvenue() {
		return controlPresentation.bienvenue();
	}
	
	public boolean verifierValider(String nom) {
		nom = nom.toLowerCase();
		return controlPresentation.verifierNom(nom);
	}
	
}
