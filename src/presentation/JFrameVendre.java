package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import dialogue.DialogueBoulangerie;

public class JFrameVendre extends JFrame {

	private DialogueBoulangerie dialogueBoulangerie;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblVendre;
	private JLabel lblEtalage;
	private JComboBox comboBoxProduit;
	private JLabel lblUnite;
	private JTextField textFieldNbrProduit;
	private JButton btnAjouter;
	private JButton btnRetour;
	private HashMap<String,Integer> commande;
	private JLabel lblCommande;
	private JTable etalageTable;
	private JTable commandeTable;
	private JButton btnVendre;
	private JLabel lblPrixLabel;
	private JLabel lblPrixDisplay;
	private JLabel lblArgentClient;
	private JTextField textFieldArgentClient;
	private JButton btnRetirer;

	/**
	 * Create the frame.
	 */
	public JFrameVendre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1264, 985);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblVendre = new JLabel("Vendre");
		lblVendre.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendre.setFont(new Font("Arial", Font.PLAIN, 40));
		lblVendre.setBounds(370, 11, 626, 221);
		panel.add(lblVendre);
		
		lblEtalage = new JLabel("Etalage");
		lblEtalage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtalage.setFont(new Font("Arial", Font.PLAIN, 25));
		lblEtalage.setBackground(Color.WHITE);
		lblEtalage.setBounds(10, 202, 530, 40);
		panel.add(lblEtalage);
		
		comboBoxProduit = new JComboBox();
		comboBoxProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBoxRecette_actionPerformed(e);
			}
		});
		comboBoxProduit.setModel(new DefaultComboBoxModel(new String[] {""}));

		comboBoxProduit.setBounds(684, 241, 156, 36);
		panel.add(comboBoxProduit);
		
		lblUnite = new JLabel("Unite");
		lblUnite.setBackground(new Color(255, 255, 255));
		lblUnite.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUnite.setBounds(1044, 241, 210, 36);
		panel.add(lblUnite);
		
		textFieldNbrProduit = new JTextField();
		textFieldNbrProduit.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				changementTextField();
				changementRetirer();
			}
			public void removeUpdate(DocumentEvent e) {
				changementTextField();
				changementRetirer();
			}
			public void changedUpdate(DocumentEvent e) {
				changementTextField();
				changementRetirer();
			}
		});

		textFieldNbrProduit.setBounds(850, 241, 184, 36);
		panel.add(textFieldNbrProduit);
		textFieldNbrProduit.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAjouter_actionPerformed(e);
			}
		});

		btnAjouter.setFont(new Font("Arial", Font.PLAIN, 30));
		btnAjouter.setBounds(721, 331, 184, 52);
		panel.add(btnAjouter);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRetour_actionPerformed(e);
			}
		});

		btnRetour.setFont(new Font("Arial", Font.PLAIN, 30));
		btnRetour.setBounds(492, 797, 260, 121);
		panel.add(btnRetour);
		
		lblCommande = new JLabel("Commande");
		lblCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommande.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCommande.setBackground(Color.WHITE);
		lblCommande.setBounds(10, 437, 530, 40);
		panel.add(lblCommande);
		
		etalageTable = new JTable();
		etalageTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Produit", "Quantit\u00E9"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		etalageTable.getColumnModel().getColumn(0).setResizable(false);
		etalageTable.getColumnModel().getColumn(1).setResizable(false);
		etalageTable.setRowSelectionAllowed(false);
		etalageTable.setRowHeight(40);
		etalageTable.setFont(new Font("Arial", Font.PLAIN, 25));
		etalageTable.setFillsViewportHeight(true);
		etalageTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		etalageTable.setBounds(77, 253, 403, 119);
		panel.add(etalageTable);
		
		commandeTable = new JTable();
		commandeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Produit", "Quantit\u00E9"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		commandeTable.getColumnModel().getColumn(0).setResizable(false);
		commandeTable.getColumnModel().getColumn(1).setResizable(false);
		commandeTable.setRowSelectionAllowed(false);
		commandeTable.setRowHeight(40);
		commandeTable.setFont(new Font("Arial", Font.PLAIN, 25));
		commandeTable.setFillsViewportHeight(true);
		commandeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		commandeTable.setBounds(77, 488, 403, 119);
		panel.add(commandeTable);
		
		btnVendre = new JButton("Vendre");
		btnVendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnVendre_actionPerformed(e);
			}
		});
		btnVendre.setFont(new Font("Arial", Font.PLAIN, 30));
		btnVendre.setBounds(812, 516, 184, 52);
		panel.add(btnVendre);
		
		lblPrixLabel = new JLabel("Prix :");
		lblPrixLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPrixLabel.setBounds(77, 618, 73, 33);
		panel.add(lblPrixLabel);
		
		lblPrixDisplay = new JLabel("");
		lblPrixDisplay.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPrixDisplay.setBounds(183, 618, 297, 33);
		panel.add(lblPrixDisplay);
		
		lblArgentClient = new JLabel("Argent du client");
		lblArgentClient.setFont(new Font("Arial", Font.PLAIN, 25));
		lblArgentClient.setBounds(542, 488, 210, 30);
		panel.add(lblArgentClient);
		
		textFieldArgentClient = new JTextField();
		textFieldArgentClient.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldArgentClient.setBounds(527, 526, 210, 40);
		panel.add(textFieldArgentClient);
		textFieldArgentClient.setColumns(10);
		
		btnRetirer = new JButton("Retirer");
		btnRetirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRetirer_actionPerformed(e);
			}
		});
		btnRetirer.setFont(new Font("Arial", Font.PLAIN, 30));
		btnRetirer.setBounds(945, 331, 184, 52);
		panel.add(btnRetirer);
	}
	
	
		//===============//
		//Intitialisation//
		//===============//
	
		public void initialisation(DialogueBoulangerie dialogue) {
			this.dialogueBoulangerie = dialogue;
			dialogueBoulangerie.comboBoxProduitsUpdate(comboBoxProduit);
			etalageUpdate();
			resetAchat();
		}
		
		public void etalageUpdate() {
			dialogueBoulangerie.etalageUpdate(etalageTable);
		}
		
		//===============//
		//Boutons cliqués//
		//===============//
		
		protected void do_btnRetour_actionPerformed(ActionEvent e) {
			btnAjouter.setEnabled(false);
			dialogueBoulangerie.retour(this);
		}
		
		protected void do_comboBoxRecette_actionPerformed(ActionEvent e) {
			changementTextField();
			changementRetirer();
		}
		
		protected void do_btnAjouter_actionPerformed(ActionEvent e) {
			String produit = comboBoxProduit.getSelectedItem().toString();
			int qty = Integer.parseInt(textFieldNbrProduit.getText());
			dialogueBoulangerie.ajouterRetirerProduitCommande(produit,qty);
		}
		protected void do_btnRetirer_actionPerformed(ActionEvent e) {
			String produit = comboBoxProduit.getSelectedItem().toString();
			int qty = Integer.parseInt(textFieldNbrProduit.getText());
			dialogueBoulangerie.ajouterRetirerProduitCommande(produit, -qty);
			
		}
		protected void do_btnVendre_actionPerformed(ActionEvent e) {
			
		}
		
		//============//
		//Les méthodes//
		//============//

		
		//Vérifie qu'il y a des chiffres positifs pour ajouter
		public void changementTextField() {
			int length = textFieldNbrProduit.getDocument().getLength();
			if(length>=1 && dialogueBoulangerie.testInteger(textFieldNbrProduit.getText())) {
				btnAjouter.setEnabled(enoughtProducts());
			}else {
				btnAjouter.setEnabled(false);
			}
		}
		
		//Vérifie qu'il y a des chiffres positifs pour retirer
		public void changementRetirer() {
			int length = textFieldNbrProduit.getDocument().getLength();
			if(length>=1 && dialogueBoulangerie.testInteger(textFieldNbrProduit.getText())) {
				btnRetirer.setEnabled(enoughtCommand());
			}else {
				btnRetirer.setEnabled(false);
			}
		}

		//Vérifie qu'il y a assez de produits
		private boolean enoughtProducts() {
			String nomProduit = comboBoxProduit.getItemAt(comboBoxProduit.getSelectedIndex()).toString();
			int qty = Integer.parseInt(textFieldNbrProduit.getText());
			return dialogueBoulangerie.enoughtProducts(nomProduit, qty);
		}
		
		//Vérifie qu'il y a assez de produits dans la commande
		private boolean enoughtCommand() {
			String nomProduit = comboBoxProduit.getItemAt(comboBoxProduit.getSelectedIndex()).toString();
			int qty = Integer.parseInt(textFieldNbrProduit.getText());
			switch (nomProduit) {
			case "chocolatine": {
				return qty <= Integer.parseInt(commandeTable.getValueAt(0, 1).toString());
			}case "croissant":{
				return qty <= Integer.parseInt(commandeTable.getValueAt(1, 1).toString());
			}case "baguette":{
				System.out.println(commandeTable.getValueAt(2, 1).toString());
				return qty <= Integer.parseInt(commandeTable.getValueAt(2, 1).toString());
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + nomProduit);
			}
			
		}
		
		//Affiche les différents types d'erreur
		public boolean errorDisplay(int numError, double rendu) {
			switch (numError) {
			case 1: {
				JOptionPane.showMessageDialog(this,"La boulangerie n'a pas assez de monnaie à rendre","Probleme de fonds",JOptionPane.ERROR_MESSAGE);
				return false;
			}case 2:{
				int retour = JOptionPane.showConfirmDialog(this,"Rendez : " + rendu+ " euros","Validation",JOptionPane.OK_CANCEL_OPTION);
				if(retour==0) {
					return true;
				}else {
					return false;
				}
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + numError);
			}
		}

		
		//Reset achat
		public void resetAchat() {
			comboBoxProduit.setSelectedIndex(0);
			textFieldNbrProduit.setText("");
			textFieldArgentClient.setText("");
			resetCommande();
			btnAjouter.setEnabled(false);
			btnRetirer.setEnabled(false);
			btnVendre.setEnabled(false);
			
		}
		
		//Reset la commande
		public void resetCommande() {
			commandeTable.setValueAt(0, 0, 1);
			commandeTable.setValueAt(0, 1, 1);
			commandeTable.setValueAt(0, 2, 1);
			commandeTable.setValueAt("chocolatine", 0, 0);
			commandeTable.setValueAt("croissant", 1, 0);
			commandeTable.setValueAt("baguette", 2, 0);
		}
		
		//Met le prix à jour
		public void priceUpdate() {
			int qtyChocolatine = Integer.parseInt(commandeTable.getValueAt(0,1).toString());
			int qtyCroissant = Integer.parseInt(commandeTable.getValueAt(1,1).toString());
			int qtyBaguette = Integer.parseInt(commandeTable.getValueAt(2,1).toString());
			double prix = dialogueBoulangerie.priceUpdate(qtyChocolatine,qtyCroissant,qtyBaguette);
			lblPrixDisplay.setText(String.valueOf(prix));
		}
		
		//Ajoute des produits à la commande
		public void ajouterRetirerCommande(String produit,int qty) {
			switch (produit) {
			case "chocolatine": {
				int previousQty = Integer.parseInt(commandeTable.getValueAt(0, 1).toString());
				commandeTable.setValueAt(previousQty+qty, 0, 1);
				break;
			}case "croissant":{
				int previousQty = Integer.parseInt(commandeTable.getValueAt(1, 1).toString());
				commandeTable.setValueAt(previousQty+qty, 1, 1);
				break;
			}case "baguette":{
				int previousQty = Integer.parseInt(commandeTable.getValueAt(2, 1).toString());
				commandeTable.setValueAt(previousQty+qty, 2, 1);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + produit);
			}
		}
		

}
