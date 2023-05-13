package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import batiment.Boulangerie;
import dialogue.DialogueBoulangerie;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class JFrameMetier extends JFrame {

	private JPanel contentPane;
	
	//Tout ce qui est spécifique à la boulangerie
	private DialogueBoulangerie dialogueBoulangerie;
	private JPanel panelChoixMetier;
	private JLabel lblBienvenue;
	private JLabel lblSelectionnez;
	private JTextField txtEntrezVotreNom;
	private JButton btnValider;
	


	/**
	 * Create the frame.
	 */
	public JFrameMetier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelChoixMetier = new JPanel();
		panelChoixMetier.setBounds(0, 0, 1280, 985);
		contentPane.add(panelChoixMetier);
		panelChoixMetier.setLayout(null);
		
		lblBienvenue = new JLabel("Bienvenue à : La Boulangerie");
		lblBienvenue.setBounds(272, 184, 714, 59);
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Arial", Font.BOLD, 50));
		panelChoixMetier.add(lblBienvenue);
		
		lblSelectionnez = new JLabel("Entrez votre nom");
		lblSelectionnez.setBounds(325, 320, 606, 59);
		lblSelectionnez.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnez.setFont(new Font("Arial", Font.BOLD, 50));
		panelChoixMetier.add(lblSelectionnez);
		
		txtEntrezVotreNom = new JTextField();
		txtEntrezVotreNom.setFont(new Font("Arial", Font.PLAIN, 20));
		txtEntrezVotreNom.setBounds(371, 450, 514, 69);
		panelChoixMetier.add(txtEntrezVotreNom);
		txtEntrezVotreNom.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnValider_actionPerformed(e);
			}
		});
		btnValider.setFont(new Font("Arial", Font.PLAIN, 50));
		btnValider.setBounds(371, 724, 514, 213);
		panelChoixMetier.add(btnValider);
	}
	
	//Initialisation
	public void initPresentation(String nom) {
		lblBienvenue.setEnabled(true);
		lblBienvenue.setText(nom);
		lblSelectionnez.setEnabled(true);
		btnValider.setEnabled(true);
	}
	
	
	//Record reference to Dialogue
	public void setDialogue(DialogueBoulangerie dialogueBoulangerie) {
		this.dialogueBoulangerie = dialogueBoulangerie;
	}
	
	//On affiche le bienvenu avec le nom de la boulangerie
	public void afficherNom(String nom) {
		lblBienvenue.setText(nom);
	}
	
	//Le bouton valider est pressé
	public void do_btnValider_actionPerformed(ActionEvent e) {
		String nom = txtEntrezVotreNom.getText();
		dialogueBoulangerie.verifierNom(nom);		
	}
	
	//Probleme avec le nom message d'erreur
	public void errorName(String nom) {
		JOptionPane.showMessageDialog(this,"Le nom : " + nom + " n'est pas un employé de la boulangerie","Erreur de Nom",JOptionPane.ERROR_MESSAGE);
		txtEntrezVotreNom.setText("");
		btnValider.setEnabled(true);
	}
}
