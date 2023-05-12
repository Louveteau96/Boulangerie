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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;

public class JFrameMetier extends JFrame {

	private JPanel contentPane;
	
	//Tout ce qui est spécifique à la boulangerie
	private DialogueBoulangerie dialogueBoulangerie;
	private JPanel panelChoixMetier;
	private JButton btnCaissier;
	private JButton btnBoulanger;
	private JLabel lblBienvenue;
	private JLabel lblSelectionnez;


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
		
		btnCaissier = new JButton("Caissier");
		btnCaissier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCaissier_actionPerformed(e);
			}
		});
		btnCaissier.setBounds(30, 619, 549, 271);
		btnCaissier.setFont(new Font("Arial", Font.PLAIN, 24));
		btnCaissier.setBackground(UIManager.getColor("Button.background"));
		panelChoixMetier.add(btnCaissier);
		
		btnBoulanger = new JButton("Boulanger");
		btnBoulanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBoulanger_actionPerformed(e);
			}
		});
		btnBoulanger.setBounds(680, 619, 549, 271);
		btnBoulanger.setFont(new Font("Arial", Font.PLAIN, 24));
		btnBoulanger.setBackground(UIManager.getColor("Button.background"));
		panelChoixMetier.add(btnBoulanger);
		
		lblBienvenue = new JLabel("Bienvenue à : La Boulangerie");
		lblBienvenue.setBounds(272, 184, 714, 59);
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Arial", Font.BOLD, 50));
		panelChoixMetier.add(lblBienvenue);
		
		lblSelectionnez = new JLabel("Sélectionnez votre métier");
		lblSelectionnez.setBounds(325, 320, 606, 59);
		lblSelectionnez.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnez.setFont(new Font("Arial", Font.BOLD, 50));
		panelChoixMetier.add(lblSelectionnez);
	}
	
	//Initialisation
	public void initPresentation(String nom) {
		lblBienvenue.setEnabled(true);
		lblBienvenue.setText(nom);
		lblSelectionnez.setEnabled(true);
		btnBoulanger.setEnabled(true);
		btnCaissier.setEnabled(true);
	}
	
	
	//Record reference to Dialogue
	public void setDialogue(DialogueBoulangerie dialogueBoulangerie) {
		this.dialogueBoulangerie = dialogueBoulangerie;
	}
	
	//On affiche le bienvenu avec le nom de la boulangerie
	public void afficherNom(String nom) {
		lblBienvenue.setText(nom);
	}
	protected void do_btnCaissier_actionPerformed(ActionEvent e) {
		dialogueBoulangerie.changementJFrameCaissier();
	}
	
	protected void do_btnBoulanger_actionPerformed(ActionEvent e) {
		dialogueBoulangerie.changementJFrameBoulanger();
	}
}
