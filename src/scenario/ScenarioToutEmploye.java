package scenario;

import java.awt.EventQueue;

import batiment.*;
import dialogue.DialogueBoulangerie;
import boundaries.*;
import controleur.*;

public class ScenarioToutEmploye {
	private Boulangerie boulangerie = new Boulangerie("La Boulangerie");
	private DialogueBoulangerie dialogueBoulangerie = new DialogueBoulangerie(boulangerie);
	
	
	public void initDialog() {
		boulangerie.gagnerArgent(200);
		this.dialogueBoulangerie.initDialog();
	}
	
	
	
	
	public static void main(String[] args) {
		//Create dialogBoulangerie
		ScenarioToutEmploye scenario = new ScenarioToutEmploye();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scenario.initDialog();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
