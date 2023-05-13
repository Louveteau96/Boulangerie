package controleur;

import batiment.Boulangerie;
import personnes.*;

public class ControlGestionEmploye {
	private Boulangerie boulangerie;
	
	//Constructeur
	public ControlGestionEmploye(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}
	
	//Méthodes
	public void ajouterEmploye(String nom, String metier) {
		Employe employe;
		nom = nom.toLowerCase();
		metier = metier.toLowerCase();
		if(metier.equals("caissier")) {
			employe = new Caissier(boulangerie, nom);
		}else {
			employe = new Boulanger(boulangerie,nom);
		}
		boulangerie.addEmploye(employe, nom);
	}
	
	public void supprimerEmploye(String nom) {
		nom = nom.toLowerCase();
		boulangerie.removeEmploye(nom);
		
	}
	
	public boolean isEmploye(String nom) {
		nom = nom.toLowerCase();
		return boulangerie.isEmploye(nom);
	}
	
	public Employe getMetier(String nom) {
		nom=nom.toLowerCase();
		return boulangerie.getEmploye(nom);
	}
}
