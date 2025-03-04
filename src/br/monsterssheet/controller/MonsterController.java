package br.monsterssheet.controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.monsterssheet.model.entity.Monster;
import br.monsterssheet.model.service.MonsterService;
import br.monsterssheet.view.MonsterCreatorWindow;

public class MonsterController implements IController{

    @Override
    public void execute(Object view) {
        if(view instanceof MonsterCreatorWindow) {
        	String name, type, alignment, challenge;
        	int armorClass, hitPoints, speed, strength, dexterity, constitution, intelligence, wisdom, charisma, proficiencyBonus;
        	
        	
        	MonsterCreatorWindow contentPane = (MonsterCreatorWindow)view;
        	MonsterService service = new MonsterService();
        	
        	
        	// Implementar Classe de Error futuramente
        	Component c = contentPane.findComponentByName("fieldName");
        	if(c instanceof JTextField) {
        		JTextField fieldName = (JTextField)c;
        		name = fieldName.getText();
        	} else {
        		System.out.println("fieldName não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("comboBoxType");
        	if(c instanceof JComboBox) {
        		JComboBox comboBoxType = (JComboBox)c;
        		type = comboBoxType.getSelectedItem().toString();
        	} else {
        		System.out.println("comboBoxType não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("comboBoxAlignment");
        	if(c instanceof JComboBox) {
        		JComboBox comboBoxAlignment = (JComboBox)c;
        		alignment = comboBoxAlignment.getSelectedItem().toString();
        	} else {
        		System.out.println("comboBoxAlignment não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("comboBoxChallenge");
        	if(c instanceof JComboBox) {
        		JComboBox comboBoxChallenge = (JComboBox)c;
        		challenge = comboBoxChallenge.getSelectedItem().toString();
        	} else {
        		System.out.println("comboBoxChallenge não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldArmor");
        	if(c instanceof JTextField) {
        		JTextField fieldArmor = (JTextField)c;
        		armorClass = Integer.parseInt(fieldArmor.getText());
        	} else {
        		System.out.println("fieldArmor não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldHitPoints");
        	if(c instanceof JTextField) {
        		JTextField fieldHitPoints = (JTextField)c;
        		hitPoints = Integer.parseInt(fieldHitPoints.getText());
        	} else {
        		System.out.println("fieldHitPoints não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldSpeed");
        	if(c instanceof JTextField) {
        		JTextField fieldSpeed = (JTextField)c;
        		speed = Integer.parseInt(fieldSpeed.getText());
        	} else {
        		System.out.println("fieldSpeed não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldStrength");
        	if(c instanceof JTextField) {
        		JTextField fieldStrength = (JTextField)c;
        		strength = Integer.parseInt(fieldStrength.getText());
        	} else {
        		System.out.println("fieldStrength não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldDexterity");
        	if(c instanceof JTextField) {
        		JTextField fieldDexterity = (JTextField)c;
        		dexterity = Integer.parseInt(fieldDexterity.getText());
        	} else {
        		System.out.println("fieldDexterity não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldConstitution");
        	if(c instanceof JTextField) {
        		JTextField fieldConstitution = (JTextField)c;
        		constitution = Integer.parseInt(fieldConstitution.getText());
        	} else {
        		System.out.println("fieldConstitution não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldInteligence");
        	if(c instanceof JTextField) {
        		JTextField fieldInteligence = (JTextField)c;
        		intelligence = Integer.parseInt(fieldInteligence.getText());
        	} else {
        		System.out.println("fieldInteligence não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldWisdom");
        	if(c instanceof JTextField) {
        		JTextField fieldWisdom = (JTextField)c;
        		wisdom = Integer.parseInt(fieldWisdom.getText());
        	} else {
        		System.out.println("fieldWisdom não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("fieldCharisma");
        	if(c instanceof JTextField) {
        		JTextField fieldCharisma = (JTextField)c;
        		charisma = Integer.parseInt(fieldCharisma.getText());
        	} else {
        		System.out.println("fieldCharisma não existe");
        		return;
        	}
        	
        	c = contentPane.findComponentByName("spinnerProficiency");
        	if(c instanceof JSpinner) {
        		JSpinner spinnerProficiency = (JSpinner)c;
        		proficiencyBonus = (Integer) spinnerProficiency.getValue();
        	} else {
        		System.out.println("spinnerProficiency não existe");
        		return;
        	}
        	// Checar outros atributos aqui e depois detá-los corretamente no banco de dados, i.e languages, savingThrows, actions
        	
        	
        	
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
        	
        	int idMonster = service.save(m);
        }
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
