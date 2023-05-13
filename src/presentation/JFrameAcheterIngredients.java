package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import dialogue.DialogueBoulangerie;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameAcheterIngredients extends JFrame {

	private DialogueBoulangerie dialogueBoulangerie;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblAcheterIngredients;
	private JTable tableStock;
	private JLabel lblStock;
	private JComboBox comboBoxIngredient;
	private JLabel lblUnite;
	private JTextField textField;
	private JButton btnValider;
	private JButton btnRetour;

	/**
	 * Create the frame.
	 */
	public JFrameAcheterIngredients() {
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
		
		lblAcheterIngredients = new JLabel("Acheter des ingrédients");
		lblAcheterIngredients.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcheterIngredients.setFont(new Font("Arial", Font.PLAIN, 40));
		lblAcheterIngredients.setBounds(370, 11, 626, 221);
		panel.add(lblAcheterIngredients);
		
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
		
		comboBoxIngredient = new JComboBox();
		comboBoxIngredient.setBounds(684, 241, 156, 36);
		panel.add(comboBoxIngredient);
		
		lblUnite = new JLabel("");
		lblUnite.setBackground(new Color(255, 255, 255));
		lblUnite.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUnite.setBounds(1044, 241, 210, 36);
		panel.add(lblUnite);
		
		textField = new JTextField();
		textField.setBounds(850, 241, 184, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Arial", Font.PLAIN, 30));
		btnValider.setBounds(850, 331, 184, 52);
		panel.add(btnValider);
		
		btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Arial", Font.PLAIN, 30));
		btnRetour.setBounds(580, 798, 260, 121);
		panel.add(btnRetour);
	}
}
