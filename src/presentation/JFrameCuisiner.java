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

public class JFrameCuisiner extends JFrame {

	private DialogueBoulangerie dialogueBoulangerie;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCuisiner;
	private JLabel lblStock;
	private JComboBox comboBoxRecette;
	private JLabel lblUnite;
	private JTextField textField;
	private JButton btnValider;
	private JButton btnRetour;
	private JTable table_0;
	private JTable table_1;
	private JTable table_3;
	private JTable table_2;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private ArrayList<JTable> tables;

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
		
		lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Arial", Font.PLAIN, 25));
		lblStock.setBackground(Color.WHITE);
		lblStock.setBounds(10, 202, 530, 40);
		panel.add(lblStock);
		
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
		
		table_0 = new JTable();
		table_0.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_0.setRowSelectionAllowed(false);
		table_0.setRowHeight(40);
		table_0.setFont(new Font("Arial", Font.PLAIN, 25));
		table_0.setFillsViewportHeight(true);
		table_0.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_0.setBounds(10, 244, 520, 40);
		panel.add(table_0);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setRowSelectionAllowed(false);
		table_1.setRowHeight(40);
		table_1.setFont(new Font("Arial", Font.PLAIN, 25));
		table_1.setFillsViewportHeight(true);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(10, 283, 520, 40);
		panel.add(table_1);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_3.setRowSelectionAllowed(false);
		table_3.setRowHeight(40);
		table_3.setFont(new Font("Arial", Font.PLAIN, 25));
		table_3.setFillsViewportHeight(true);
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setBounds(10, 362, 520, 40);
		panel.add(table_3);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.setRowSelectionAllowed(false);
		table_2.setRowHeight(40);
		table_2.setFont(new Font("Arial", Font.PLAIN, 25));
		table_2.setFillsViewportHeight(true);
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setBounds(10, 323, 520, 40);
		panel.add(table_2);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_4.setRowSelectionAllowed(false);
		table_4.setRowHeight(40);
		table_4.setFont(new Font("Arial", Font.PLAIN, 25));
		table_4.setFillsViewportHeight(true);
		table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_4.setBounds(10, 402, 520, 40);
		panel.add(table_4);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_5.setRowSelectionAllowed(false);
		table_5.setRowHeight(40);
		table_5.setFont(new Font("Arial", Font.PLAIN, 25));
		table_5.setFillsViewportHeight(true);
		table_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_5.setBounds(10, 441, 520, 40);
		panel.add(table_5);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_6.setRowSelectionAllowed(false);
		table_6.setRowHeight(40);
		table_6.setFont(new Font("Arial", Font.PLAIN, 25));
		table_6.setFillsViewportHeight(true);
		table_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_6.setBounds(10, 481, 520, 40);
		panel.add(table_6);
		
		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Ingrd\u00E9dient", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_7.setRowSelectionAllowed(false);
		table_7.setRowHeight(40);
		table_7.setFont(new Font("Arial", Font.PLAIN, 25));
		table_7.setFillsViewportHeight(true);
		table_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_7.setBounds(10, 520, 520, 40);
		panel.add(table_7);
	}
	
	
	
	//===============//
	//Intitialisation//
	//===============//
	
	public void initialisation(DialogueBoulangerie dialogue) {
		this.dialogueBoulangerie = dialogue;
		dialogueBoulangerie.comboBoxProduitsUpdate(comboBoxRecette);
		btnValider.setEnabled(false);
		comboBoxRecette.setSelectedIndex(0);
		textField.setText("");
		arrayInit();
		dialogueBoulangerie.stockArrayUpdate(tables);
		resetColors();
	}
	
	//Initialiste la arrayList de table
	private void arrayInit(){
		this.tables = new ArrayList<>();
		this.tables.add(table_0);
		this.tables.add(table_1);
		this.tables.add(table_2);
		this.tables.add(table_3);
		this.tables.add(table_4);
		this.tables.add(table_5);
		this.tables.add(table_6);
		this.tables.add(table_7);	
	}
			
	
	//===================//
	//Les boutons cliqués//
	//===================//
	
	protected void do_btnRetour_actionPerformed(ActionEvent e) {
		resetColors();
		btnValider.setEnabled(false);
		dialogueBoulangerie.retour(this);
	}

	protected void do_btnValider_actionPerformed(ActionEvent e) {
		String recette = comboBoxRecette.getItemAt(comboBoxRecette.getSelectedIndex()).toString();
		int qty = Integer.parseInt(textField.getText());
		dialogueBoulangerie.depenseIngredients(recette,qty);
	}
	
	protected void do_comboBoxRecette_actionPerformed(ActionEvent e) {
		changementTextField();
	}
	
	
	
	//============//
	//Les Méthodes//
	//============//
	
	//Vérifie qu'il y a des chiffres pour valider
	public void changementTextField() {
		int length = textField.getDocument().getLength();
		if(length>=1 && dialogueBoulangerie.testInteger(textField.getText())) {
			btnValider.setEnabled(enoughtIngredient());
		}else {
			btnValider.setEnabled(false);
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
	
}
