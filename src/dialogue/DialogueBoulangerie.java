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
	private Boulangerie boulangerie;
	private ControlPresentation controleurPresentation;
	private ControlStock controlStock;
	private ControlGestionEmploye controlGestionEmploye;
	private ControlAcheterIngredients controlAcheterIngredients;
	private BoundaryGestionEmploye boundaryGestionEmploye;
	private BoundaryPresentation boundaryPresentation;
	private BoundaryAcheterIngredient boundaryAcheterIngredient;
	
	//Les JFrame
	private JFrameMetier presentationMetier = new JFrameMetier();
	private JFrameCaissier presentationCaissier = new JFrameCaissier();
	private JFrameBoulanger presentationBoulanger = new JFrameBoulanger();
	private JFrameAcheterIngredients presentationAcheterIngredients = new JFrameAcheterIngredients();
	
	
	//Constructeur
	public DialogueBoulangerie(Boulangerie boulangerie) {
		this.boulangerie=boulangerie;
		controleurPresentation = new ControlPresentation(boulangerie);
		controlStock = new ControlStock(boulangerie);
		controlGestionEmploye = new ControlGestionEmploye(boulangerie);
		controlAcheterIngredients = new ControlAcheterIngredients(boulangerie);
		boundaryGestionEmploye = new BoundaryGestionEmploye(controlGestionEmploye);
		boundaryPresentation = new BoundaryPresentation(controleurPresentation);
		boundaryAcheterIngredient = new BoundaryAcheterIngredient(controlAcheterIngredients);
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
		System.out.println(boulangerie.afficherArgent());
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
	
	//Acheter les ingrédients
	public void acheterIngredients(String ingredient, Double qty) {
		int error = boundaryAcheterIngredient.acheterIngredients(ingredient,qty);
		boolean valider = presentationAcheterIngredients.errorDisplay(error);
		if(valider) {
			boundaryAcheterIngredient.obtentionIngredients(ingredient,qty);
			presentationAcheterIngredients.jtableStockUpdate();
		}
	}

}
