package boundaries;

import controleur.ControlGestionEmploye;
import personnes.*;
import presentation.*;

public class BoundaryGestionEmploye {
	private ControlGestionEmploye controlGestionEmploye;
	
	//Constructeur
	public BoundaryGestionEmploye(ControlGestionEmploye controlGestionEmploye) {
		this.controlGestionEmploye = controlGestionEmploye;
	}
	
	//Méthodes
	public void ajouterEmploye(String nom,String metier) {
		StringBuilder message = new StringBuilder();
		if(controlGestionEmploye.isEmploye(nom)){
			message.append(nom);
			message.append(" est déjà de l'entreprise !");
			System.out.println(message.toString());
		}else {
			controlGestionEmploye.ajouterEmploye(nom, metier);
		}
	}
	
	public void supprimerEmploye(String nom) {
		StringBuilder message = new StringBuilder();
		if(!controlGestionEmploye.isEmploye(nom)){
			message.append(nom);
			message.append(" ne fait pas partie de l'entreprise !");
			System.out.println(message.toString());
		}else {
			controlGestionEmploye.supprimerEmploye(nom);
		}
	}
	
	public String getMetier(String nom) {
		if(controlGestionEmploye.getMetier(nom).metier().equals("caissier")) {
			return "caissier";
		}else {
			return "boulanger";
		}
	}

}
