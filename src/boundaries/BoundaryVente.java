package boundaries;

import batiment.Boulangerie;
import controleur.ControlVente;

public class BoundaryVente {
	private ControlVente controlVente;
	
	//Constructeur
	public BoundaryVente(Boulangerie boulangerie) {
		this.controlVente = new ControlVente(boulangerie);
	}
	
	
	//Méthodes
}
