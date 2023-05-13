package presentation;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dialogue.DialogueBoulangerie;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class JFrameBoulanger extends JFrame {

	private DialogueBoulangerie dialogueBoulangerie;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblBoulanger;
	private JTable tableStock;
	private JLabel lblStock;
	private JTable tableProduit;
	private JLabel lblProduits;
	private JButton btnAcheterIngredient;
	private JButton btnCuisiner;



	/**
	 * Create the frame.
	 */
	public JFrameBoulanger() {
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
		
		lblBoulanger = new JLabel("Boulanger");
		lblBoulanger.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoulanger.setFont(new Font("Arial", Font.BOLD, 50));
		lblBoulanger.setBounds(0, 0, 1270, 119);
		panel.add(lblBoulanger);
		
		tableStock = new JTable();
		tableStock.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableStock.setRowHeight(40);
		tableStock.setRowSelectionAllowed(false);
		tableStock.setFillsViewportHeight(true);
		tableStock.setFont(new Font("Arial", Font.PLAIN, 25));
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
				"Ingredients", "Quantit\u00E9", "Unite"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableStock.getColumnModel().getColumn(1).setResizable(false);
		tableStock.setBounds(10, 238, 520, 320);
		panel.add(tableStock);
		
		lblStock = new JLabel("Stock");
		lblStock.setBackground(new Color(255, 255, 255));
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Arial", Font.PLAIN, 25));
		lblStock.setBounds(0, 187, 530, 40);
		panel.add(lblStock);
		
		tableProduit = new JTable();
		tableProduit.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableProduit.setRowHeight(40);
		tableProduit.setFillsViewportHeight(true);
		tableProduit.setRowSelectionAllowed(false);
		tableProduit.setFont(new Font("Arial", Font.PLAIN, 25));
		tableProduit.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProduit.setBounds(851, 238, 403, 119);
		panel.add(tableProduit);
		
		lblProduits = new JLabel("Produits créés");
		lblProduits.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduits.setFont(new Font("Arial", Font.PLAIN, 25));
		lblProduits.setBackground(new Color(255, 255, 255));
		lblProduits.setBounds(865, 199, 402, 40);
		panel.add(lblProduits);
		
		btnAcheterIngredient = new JButton("Acheter Ingredients");
		btnAcheterIngredient.setFont(new Font("Arial", Font.PLAIN, 50));
		btnAcheterIngredient.setBounds(10, 685, 508, 227);
		panel.add(btnAcheterIngredient);
		
		btnCuisiner = new JButton("Cuisiner");
		btnCuisiner.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCuisiner.setBounds(746, 685, 508, 227);
		panel.add(btnCuisiner);
	}
	
	//Mise des éléments de stock//
	public void stockUpdate(HashMap<String,Double> stockMap,HashMap<String,String> uniteMap) {
		int i =0;
		tableStock.getModel();
		for (HashMap.Entry<String, Double> entry : stockMap.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			String unite = uniteMap.get(key);
			tableStock.setValueAt(key, i, 0);
			tableStock.setValueAt(val, i, 1);
			tableStock.setValueAt(unite, i, 2);
			i++;
			
			
		}
	}
	
	//Mise des éléments de etalage//
		public void etalageUpdate(HashMap<String,Double> stock) {
			int i =0;
			tableProduit.getModel();
			for (HashMap.Entry<String, Double> entry : stock.entrySet()) {
				String key = entry.getKey();
				Double val = entry.getValue();
				tableProduit.setValueAt(key, i, 0);
				tableProduit.setValueAt(val, i, 1);
				i++;
				
				
			}
		}
	
	//Record reference to Dialogue
	public void setDialogue(DialogueBoulangerie dialogueBoulangerie) {
		this.dialogueBoulangerie = dialogueBoulangerie;
	}
}
