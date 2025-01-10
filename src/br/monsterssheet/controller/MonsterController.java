package br.monsterssheet.controller;

import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.model.entity.Monster;
import br.monsterssheet.model.service.MonsterService;

public class MonsterController implements IController{

    @Override
    public void execute(Object view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    /*
     * Apenas para testes
     */
    public static void main(String[] args) {
        Monster m = new Monster();
        m.setName("Rato");
        m.setType("Besta");
        m.setAlignment(null);
        m.setArmorClass(10);
        m.setHitPoints(30);
        m.setSpeed(9);
        m.setChallenge(0);
        m.setStrength(10);
        m.setDexterity(15);
        m.setConstitution(12);
        m.setIntelligence(3);
        m.setWisdom(5);
        m.setCharisma(11);
        m.setProficiencyBonus(2);

        //Checa as regras de negócio e salva no banco de dados
        MonsterService service = new MonsterService();
        //service.checkRules(m);
        //Checa se nome já existe
        Monster m2 = service.findByName("Rato");
        System.out.println("Teste concluído! Verificar MySQL! Nome: "+m2.getName()+" ArmorClass: "+m2.getArmorClass());
        List<Monster> monsters = new ArrayList<Monster>();
        monsters = service.listAll();
        for (Monster mon : monsters) {
            System.out.println(mon);
        }
    }

}
