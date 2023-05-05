package batiment;

public class Caisse {
	private double argent;
	
	//Le constructeur
	public Caisse(double argent){
		this.argent = argent;
	}
	
	//Les methodes
	public double getArgent() {
		System.out.println(this.argent);
		return this.argent;
	}
	
	public void perdeArgent(double perte) {
		this.argent = argent - perte;
	}
	
	public void gagnerArgent(double gain) {
		this.argent = argent + gain;
	}
	
	public boolean EnoughtFunds(double perte) {
		return this.argent>=perte;
	}

}
