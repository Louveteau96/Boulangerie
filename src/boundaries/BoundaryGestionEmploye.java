package boundaries;

import java.util.HashMap;

import batiment.Boulangerie;
import controleur.ControlGestionEmploye;

public class BoundaryGestionEmploye {
	private ControlGestionEmploye controlGestionEmploye;
	
	//Constructeur
	public BoundaryGestionEmploye(Boulangerie boulangerie) {
		this.controlGestionEmploye = new ControlGestionEmploye(boulangerie);
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
	
	//Getteur de recette
	public HashMap<String,Double> getRecipe(String nomEmploye,String recetteNom){
		nomEmploye = nomEmploye.toLowerCase();
		recetteNom = recetteNom.toLowerCase();
		return controlGestionEmploye.getRecipe(nomEmploye, recetteNom);
	}
	
	//getteur des produits réalisés
	public HashMap<String, Integer> getProductsDone(String nomEmploye){
		nomEmploye = nomEmploye.toLowerCase();
		return controlGestionEmploye.getProductsDone(nomEmploye);
	}

}
