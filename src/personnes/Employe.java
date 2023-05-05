package personnes;
import batiment.*;
import java.util.*;

public class Employe {	
	private Boulangerie boulangerie;
	private String nom;
	
	//Le constructeur
	Employe(Boulangerie boulangerie,String nom){
		this.boulangerie=boulangerie;
		this.nom=nom;
	};
	
	
	//Les methodes
	
	public void afficher(String texte) {
		System.out.println(texte);
	}
	
	//Pour lire les entrées en console
	Scanner sc = new Scanner(System.in);

	//switch(case) à faire
	public int QuelIngredient() {
		String texte = "Quel ingredient souhaitez vous acheter ? \n";
		texte += "1 : Beurre \n";
		texte += "2 : Chocolat \n";
		texte += "3 : Farine \n";
		texte += "4 : Lait \n";
		texte += "5 : Levure \n";
		texte += "6 : Oeuf \n";
		texte += "7 : Sel \n";
		texte += "8 : Sucre";
		afficher(texte);
		int num = sc.nextInt();
		while (0>num || num>8) {
			num = QuelIngredient();
		}
		return num;
	}
	
	public int QuelleNourriture() {
		String texte = "Quelle nourriture souhaitez vous ? \n";
		texte += "1 : Baguette \n";
		texte += "2 : Chocolatine \n";
		texte += "3 : Croissant \n";
		afficher(texte);
		int num = sc.nextInt();
		while (0>num || num>3) {
			num = QuelleNourriture();
		}
		return num;
	}
	
	
	public double QuelleQtyDouble() {
		String texte = "Quelle quantitée de cet ingrédient voulez vous ?";
		afficher(texte);
		double qty = sc.nextDouble();
		return qty;
	}
	
	public int QuelleQtyInt() {
		String texte = "Quelle quantitée en voulez vous ?";
		afficher(texte);
		int qty = sc.nextInt();
		return qty;
	}
	
	
	public void acheterIngredients() {
		int ingredient = QuelIngredient();
		double qty = QuelleQtyDouble();
		double total = qty * this.boulangerie.reserve.PrixForNumber(ingredient);
		if (this.boulangerie.caisse.EnoughtFunds(total)) {
			this.boulangerie.caisse.perdeArgent(total);
			this.boulangerie.reserve.AddQtyForNumber(ingredient, qty);
		}
		else {
			String texte = "Il n'y a pas assez d'argent dans la caisse.";
			this.afficher(texte);
		}
		}
	
	public String getNom() {
		return this.nom;
	}
	
	public Boulangerie getBoulangerie() {
		return this.boulangerie;
	}
		
		
	
}
