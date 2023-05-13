package personnes;

import batiment.*;
import boundaries.BoundaryVente;
import controleur.ControlVente;
import personnes.*;

import java.util.*;

public class Caissier implements Employe{
	private Boulangerie boulangerie;
	private String nom;
	private ControlVente controlVente = new ControlVente(boulangerie);
	private BoundaryVente boundaryVente = new BoundaryVente(controlVente);
	
	public Caissier(Boulangerie boulangerie,String nom){
		this.boulangerie = boulangerie;
		this.nom = nom;
	};
	
	public void Vendre() {
		
	}
	
	public String RendreMonnaie(double amnt, double prix) {
		boundaryVente.
			if (prix < amnt) {
				double rendu = amnt-prix;
				this.boulangerie.caisse.perdeArgent(rendu);
				String texte = "Tenez vos : " + rendu + " euros.";
				texte += "Merci pour votre visite";
				afficher(texte);
			}
			else {
				afficher("Merci pour votre visite");
			}
		}
	
	private Boolean FinCourse() {
		String texte = "Ce sera tout ? \n";
		texte += "1 : Oui \n";
		texte += "2 : Non \n";
		afficher(texte);
		int num = sc.nextInt();
		while (0>num || num>2) {
			num = QuelIngredient();
		}
		if (num==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void ajoutCommande(int num, int qty,ArrayList<Double> commande) {
		commande.set(num-1, (double) qty);
	}
	
	private double prixCommande(ArrayList<Double> commande) {
		double somme = 0;
		double num1 = commande.get(0);
		double num2 = commande.get(1);
		double num3 = commande.get(2);
		somme = this.boulangerie.etalage.baguette.getPrix() * num1;
		somme += this.boulangerie.etalage.chocolatine.getPrix() * num2;
		somme += this.boulangerie.etalage.croissant.getPrix() * num3;
		return somme;
	}
	
	private Boolean enoughtMoney(double money, double prix) {
		return money>=prix;
	}
	
	private Boolean paiement(double money,double prix) {
		if (enoughtMoney(money,prix)) {
			this.RendreMonnaie(money, prix);
			return true;
		}
		else {
			afficher("Vous n'avez pas assez d'argent, vous avez donné : " + money + " euros. \n");
			return false;
		}
	}
	
	private void donnerNourriture(ArrayList commande) {
		double qty1 = (double) commande.get(0);
		double qty2 = (double) commande.get(1);
		double qty3 = (double) commande.get(2);
		
		boulangerie.etalage.baguette.setQty(boulangerie.etalage.baguette.getQty() - qty1);
		boulangerie.etalage.baguette.setQty(boulangerie.etalage.baguette.getQty() - qty2);
		boulangerie.etalage.baguette.setQty(boulangerie.etalage.baguette.getQty() - qty3);
	}

	
	public void vendreNourriture(double money) {
		Boolean fin = false;
		double prix = 0;
		ArrayList<Double> commande = new ArrayList<>(Arrays.asList(0.0,0.0,0.0));
		boulangerie = this.getBoulangerie();
		while (!fin){
			int num=this.QuelleNourriture();
			int qty = this.QuelleQtyInt();
			if (this.boulangerie.etalage.enoughtNourriture(num, qty)) {
				this.ajoutCommande(num, qty, commande);
			}
			else {
				afficher("Il n'y en a pas assez !");
			}
			fin=this.FinCourse();
		}
		 prix = this.prixCommande(commande);
		afficher("ça vous fera : " + prix + " euros." );
		if(this.paiement(money, prix)) {
			this.donnerNourriture(commande);
		}
		
		
		
		
	}



	@Override
	public void acheterIngredients(String ingredient, Double qty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String presentation() {
		return "Bonjour je suis " + nom + " je suis caissier";
	}
	
	@Override
	public String metier() {
		return "caissier";
	}

	@Override
	public HashMap<String, Integer> getProductDone() {
		return null;
	}
	


}

