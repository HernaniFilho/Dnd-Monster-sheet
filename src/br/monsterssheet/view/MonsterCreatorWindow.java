package br.monsterssheet.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.monsterssheet.controller.MonsterController;
import br.monsterssheet.model.service.LanguageService;
import br.monsterssheet.model.service.MonsterService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MonsterCreatorWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Setar tema
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MonsterCreatorWindow frame = new MonsterCreatorWindow();
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
	public MonsterCreatorWindow() {
		// Monster Controller
		MonsterController controller = new MonsterController();
		// Monster Service
		MonsterService service = new MonsterService();
		// Language Service
		LanguageService languageService = new LanguageService();
		// Colocar icon
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/br/monsterssheet/view/gold_chest.png"));
		setIconImage(icon.getImage());
		setTitle("Monster Sheet - Monster Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setName("fieldName");
		textField.setBounds(10, 30, 310, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(10, 61, 24, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alignment");
		lblNewLabel_2.setBounds(157, 61, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Armor Class");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(6, 111, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hit Points");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(115, 111, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Speed");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(238, 111, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Challenge Rating");
		lblNewLabel_6.setBounds(157, 86, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("STRENGTH");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 211, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("DEXTERITY");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(106, 211, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CONSTITUTION");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(202, 211, 118, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("INTELIGENCE");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(330, 211, 108, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("WISDOM");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(448, 211, 68, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("CHARISMA");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_12.setBounds(526, 211, 86, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Proeficiency Bonus");
		lblNewLabel_13.setBounds(10, 86, 95, 14);
		contentPane.add(lblNewLabel_13);
		
		JPanel panel = new JPanel();
		panel.setBounds(19, 297, 68, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("<html>Saving<br>Throw</html>");
		lblNewLabel_14.setBounds(16, 24, 32, 28);
		panel.add(lblNewLabel_14);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(22, 5, 21, 21);
		panel.add(chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(115, 297, 68, 63);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_14_1 = new JLabel("<html>Saving<br>Throw</html>");
		lblNewLabel_14_1.setBounds(16, 24, 32, 28);
		panel_1.add(lblNewLabel_14_1);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("");
		chckbxNewCheckBox_6.setBounds(22, 5, 21, 21);
		panel_1.add(chckbxNewCheckBox_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(227, 297, 68, 63);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_14_2 = new JLabel("<html>Saving<br>Throw</html>");
		lblNewLabel_14_2.setBounds(16, 24, 32, 28);
		panel_2.add(lblNewLabel_14_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(22, 5, 21, 21);
		panel_2.add(chckbxNewCheckBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(350, 297, 68, 63);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_14_3 = new JLabel("<html>Saving<br>Throw</html>");
		lblNewLabel_14_3.setBounds(16, 24, 32, 28);
		panel_3.add(lblNewLabel_14_3);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(22, 5, 21, 21);
		panel_3.add(chckbxNewCheckBox_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(448, 297, 68, 63);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_14_4 = new JLabel("<html>Saving<br>Throw</html>");
		lblNewLabel_14_4.setBounds(16, 24, 32, 28);
		panel_4.add(lblNewLabel_14_4);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(22, 5, 21, 21);
		panel_4.add(chckbxNewCheckBox_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(535, 297, 68, 63);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_14_5 = new JLabel("<html>Saving<br>Throw</html>");
		lblNewLabel_14_5.setBounds(16, 24, 32, 28);
		panel_5.add(lblNewLabel_14_5);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		chckbxNewCheckBox_4.setBounds(22, 5, 21, 21);
		panel_5.add(chckbxNewCheckBox_4);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_1);
			}
		});
		textField_1.setName("fieldStrength");
		textField_1.setBounds(28, 241, 50, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_2);
			}
		});
		textField_2.setName("fieldDexterity");
		textField_2.setColumns(10);
		textField_2.setBounds(124, 236, 50, 50);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_3);
			}
		});
		textField_3.setName("fieldConstitution");
		textField_3.setColumns(10);
		textField_3.setBounds(236, 236, 50, 50);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_4);
			}
		});
		textField_4.setName("fieldInteligence");
		textField_4.setColumns(10);
		textField_4.setBounds(359, 236, 50, 50);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_5);
			}
		});
		textField_5.setName("fieldWisdom");
		textField_5.setColumns(10);
		textField_5.setBounds(457, 236, 50, 50);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_6);
			}
		});
		textField_6.setName("fieldCharisma");
		textField_6.setColumns(10);
		textField_6.setBounds(544, 236, 50, 50);
		contentPane.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setName("comboBoxType");
		comboBox.setBounds(42, 57, 105, 22);
		// Types dos Monstros
		List<String> types = service.typeValues();
		for(String type: types) {
			comboBox.addItem(type);
		}
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setName("comboBoxAlignment");
		// Alignment dos Monstros
		List<String> alignments = service.alignmentValues();
		for(String alignment: alignments) {
			comboBox_1.addItem(alignment);
		}
		comboBox_1.setBounds(213, 57, 107, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setName("comboBoxChallenge");
		// Challenge dos Monstros
		List<String> challenges = service.challengeValues();
		for(String challenge: challenges) {
			comboBox_2.addItem(challenge);
		}
		comboBox_2.setBounds(252, 82, 68, 22);
		contentPane.add(comboBox_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_7);
			}
		});
		textField_7.setName("fieldArmor");
		textField_7.setColumns(10);
		textField_7.setBounds(28, 133, 50, 50);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_8);
			}
		});
		textField_8.setName("fieldHitPoints");
		textField_8.setColumns(10);
		textField_8.setBounds(124, 133, 50, 50);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e,textField_9);
			}
		});
		textField_9.setName("fieldSpeed");
		textField_9.setColumns(10);
		textField_9.setBounds(236, 133, 50, 50);
		contentPane.add(textField_9);
		
		// Proficiency dos Monstros
		List<Integer> proficiencies = service.proficiencyBonusValues();
		int min = proficiencies.getFirst();
		int max = proficiencies.getLast();
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(min,min,max,1));
		spinner.setName("spinnerProficiency");
		spinner.setBounds(106, 83, 41, 20);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("Add Action...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionCreatorWindow actionCreatorWindow =  new ActionCreatorWindow();
				actionCreatorWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				actionCreatorWindow.setLocationRelativeTo(actionCreatorWindow);
				actionCreatorWindow.setVisible(true);
			}
		});
		btnNewButton.setBounds(457, 133, 155, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove Action...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(457, 160, 155, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_15 = new JLabel("Languages");
		lblNewLabel_15.setBounds(334, 11, 84, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Actions");
		lblNewLabel_16.setBounds(461, 11, 46, 14);
		contentPane.add(lblNewLabel_16);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(controller.execute(contentPane)) {
						System.out.println("Monster criado com sucesso");
						dispose();
					} else {
						System.out.println("Erro ao criar monstro");
					}
				} catch(Exception ex) {
					System.out.println("Exception ao criar monstro");
				}
			}
		});
		btnNewButton_2.setBounds(267, 393, 89, 23);
		contentPane.add(btnNewButton_2);
		
		// Adicionando as linguagens
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		List<String> languages = languageService.languageValues();
		for(String language: languages) {
			listModel.addElement(language);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 30, 108, 151);
		scrollPane.setName("scrollPaneLanguages");
		contentPane.add(scrollPane);
		JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		list.setName("listLanguages");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setName("scrollPaneActions");
		scrollPane_1.setBounds(457, 30, 155, 92);
		contentPane.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		list_1.setName("listActions");
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	// Para usar em todos os campos que usam apenas numeros em JTextField
	private void digitKeyTypedOnly(KeyEvent e, JTextField t) {
		String text = t.getText();
		char c = e.getKeyChar();
        // Permite apenas números
        if (text.length() >= 2 | !Character.isDigit(c)) {
            e.consume();  // Impede a digitação de caracteres não numéricos
        }
	}
}
