package dialogue;

import java.awt.EventQueue;

import batiment.Boulangerie;
import boundaries.*;
import controleur.*;
import presentation.JFrameBoulangerie;

public class DialogueBoulangerie {
	
	private JFrameBoulangerie presentationBoulangerie;
	private Boulangerie boulangerie = new Boulangerie("La Boulangerie");
	private ControlPresentation controleurPresentation = new ControlPresentation(boulangerie);
	private BoundaryPresentation boundariePresentation = new BoundaryPresentation(controleurPresentation);
	
	public void initDialog() {
		//Create presentation Frame
		presentationBoulangerie = new JFrameBoulangerie();
		//Associate dialogue to presentation
		presentationBoulangerie.setDialogue(this);
		//Initialize and enable presentation Frame
		String bienvenue = boundariePresentation.bienvenue();
		presentationBoulangerie.initPresentation(bienvenue);
		presentationBoulangerie.setVisible(true);
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
