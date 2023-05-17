package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class JFrameCuisiner extends JFrame {

	private DialogueBoulangerie dialogueBoulangerie;
	private String[] tableauUnite;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCuisiner;
	private JTable tableStock;
	private JLabel lblStock;
	private JComboBox comboBoxRecette;
	private JLabel lblUnite;
	private JTextField textField;
	private JButton btnValider;
	private JButton btnRetour;

	/**
	 * Create the frame.
	 */
	public JFrameCuisiner() {
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
		
		lblCuisiner = new JLabel("Cuisiner");
		lblCuisiner.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuisiner.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCuisiner.setBounds(370, 11, 626, 221);
		panel.add(lblCuisiner);
		
		tableStock = new JTable();
		tableStock.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tableStock.setRowSelectionAllowed(false);
		tableStock.setRowHeight(40);
		tableStock.setFont(new Font("Arial", Font.PLAIN, 25));
		tableStock.setFillsViewportHeight(true);
		tableStock.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableStock.setBounds(10, 244, 520, 320);
		panel.add(tableStock);
		
		lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Arial", Font.PLAIN, 25));
		lblStock.setBackground(Color.WHITE);
		lblStock.setBounds(10, 202, 530, 40);
		panel.add(lblStock);
		
		comboBoxRecette = new JComboBox();
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
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnValider_actionPerformed(e);
			}
		});
		btnValider.setFont(new Font("Arial", Font.PLAIN, 30));
		btnValider.setBounds(850, 331, 184, 52);
		panel.add(btnValider);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRetour_actionPerformed(e);
			}
		});

		btnRetour.setFont(new Font("Arial", Font.PLAIN, 30));
		btnRetour.setBounds(492, 797, 260, 121);
		panel.add(btnRetour);
	}
	
	
	
	//Intitialisation
		public void initialisation(DialogueBoulangerie dialogue) {
			this.dialogueBoulangerie = dialogue;
			dialogueBoulangerie.stockUpdate(tableStock);
			dialogueBoulangerie.comboBoxProduitsUpdate(comboBoxRecette);
			btnValider.setEnabled(false);
			comboBoxRecette.setSelectedIndex(0);
			textField.setText("");
		}
		
		//Les méthodes
		protected void do_btnRetour_actionPerformed(ActionEvent e) {
			dialogueBoulangerie.retour(this);
		}

		protected void do_btnValider_actionPerformed(ActionEvent e) {
			String recette = comboBoxRecette.getItemAt(comboBoxRecette.getSelectedIndex()).toString();
			Double qty = Double.valueOf(textField.getText());
			dialogueBoulangerie.depenseIngredients(recette,qty);
		}
		
		//Vérifie qu'il y a des chiffres pour valider
		protected void changementTextField() {
			int length = textField.getDocument().getLength();
			if(length>=1 && testInt(textField.getText())) {
				if(enoughtIngredient()) {
					btnValider.setEnabled(true);
				}
			}
			btnValider.setEnabled(false);
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
			return dialogueBoulangerie.enoughtIngredients(tableStock, text, qty);
		}
		
		//Affiche les différents types d'erreur
		public boolean errorDisplay(int numError) {
			switch (numError) {
			case 0: {
				JOptionPane.showMessageDialog(this,"L'ingrédient demandé n'existe pas","Erreur d'ingrédients",JOptionPane.ERROR_MESSAGE);
				return false;
			}case 1: {
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
			dialogueBoulangerie.stockUpdate(tableStock);
		}
		
		//Reset achat
		public void resetAchat() {
			comboBoxRecette.setSelectedIndex(0);
			textField.setText("");
		}
		
		//Reset couleurs
		public void resetColors() {
			
		}

}
