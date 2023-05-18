package dialogue;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;

import batiment.Boulangerie;
import boundaries.*;
import controleur.*;
import presentation.*;

public class DialogueBoulangerie {
	
	private String employe;
	private Boulangerie boulangerie;
	//Les boundary
	private BoundaryPresentation boundaryPresentation;
	private BoundaryStock boundaryStock;
	private BoundaryGestionEmploye boundaryGestionEmploye;
	private BoundaryAcheterIngredient boundaryAcheterIngredient;
	private BoundaryCuisiner boundaryCuisiner;
	private BoundaryVerifContent boundaryVerifContent;
	
	//Les JFrame
	private JFrameMetier presentationMetier = new JFrameMetier();
	private JFrameCaissier presentationCaissier = new JFrameCaissier();
	private JFrameBoulanger presentationBoulanger = new JFrameBoulanger();
	private JFrameAcheterIngredients presentationAcheterIngredients = new JFrameAcheterIngredients();
	private JFrameCuisiner presentationCuisiner = new JFrameCuisiner();
	private JFrameVendre presentationVendre = new JFrameVendre();
	
	
	//Constructeur
	public DialogueBoulangerie(Boulangerie boulangerie) {
		this.boulangerie=boulangerie;
		boundaryPresentation = new BoundaryPresentation(boulangerie);
		boundaryStock = new BoundaryStock(boulangerie);
		boundaryGestionEmploye = new BoundaryGestionEmploye(boulangerie);
		boundaryAcheterIngredient = new BoundaryAcheterIngredient(boulangerie);
		boundaryCuisiner = new BoundaryCuisiner(boulangerie);
		boundaryVerifContent = new BoundaryVerifContent();
	}
	
	public void initDialog() {
		//Initialisation des employés
		String caissier = "Marc";
		String boulanger = "jose";
		boundaryGestionEmploye.ajouterEmploye(caissier, "caissier");
		boundaryGestionEmploye.ajouterEmploye(boulanger, "boulanger");
		//Associate dialogue to presentation
		presentationMetier.setDialogue(this);
		//Initialize and enable presentation Frame
		String bienvenue = boundaryPresentation.bienvenue();
		presentationMetier.initPresentation(bienvenue);
		presentationMetier.setVisible(true);
		presentationBoulanger.setVisible(false);
		presentationCaissier.setVisible(false);
	}
	
	  //========================//
	 //Changement JFrame Métier//
	//========================//
	public void verifierNom(String nom) {
		if(boundaryPresentation.verifierValider(nom)) {
			changementJFrameMetier(nom);
			employe = nom;
		}else {
			presentationMetier.errorName(nom);
		}
	}
	
	public void changementJFrameMetier(String nom) {
		employe = nom;
		String metier = boundaryGestionEmploye.getMetier(nom);
		if(metier.equals("caissier")) {
			changementJFrameCaissier();
		}else {
			changementJFrameBoulanger();
		}
	}
	
	
	  //===========================//
	 //Changement JFrame Boulanger//
	//===========================//
	public void changementJFrameBoulanger() {
		presentationMetier.setVisible(false);
		presentationBoulanger.setDialogue(this);
		presentationBoulanger.setVisible(true);
		presentationBoulanger.initialisation();
	
	}

	  //===========================//
	 //Changement JFrame Caissier //
	//===========================//
	public void changementJFrameCaissier() {
		presentationMetier.setVisible(false);
		presentationCaissier.setDialogue(this);
		presentationCaissier.setVisible(true);
		presentationCaissier.initialisation();
		
	}
	
	  //==============================//
	 //Changement JFrame Déconnexion //
	//==============================//
	public void deconnexion() {
		presentationCaissier.setVisible(false);
		presentationBoulanger.setVisible(false);
		presentationMetier.setVisible(true);
		presentationMetier.initPresentation(boundaryPresentation.bienvenue());
	}
	
	  //==================//
	 //Changement Retour //
	//==================//
	public void retour(JFrame jframe) {
		jframe.setVisible(false);
		if(boundaryGestionEmploye.getMetier(employe).equalsIgnoreCase("caissier")) {
			changementJFrameCaissier();
		}else {
			changementJFrameBoulanger();
		}
	}

	  //======================================//
	 //Changement JFrame Acheter Ingredients //
	//======================================//
	public void changementJFrameAcheterIngredients() {
		presentationCaissier.setVisible(false);
		presentationBoulanger.setVisible(false);
		presentationAcheterIngredients.setVisible(true);
		presentationAcheterIngredients.initialisation(this);
	}
	
	  //===========================//
	 //Changement JFrame Cuisiner //
	//===========================//
	public void changementJFrameCuisiner() {
		presentationBoulanger.setVisible(false);
		presentationCuisiner.setVisible(true);
		presentationCuisiner.initialisation(this);
		
	}
	  //===========================//
	 //Changement JFrame Vendre //
	//===========================//	
	public void changementJFrameVendre() {
		presentationCaissier.setVisible(false);
		presentationVendre.setVisible(true);
		presentationVendre.initialisation(this);
	}
	
	
	
