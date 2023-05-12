package dialogue;

import java.awt.EventQueue;
import java.util.HashMap;

import batiment.Boulangerie;
import boundaries.*;
import controleur.*;
import presentation.*;

public class DialogueBoulangerie {
	
	private JFrameMetier presentationMetier;
	private Boulangerie boulangerie = new Boulangerie("La Boulangerie");
	private ControlPresentation controleurPresentation = new ControlPresentation(boulangerie);
	private ControlStock controlStock = new ControlStock(boulangerie);
	private BoundaryPresentation boundariePresentation = new BoundaryPresentation(controleurPresentation);
	
	public void initDialog() {
		//Create presentation Frame
		presentationMetier = new JFrameMetier();
		//Associate dialogue to presentation
		presentationMetier.setDialogue(this);
		//Initialize and enable presentation Frame
		String bienvenue = boundariePresentation.bienvenue();
		presentationMetier.initPresentation(bienvenue);
		presentationMetier.setVisible(true);
	}
	
	  //===========================//
	 //Changement JFrame Boulanger//
	//===========================//
	public void changementJFrameBoulanger() {
		JFrameBoulanger presentationBoulanger = new JFrameBoulanger();
		presentationMetier.setVisible(false);
		presentationBoulanger.setDialogue(this);
		presentationBoulanger.setVisible(true);
		HashMap stock = controlStock.getStockMap();
		presentationBoulanger.stockUpdate(stock);
	
	}
	
	  //===========================//
	 //Changement JFrame Boulanger//
	//===========================//
	

	  //===========================//
	 //Changement JFrame Caissier //
	//===========================//
	public void changementJFrameCaissier() {
		JFrameCaissier presentationCaissier = new JFrameCaissier();
		presentationMetier.setVisible(false);
		presentationCaissier.setDialogue(this);
		presentationCaissier.setVisible(true);
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Create dialogBoulangerie
		DialogueBoulangerie dialogueBoulangerie = new DialogueBoulangerie();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogueBoulangerie.initDialog();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
