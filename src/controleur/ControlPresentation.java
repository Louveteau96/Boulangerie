package controleur;

import batiment.Boulangerie;

public class ControlPresentation {
private Boulangerie boulangerie;
	
	public ControlPresentation(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}

	//Les méthodes
	public String bienvenue() {
		return boulangerie.bienvenue().toString();
	}

}
