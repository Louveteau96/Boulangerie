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

public class JFrameBoulangerie extends JFrame {

	private JPanel contentPane;
	private JButton btnCaissier;
	private JButton btnBoulanger;
	
	//Tout ce qui est spécifique à la boulangerie
	private DialogueBoulangerie dialogueBoulangerie;
	private JLabel lblSelectionnez;
	private JLabel lblBienvenue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameBoulangerie frame = new JFrameBoulangerie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameBoulangerie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnCaissier = new JButton("Caissier");
		btnCaissier.setBounds(15, 619, 549, 271);
		btnCaissier.setBackground(UIManager.getColor("Button.background"));
		btnCaissier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCaissier_actionPerformed(e);
			}
		});
		btnCaissier.setFont(new Font("Arial", Font.PLAIN, 24));
		
		btnBoulanger = new JButton("Boulanger");
		btnBoulanger.setBackground(UIManager.getColor("Button.background"));
		btnBoulanger.setBounds(631, 619, 610, 271);
		btnBoulanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBoulanger_actionPerformed(e);
			}
		});
		btnBoulanger.setFont(new Font("Arial", Font.PLAIN, 24));
		
		lblSelectionnez = new JLabel("Sélectionnez votre métier");
		lblSelectionnez.setBounds(316, 318, 660, 108);
		lblSelectionnez.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnez.setFont(new Font("Arial", Font.BOLD, 50));
		
		lblBienvenue = new JLabel("Bienvenue à : La Boulangerie");
		lblBienvenue.setBounds(278, 83, 757, 129);
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Arial", Font.BOLD, 50));
		contentPane.setLayout(null);
		contentPane.add(btnCaissier);
		contentPane.add(btnBoulanger);
		contentPane.add(lblBienvenue);
		contentPane.add(lblSelectionnez);
	}
	
	//Bouton Caissier cliqué
	protected void do_btnCaissier_actionPerformed(ActionEvent e) {
	}
	
	//Bouton Boulanger cliqué
	protected void do_btnBoulanger_actionPerformed(ActionEvent e) {
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
}
