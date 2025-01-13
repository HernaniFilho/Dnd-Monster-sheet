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
