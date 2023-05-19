package personnes;

import batiment.*;

import java.util.*;

public class Caissier implements Employe{
	private Boulangerie boulangerie;
	private String nom;
	
	public Caissier(Boulangerie boulangerie,String nom){
		this.boulangerie = boulangerie;
		this.nom = nom;
	}
	

	
	@Override
	public String metier() {
		return "caissier";
	}

	@Override
	public HashMap<String, Integer> getProductDone() {
		return new HashMap<>();
	}

	@Override
	public HashMap<String, Double> getRecipe(String recipe) {
		return new HashMap<>();
	}

	@Override
	public void setProductDone(HashMap<String, Integer> mapProductDone) {
		//Vide car inutile au caissier
	}
	


}

