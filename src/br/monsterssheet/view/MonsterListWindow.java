package br.monsterssheet.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.monsterssheet.model.MonsterListTable;
import br.monsterssheet.model.entity.Monster;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MonsterListWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	private static List<Monster> monsters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Setar tema
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MonsterListWindow frame = new MonsterListWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MonsterListWindow() {
		// Colocar icon
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/gold_chest.png"));
		setIconImage(icon.getImage());
		setTitle("Monster Sheet - Monster List");
		// Teste da Tabela
		monsters = new ArrayList<Monster>();
		Monster m1 = new Monster();
		Monster m2 = new Monster();
		
		m1.setName("Ratonilson");
		m1.setHitPoints(50);
		m1.setArmorClass(12);
		m1.setChallenge("1/2");
		m1.setType("Beast");
		m1.setAlignment("True Neutral");
		
		m2.setName("Rato Borrachudo");
		m2.setHitPoints(100);
		m2.setArmorClass(16);
		m2.setChallenge("2");
		m2.setType("Beast");
		m2.setAlignment("Chaotic Neutral");
		
		monsters.add(m1);
		monsters.add(m2);
		// Fim do teste da tabela
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 294, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Challenge Rating");
		lblNewLabel_2.setBounds(10, 57, 88, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 71, 88, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Monster type");
		lblNewLabel_3.setBounds(108, 57, 98, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(108, 71, 98, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("Alignment");
		lblNewLabel_4.setBounds(216, 57, 88, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(216, 71, 88, 22);
		contentPane.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Add...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(314, 24, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(422, 24, 98, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 604, 326);
		contentPane.add(scrollPane);
		
		// Modelo tabela
		MonsterListTable modelo = new MonsterListTable(monsters);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		// Impedir reordenação das colunas
        table.getTableHeader().setReorderingAllowed(false);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Name", "Hit Points", "Armor Class", "Challenge Rating", "Type", "Alignment"
//			}
//		));
//		table.getColumnModel().getColumn(3).setPreferredWidth(94);
//		table.getColumnModel().getColumn(3).setMinWidth(20);
        
	}
}
