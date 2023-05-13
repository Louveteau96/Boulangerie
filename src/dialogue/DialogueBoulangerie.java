package dialogue;

import java.awt.EventQueue;
import java.util.HashMap;

import batiment.Boulangerie;
import boundaries.*;
import controleur.*;
import presentation.*;

public class DialogueBoulangerie {
	
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
		}else {
			presentationMetier.errorName(nom);
		}
	}
	
	public void changementJFrameMetier(String nom) {
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
		HashMap<String,Double> stock = controlStock.getStockMap();
		HashMap<String,String> unite = controlStock.getStockUnite();
		HashMap<String,Double> etalage = controlStock.getEtalageMap();
		presentationBoulanger.stockUpdate(stock,unite);
		presentationBoulanger.etalageUpdate(etalage);
	
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
	public void deconnexion(String metier) {
		if(metier.toLowerCase()=="caissier") {
			presentationCaissier.setVisible(false);
		}
	}
	
	

}
