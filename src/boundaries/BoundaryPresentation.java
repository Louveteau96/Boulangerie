package boundaries;

import controleur.ControlPresentation;

public class BoundaryPresentation {
	
	private ControlPresentation controlPresentation;
	
	//Constructeur
	public BoundaryPresentation(ControlPresentation controlPresentation) {
		this.controlPresentation = controlPresentation;
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
