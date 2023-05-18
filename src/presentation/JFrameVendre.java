package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private String[] tableauUnite;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblVendre;
	private JLabel lblEtalage;
	private JComboBox comboBoxRecette;
	private JLabel lblUnite;
	private JTextField textField;
	private JButton btnAjouter;
	private JButton btnRetour;
	private ArrayList<JTable> tables;
	private JLabel lblCommande;
	private JTable table;
	private JTable table_1;

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
		
		comboBoxRecette = new JComboBox();
		comboBoxRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBoxRecette_actionPerformed(e);
			}
		});
		comboBoxRecette.setModel(new DefaultComboBoxModel(new String[] {""}));

		comboBoxRecette.setBounds(684, 241, 156, 36);
		panel.add(comboBoxRecette);
		
		lblUnite = new JLabel("Unite");
		lblUnite.setBackground(new Color(255, 255, 255));
		lblUnite.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUnite.setBounds(1044, 241, 210, 36);
		panel.add(lblUnite);
		
		textField = new JTextField();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				changementTextField();
			}
			public void removeUpdate(DocumentEvent e) {
				changementTextField();
			}
			public void changedUpdate(DocumentEvent e) {
				changementTextField();
			}
		});

		textField.setBounds(850, 241, 184, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnValider_actionPerformed(e);
			}
		});
		btnAjouter.setFont(new Font("Arial", Font.PLAIN, 30));
		btnAjouter.setBounds(850, 331, 184, 52);
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
		lblCommande.setBounds(724, 437, 530, 40);
		panel.add(lblCommande);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(40);
		table.setFont(new Font("Arial", Font.PLAIN, 25));
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(77, 253, 403, 119);
		panel.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.setRowSelectionAllowed(false);
		table_1.setRowHeight(40);
		table_1.setFont(new Font("Arial", Font.PLAIN, 25));
		table_1.setFillsViewportHeight(true);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(791, 488, 403, 119);
		panel.add(table_1);
	}
	
	
	
	//Intitialisation
		public void initialisation(DialogueBoulangerie dialogue) {
			this.dialogueBoulangerie = dialogue;
			dialogueBoulangerie.comboBoxProduitsUpdate(comboBoxRecette);
			btnAjouter.setEnabled(false);
			comboBoxRecette.setSelectedIndex(0);
			textField.setText("");
			arrayInit();
			dialogueBoulangerie.stockArrayUpdate(tables);
			resetColors();
		}
		
		//Les méthodes
		protected void do_btnRetour_actionPerformed(ActionEvent e) {
			resetColors();
			btnAjouter.setEnabled(false);
			dialogueBoulangerie.retour(this);
		}

		protected void do_btnValider_actionPerformed(ActionEvent e) {
			String recette = comboBoxRecette.getItemAt(comboBoxRecette.getSelectedIndex()).toString();
			int qty = Integer.valueOf(textField.getText());
			dialogueBoulangerie.depenseIngredients(recette,qty);
		}
		
		//Vérifie qu'il y a des chiffres pour valider
		public void changementTextField() {
			int length = textField.getDocument().getLength();
			if(length>=1 && testInt(textField.getText())) {
				if(enoughtIngredient() && Integer.parseInt(textField.getText()) !=0) {
					btnAjouter.setEnabled(true);
				}else {
					btnAjouter.setEnabled(false);
				}
			}else {
				btnAjouter.setEnabled(false);
			}
			
		}
		
		//Vérifie qu'il n'y a que des integers dans le texte
		private boolean testInt(String text) {
		      try {
		         Integer.parseInt(text);
		         return true;
		      } catch (NumberFormatException e) {
		         return false;
		      }
		}
		
		//Vérifie qu'il y a assez d'ingredients pour activer valider
		private boolean enoughtIngredient() {
			String text = comboBoxRecette.getItemAt(comboBoxRecette.getSelectedIndex()).toString();
			int qty = Integer.parseInt(textField.getText());
			return dialogueBoulangerie.enoughtIngredients(tables, text, qty);
		}
		
		//Affiche les différents types d'erreur
		public boolean errorDisplay(int numError) {
			switch (numError) {
			case 1: {
				JOptionPane.showMessageDialog(this,"La boulangerie n'a pas assez de fonds","Probleme de fonds",JOptionPane.ERROR_MESSAGE);
				return false;
			}case 2:{
				int retour = JOptionPane.showConfirmDialog(this,"Etes vous sur ?","Validation",JOptionPane.OK_CANCEL_OPTION);
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
		
		//JTable stock update
		public void jtableStockUpdate() {
			dialogueBoulangerie.stockArrayUpdate(tables);
		}
		
		//Reset achat
		public void resetAchat() {
			comboBoxRecette.setSelectedIndex(0);
			textField.setText("");
			resetColors();
		}
		
		//Reset couleurs
		public void resetColors() {
			for(int i =0;i<tables.size();i++) {
				tables.get(i).setBackground(Color.white);
			}
		}
		

	protected void do_comboBoxRecette_actionPerformed(ActionEvent e) {
		changementTextField();
	}
}
