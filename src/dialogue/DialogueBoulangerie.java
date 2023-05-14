package dialogue;

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
	private Boulangerie boulangerie = new Boulangerie("La Boulangerie");
	private ControlPresentation controleurPresentation = new ControlPresentation(boulangerie);
	private ControlStock controlStock = new ControlStock(boulangerie);
	private ControlGestionEmploye controlGestionEmploye = new ControlGestionEmploye(boulangerie);
	private BoundaryGestionEmploye boundaryGestionEmploye = new BoundaryGestionEmploye(controlGestionEmploye);
	private BoundaryPresentation boundariePresentation = new BoundaryPresentation(controleurPresentation);
	
	//Les JFrame
	private JFrameMetier presentationMetier = new JFrameMetier();
	private JFrameCaissier presentationCaissier = new JFrameCaissier();
	private JFrameBoulanger presentationBoulanger = new JFrameBoulanger();
	private JFrameAcheterIngredients presentationAcheterIngredients = new JFrameAcheterIngredients();
	
	
	public void initDialog() {
		//Initialisation des employés
		String caissier = "Marc";
		String boulanger = "jose";
		boundaryGestionEmploye.ajouterEmploye(caissier, "caissier");
		boundaryGestionEmploye.ajouterEmploye(boulanger, "boulanger");
		//Associate dialogue to presentation
		presentationMetier.setDialogue(this);
		//Initialize and enable presentation Frame
		String bienvenue = boundariePresentation.bienvenue();
		presentationMetier.initPresentation(bienvenue);
		presentationMetier.setVisible(true);
		presentationBoulanger.setVisible(false);
		presentationCaissier.setVisible(false);
	}
	
	  //========================//
	 //Changement JFrame Métier//
	//========================//
	public void verifierNom(String nom) {
		if(boundariePresentation.verifierValider(nom)) {
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
		
	}
	
	  //==============================//
	 //Changement JFrame Déconnexion //
	//==============================//
	public void deconnexion() {
		presentationCaissier.setVisible(false);
		presentationBoulanger.setVisible(false);
		presentationMetier.setVisible(true);
		presentationMetier.initPresentation(boundariePresentation.bienvenue());
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
	
	//Mise à jour des infos du stock
	public void stockUpdate(JTable tableStock) {
		int i =0;
		HashMap<String,Double> stockMap = controlStock.getStockMap();
		HashMap<String,String> uniteMap = controlStock.getStockUnite();
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
		HashMap<String,Integer> produitMap = controlStock.getProductDone(employe);
		tableProduit.getModel();
		for (HashMap.Entry<String, Integer> entry : produitMap.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			tableProduit.setValueAt(key, i, 0);
			tableProduit.setValueAt(val, i, 1);
			i++;
		}
	}
	
	//Mise à jour des ingredients d'un combobox d'ingrédients
	public String[] comboBoxIngredientsUpdate(JComboBox combobox) {
		int i =0;
		HashMap<String,String> stockMap = controlStock.getStockUnite();
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

}
