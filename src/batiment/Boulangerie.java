package batiment;

public class Boulangerie {
	public String nom;
	public Reserve reserve;
	public Caisse caisse;
	public Etalage etalage;
	
	public Boulangerie(String nom){
		this.reserve = new Reserve();
		this.etalage = new Etalage();
		this.caisse = new Caisse(0);
		this.nom=nom;

	}
	
	public void Bienvenue() {
		String texte = "Bienvenue à : " + this.nom + ".\n";
		System.out.println(texte);
	}

}
