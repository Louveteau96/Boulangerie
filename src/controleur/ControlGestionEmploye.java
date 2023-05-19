package controleur;

import java.util.HashMap;

import batiment.Boulangerie;
import personnes.*;

public class ControlGestionEmploye {
	private Boulangerie boulangerie;
	
	//Constructeur
	public ControlGestionEmploye(Boulangerie boulangerie) {
		this.boulangerie = boulangerie;
	}
	
	//=============//
	//Les méthodes //
	//=============//
	
	//Ajoute un employé
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
	
	//Supprime l'employé
	public void supprimerEmploye(String nom) {
		nom = nom.toLowerCase();
		boulangerie.removeEmploye(nom);
		
	}
	
	//Vérifie si c'est un employé
	public boolean isEmploye(String nom) {
		nom = nom.toLowerCase();
		return boulangerie.isEmploye(nom);
	}
	
	//Renvoi l'objet employe selon le nom
	public Employe getMetier(String nom) {
		nom=nom.toLowerCase();
		return boulangerie.getEmploye(nom);
	}
	
	//get une recette
	public HashMap<String,Double> getRecipe(String nomEmploye,String recetteNom){
		nomEmploye = nomEmploye.toLowerCase();
		recetteNom = recetteNom.toLowerCase();
		return getMetier(nomEmploye).getRecipe(recetteNom);
	}
	
	//get des produits faits
	public HashMap<String, Integer> getProductsDone(String nomEmploye){
		nomEmploye = nomEmploye.toLowerCase();
		return getMetier(nomEmploye).getProductDone();
	}
	
	//Set les produits faits
	public void setProductsDone(String nomEmploye,HashMap<String,Integer> productsDone) {
		nomEmploye = nomEmploye.toLowerCase();
		getMetier(nomEmploye).setProductDone(productsDone);
	}
	
	//Ajoute les produits faits
	public void addProductsDone(HashMap<String,Integer> productsDone,String nomEmploye) {
		nomEmploye = nomEmploye.toLowerCase();
		HashMap<String,Integer> oldProductsMap = getProductsDone(nomEmploye);
		for (HashMap.Entry<String, Integer> entry : productsDone.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			Integer oldValue = oldProductsMap.get(key);
			oldProductsMap.put(key, val+oldValue);	
		}
		setProductsDone(nomEmploye, oldProductsMap);
	}
}
