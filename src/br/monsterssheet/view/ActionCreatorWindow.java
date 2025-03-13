package br.monsterssheet.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.monsterssheet.controller.MonsterController;
import br.monsterssheet.model.entity.Action;
import br.monsterssheet.model.entity.Monster;
import br.monsterssheet.model.service.ActionService;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class ActionCreatorWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JList actions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Setar tema
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ActionCreatorWindow frame = new ActionCreatorWindow();
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
	public ActionCreatorWindow() {
		// Colocar icon
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/br/monsterssheet/view/gold_chest.png"));
		setIconImage(icon.getImage());
		setResizable(false);
		// Action Service
		ActionService service = new ActionService();
		
		setTitle("Monster Sheet - Action Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setBounds(10, 86, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(44, 32, 72, 22);
		// Adicionar os tipos de ação
		List<String> types = service.typeValues();
		for(String type : types) {
			comboBox.addItem(type);
		}
		contentPane.add(comboBox);
		
		
		textField = new JTextField();
		textField.setName("fieldName");
		textField.setBounds(44, 8, 232, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 111, 604, 319);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("Range");
		lblNewLabel_3.setBounds(126, 36, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitKeyTypedOnly(e, textField_1);
			}
		});
		textField_1.setName("fieldRange");
		textField_1.setBounds(163, 33, 46, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Legendary");
		chckbxNewCheckBox.setBounds(282, 7, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action action = new Action();
				action.setName(textField.getText());
				action.setDescription(textArea.getText());
				action.setType(comboBox.getSelectedItem().toString());
				action.setActionRange(Float.parseFloat(textField_1.getText()));
				action.setLegendary(chckbxNewCheckBox.isSelected());
				
				action.setIdMonster(0); // Apenas para adicionar a action
				
				if(!service.checkRules(action)) {
					System.out.println("Action não foi salva a lista de actions");
					return;
				}
				
				DefaultListModel<Action> listModel = scrollPane.getViewport().getView() instanceof JList ? (DefaultListModel<Action>) actions.getModel() : new DefaultListModel<Action>();
				actions = new JList<>(listModel);

				listModel.addElement(action);
				
				//scrollPane.setViewportView(actions);
				//scrollPane.getViewport().setView(actions);
			}
		});
		btnNewButton.setBounds(525, 77, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
		// Checar as actions no scrollPane
		try {
			JList actions = (JList) scrollPane.getViewport().getView();
			setList(actions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setList(JList list) {
		actions = list;
	}
	
	// Para usar em todos os campos que usam apenas numeros em JTextField
	private void digitKeyTypedOnly(KeyEvent e, JTextField t) {
		String text = t.getText();
		char c = e.getKeyChar();
	       // Permite apenas números
	       if (!Character.isDigit(c)) {
	           e.consume();  // Impede a digitação de caracteres não numéricos
	       }
	}
	
}