	//Mise à jour des infos du stock
	public void stockUpdate(JTable tableStock) {
		int i =0;
		HashMap<String,Double> stockMap = boundaryStock.getStockMap();
		HashMap<String,String> uniteMap = boundaryStock.getStockUnite();
		tableStock.getModel();
		for (HashMap.Entry<String, Double> entry : stockMap.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			String unite = uniteMap.get(key);
			tableStock.setValueAt(key, i, 0);
			tableStock.setValueAt(val, i, 1);
			tableStock.setValueAt(unite, i, 2);
			i++;
		}
	}
	
	//Mise à jour des infos des produits cuisinés
	public void productDoneUpdate(JTable tableProduit) {
		int i =0;
		HashMap<String,Integer> produitMap = boundaryStock.getProductDone(employe);
		tableProduit.getModel();
		for (HashMap.Entry<String, Integer> entry : produitMap.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			tableProduit.setValueAt(key, i, 0);
			tableProduit.setValueAt(val, i, 1);
			i++;
		}
	}
	
	//Mise à jour des infos de l'étalage
	public void etalageUpdate(JTable tableProduit) {
		int i =0;
		HashMap<String,Double> produitMap = boundaryStock.getEtalageMap();
		tableProduit.getModel();
		for (HashMap.Entry<String, Double> entry : produitMap.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			tableProduit.setValueAt(key, i, 0);
			tableProduit.setValueAt(val, i, 1);
			i++;
		}
	}
	
	//Mise à jour des ingredients d'un combobox
	public String[] comboBoxIngredientsUpdate(JComboBox combobox) {
		int i =0;
		HashMap<String,String> stockMap = boundaryStock.getStockUnite();
		String[] newComboBox = new String[stockMap.size()];
		String[] tableauUnite = new String[stockMap.size()];
		for (HashMap.Entry<String, String> entry : stockMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			tableauUnite[i]=value;
			newComboBox[i] = key;
			i++;
		}
		combobox.setModel(new DefaultComboBoxModel(newComboBox));
		return tableauUnite;
	}
	
	//Mise à jour des produits d'un combobox
	public void comboBoxProduitsUpdate(JComboBox combobox) {
		int i =0;
		HashMap<String,Double> produitMap = boundaryStock.getEtalageMap();
		String[] newComboBox = new String[produitMap.size()]; 
		for (HashMap.Entry<String, Double> entry : produitMap.entrySet()) {
			String key = entry.getKey();
			newComboBox[i] = key;
			i++;
		}
		combobox.setModel(new DefaultComboBoxModel(newComboBox));
	}
	
	//Mise à jour des ingrédients d'une arrayList de JTable
	public void stockArrayUpdate(ArrayList<JTable> tables) {
		int i =0;
		HashMap<String,Double> stockMap = boundaryStock.getStockMap();
		HashMap<String,String> uniteMap = boundaryStock.getStockUnite();
		for (HashMap.Entry<String, Double> entry : stockMap.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			String unite = uniteMap.get(key);
			tables.get(i).setValueAt(key, 0, 0);
			tables.get(i).setValueAt(val, 0, 1);
			tables.get(i).setValueAt(unite, 0, 2);
			i++;
		}
	}
	
	//Acheter les ingrédients
	public void acheterIngredients(String ingredient, Double qty) {
		int error = boundaryAcheterIngredient.acheterIngredients(ingredient,qty);
		boolean valider = presentationAcheterIngredients.errorDisplay(error);
		if(valider) {
			boundaryAcheterIngredient.obtentionIngredients(ingredient,qty);
			presentationAcheterIngredients.jtableStockUpdate();
		}else {
			presentationAcheterIngredients.resetAchat();
		}
	}
	
	//Depsense les ingrédients
	public void depenseIngredients(String recetteNom, int qty) {
		int error = 2;
		boolean valider = presentationCuisiner.errorDisplay(error);
		if(valider) {
			HashMap<String,Double> recette = boundaryGestionEmploye.getRecipe(employe,recetteNom);
			boundaryCuisiner.depenserIngredients(recette, qty);
			presentationCuisiner.jtableStockUpdate();
			presentationCuisiner.changementTextField();
			
			//Mise à jour des infos pour le boulanger
			HashMap<String, Integer> productsDone= boundaryGestionEmploye.getProductsDone(employe);
			int qtyDejaFaite = productsDone.get(recetteNom);
			productsDone.put(recetteNom, qtyDejaFaite+qty);
			
			//Mise à jour de l'étalage
			HashMap<String,Double> mapEtalage = boundaryStock.getEtalageMap();
			mapEtalage.put(recetteNom, qty*1.0);
		}else {
			presentationCuisiner.resetAchat();
		}
		
	}
	
	//Ajoute les produits créés
	public void ajouterProduit(String nomProduit,int qty) {
		boundaryStock.ajouterProduit(nomProduit, qty);
	}
	
	//Met à jour les couleurs du tableau
	public boolean enoughtIngredients(ArrayList<JTable> tables, String recetteNom,int qty) {
		HashMap<String,Double> recette = boundaryGestionEmploye.getRecipe(employe,recetteNom);
		return boundaryCuisiner.enoughtIngredients(recette,qty,tables);
	}
	
	//Vérifie si il y a assez de stock dans l'étalage
	public boolean enoughtProducts(String nomProduit, int qty) {
		return boundaryStock.enoughtProducts(nomProduit, qty);
	}
	
	//Les tests
	public boolean testDouble(String text) {
		return boundaryVerifContent.testDouble(text);
	}
	public boolean testInteger(String text) {
		return boundaryVerifContent.testInteger(text);
	}

}
