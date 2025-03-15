package br.monsterssheet.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.monsterssheet.model.entity.Action;
import br.monsterssheet.model.entity.Monster;
import br.monsterssheet.model.entity.SavingThrow;
import br.monsterssheet.model.service.MonsterService;
import br.monsterssheet.view.MonsterCreatorWindow;

public class MonsterController implements IController{

    @Override
    public boolean execute(Object view) {
        if(view instanceof JPanel) {
        	String name, type, alignment, challenge;
        	int armorClass, hitPoints, speed, strength, dexterity, constitution, intelligence, wisdom, charisma, proficiencyBonus;
        	List<String> languages = new ArrayList<String>();
        	List<Action> actions = new ArrayList<Action>();
        	List<SavingThrow> savingThrows = new ArrayList<SavingThrow>();
        	
        	JPanel contentPane = (JPanel)view;
        	MonsterService service = new MonsterService();
        	LanguageController languageController = new LanguageController();
        	ActionController actionController = new ActionController();
        	SavingThrowController savingThrowController = new SavingThrowController();
        	
        	// Implementar Classe de Error futuramente
        	Component c = IController.findComponentByName("fieldName", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldName = (JTextField)c;
        		name = fieldName.getText();
        	} else {
        		System.out.println("fieldName não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("comboBoxType", contentPane);
        	if(c instanceof JComboBox) {
        		JComboBox comboBoxType = (JComboBox)c;
        		type = comboBoxType.getSelectedItem().toString();
        	} else {
        		System.out.println("comboBoxType não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("comboBoxAlignment", contentPane);
        	if(c instanceof JComboBox) {
        		JComboBox comboBoxAlignment = (JComboBox)c;
        		alignment = comboBoxAlignment.getSelectedItem().toString();
        	} else {
        		System.out.println("comboBoxAlignment não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("comboBoxChallenge", contentPane);
        	if(c instanceof JComboBox) {
        		JComboBox comboBoxChallenge = (JComboBox)c;
        		challenge = comboBoxChallenge.getSelectedItem().toString();
        	} else {
        		System.out.println("comboBoxChallenge não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldArmor", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldArmor = (JTextField)c;
        		armorClass = Integer.parseInt(fieldArmor.getText());
        	} else {
        		System.out.println("fieldArmor não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldHitPoints", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldHitPoints = (JTextField)c;
        		hitPoints = Integer.parseInt(fieldHitPoints.getText());
        	} else {
        		System.out.println("fieldHitPoints não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldSpeed", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldSpeed = (JTextField)c;
        		speed = Integer.parseInt(fieldSpeed.getText());
        	} else {
        		System.out.println("fieldSpeed não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldStrength", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldStrength = (JTextField)c;
        		strength = Integer.parseInt(fieldStrength.getText());
        	} else {
        		System.out.println("fieldStrength não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldDexterity", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldDexterity = (JTextField)c;
        		dexterity = Integer.parseInt(fieldDexterity.getText());
        	} else {
        		System.out.println("fieldDexterity não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldConstitution", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldConstitution = (JTextField)c;
        		constitution = Integer.parseInt(fieldConstitution.getText());
        	} else {
        		System.out.println("fieldConstitution não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldInteligence", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldInteligence = (JTextField)c;
        		intelligence = Integer.parseInt(fieldInteligence.getText());
        	} else {
        		System.out.println("fieldInteligence não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldWisdom", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldWisdom = (JTextField)c;
        		wisdom = Integer.parseInt(fieldWisdom.getText());
        	} else {
        		System.out.println("fieldWisdom não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("fieldCharisma", contentPane);
        	if(c instanceof JTextField) {
        		JTextField fieldCharisma = (JTextField)c;
        		charisma = Integer.parseInt(fieldCharisma.getText());
        	} else {
        		System.out.println("fieldCharisma não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("spinnerProficiency", contentPane);
        	if(c instanceof JSpinner) {
        		JSpinner spinnerProficiency = (JSpinner)c;
        		proficiencyBonus = (Integer) spinnerProficiency.getValue();
        	} else {
        		System.out.println("spinnerProficiency não existe");
        		return false;
        	}
        	// Checar outros atributos aqui e depois detá-los corretamente no banco de dados, i.e languages, savingThrows, actions
        	// Languages
        	c = IController.findComponentByName("scrollPaneLanguages", contentPane);
        	if(c instanceof JScrollPane) {
        		JScrollPane scrollPaneLanguages = (JScrollPane)c;
        		if(scrollPaneLanguages.getViewport().getView() instanceof JList) {
        			// Talvez mudar para DefaultListModel<String> listModel = (DefaultListModel<String>) ((JList<?>) scrollPaneLanguages.getViewport().getView()).getModel();
					JList<String> listLanguages = (JList)scrollPaneLanguages.getViewport().getView();
					languages = listLanguages.getSelectedValuesList();
				} else {
					System.out.println("listLanguages não existe");
					return false;
				}
        	} else {
        		System.out.println("scrollPaneLanguages não existe");
        		return false;
        	}
        	// Actions
        	c = IController.findComponentByName("scrollPaneActions", contentPane);
        	if(c instanceof JScrollPane) {
        		JScrollPane scrollPaneActions = (JScrollPane)c;
        		if(scrollPaneActions.getViewport().getView() instanceof JList) {
        			DefaultListModel<Action> listModel = (DefaultListModel<Action>) ((JList<?>) scrollPaneActions.getViewport().getView()).getModel();
    				for (int i = 0; i < listModel.getSize(); i++) {
						Action action = listModel.getElementAt(i);
						actions.add(action);
					}
				} else {
					System.out.println("listActions não existe");
					return false;
				}
        	} else {
        		System.out.println("scrollPaneActions não existe");
        		return false;
        	}
        	// SavingThrows
        	c = IController.findComponentByName("checkboxStrength", contentPane);
        	if(c instanceof JCheckBox) {
        		if(((JCheckBox)c).isSelected()) {
					SavingThrow savingThrow = new SavingThrow();
					savingThrow.setAbilityScore("Strength");
					savingThrows.add(savingThrow);
				}
        	} else {
        		System.out.println("checkboxStrength não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("checkboxDexterity", contentPane);
        	if(c instanceof JCheckBox) {
        		if(((JCheckBox)c).isSelected()) {
        			SavingThrow savingThrow = new SavingThrow();
        			savingThrow.setAbilityScore("Dexterity");
        			savingThrows.add(savingThrow);
        		}
        	} else {
        		System.out.println("checkboxDexterity não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("checkboxConstitution", contentPane);
        	if(c instanceof JCheckBox) {
        		if(((JCheckBox)c).isSelected()) {
					SavingThrow savingThrow = new SavingThrow();
					savingThrow.setAbilityScore("Constitution");
					savingThrows.add(savingThrow);
				}
        	} else {
        		System.out.println("checkboxConstitution não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("checkboxInteligence", contentPane);
        	if(c instanceof JCheckBox) {
        		if(((JCheckBox)c).isSelected()) {
        			SavingThrow savingThrow = new SavingThrow();
        			savingThrow.setAbilityScore("Inteligence");
        			savingThrows.add(savingThrow);
        		}
        	} else {
        		System.out.println("checkboxInteligence não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("checkboxWisdom", contentPane);
        	if(c instanceof JCheckBox) {
        		if(((JCheckBox)c).isSelected()) {
					SavingThrow savingThrow = new SavingThrow();
					savingThrow.setAbilityScore("Wisdom");
					savingThrows.add(savingThrow);
				}
        	} else {
        		System.out.println("checkboxWisdom não existe");
        		return false;
        	}
        	
        	c = IController.findComponentByName("checkboxCharisma", contentPane);
        	if(c instanceof JCheckBox) {
        		if(((JCheckBox)c).isSelected()) {
					SavingThrow savingThrow = new SavingThrow();
					savingThrow.setAbilityScore("Charisma");
					savingThrows.add(savingThrow);
				}
        	} else {
        		System.out.println("checkboxCharisma não existe");
        		return false;
        	}
        	
        	
        	// Setar os atributos do monstro
        	Monster m = new Monster();
        	m.setName(name);
        	m.setType(type);
        	m.setAlignment(alignment);
        	m.setArmorClass(armorClass);
        	m.setHitPoints(hitPoints);
        	m.setSpeed(speed);
        	m.setChallenge(challenge);
        	m.setStrength(strength);
        	m.setDexterity(dexterity);
        	m.setConstitution(constitution);
        	m.setIntelligence(intelligence);
        	m.setWisdom(wisdom);
        	m.setCharisma(charisma);
        	m.setProficiencyBonus(proficiencyBonus);
        	// Salva no banco de dados
        	int idMonster = service.save(m);
        	// Salva languages
        	if(languages.size() > 0)
				languageController.save(idMonster, languages);
        	//languageController.save(idMonster, languages);
        	// Salva actions
        	if(actions.size() > 0)
        		actionController.save(idMonster, actions);
        	//actionController.save(idMonster, actions);
        	// Salva savingThrows
        	if(savingThrows.size() > 0)
				savingThrowController.save(idMonster, savingThrows);
        	//savingThrowController.save(idMonster, savingThrows);
        	return true;
        }
        return false;
    }
    
    public boolean remove(String monsterName) {
		MonsterService service = new MonsterService();
		List<Monster> monsters = service.findByName(monsterName);
		if(monsters.size() == 0) {
			System.out.println("Monster não encontrado");
			return false;
		}
		Monster monster = monsters.get(0);
		// Remover languages
		LanguageController languageController = new LanguageController();
		languageController.remove(monster.getId());
		// Remover savingThrows
		SavingThrowController savingThrowController = new SavingThrowController();
		savingThrowController.remove(monster.getId());
		// Remover actions
		ActionController actionController = new ActionController();
		actionController.remove(monster.getId());
		// Remover monster
		service.deleteById(monster.getId());
		return true;
	}
    

    /*
     * Apenas para testes
     */
    public static void main(String[] args) {
        Monster m = new Monster();
        /* m.setName("Rato");
        m.setType("Beast");
        m.setAlignment("");
        m.setArmorClass(10);
        m.setHitPoints(30);
        m.setSpeed(9);
        m.setChallenge("0");
        m.setStrength(10);
        m.setDexterity(15);
        m.setConstitution(12);
        m.setIntelligence(3);
        m.setWisdom(5);
        m.setCharisma(11);
        m.setProficiencyBonus(2); */

        //Checa as regras de negócio e salva no banco de dados
        MonsterService service = new MonsterService();
        /* int idMonster = service.save(m);
        System.out.println("Id recebido: "+idMonster); */
        
        //Checa se nome já existe
        /* List<Monster> monsters = service.findByName("Rato");
        System.out.println("Teste procurando por nome");
        for (Monster mon : monsters) {
            System.out.println(mon);
        } */

        //Atualiza entrada no banco de dados
        /* m.setName("Rato");
        m.setType("Beast");
        m.setAlignment("True neutral");
        m.setArmorClass(10);
        m.setHitPoints(30);
        m.setSpeed(9);
        m.setChallenge("0");
        m.setStrength(10);
        m.setDexterity(15);
        m.setConstitution(12);
        m.setIntelligence(3);
        m.setWisdom(5);
        m.setCharisma(11);
        m.setProficiencyBonus(2);
        m.setId(3);

        service.update(m); */

        //Deleta uma entrada no banco de dados
        /* service.deleteById(7); */

        //Listando todos os monstros
        List<Monster> monsters2 = new ArrayList<Monster>();
        monsters2 = service.listAll();
        System.out.println("Listando todos os monstros");
        for (Monster mon : monsters2) {
            System.out.println(mon);
        }


        System.out.println("Teste concluído! Verificar MySQL!");
    }

}
