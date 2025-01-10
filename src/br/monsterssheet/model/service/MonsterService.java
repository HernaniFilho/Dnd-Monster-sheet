package br.monsterssheet.model.service;

import java.util.List;

import br.monsterssheet.model.dao.MonsterDAO;
import br.monsterssheet.model.entity.Monster;

public class MonsterService {
    private MonsterDAO dao;

    public MonsterService() {
        this.dao = new MonsterDAO();
    }
    /*
     * Checa as regras de negócio e salva no banco de dados
     */
    public void checkRules(Monster monster) {
        if(monster.getName() == null || monster.getName().length() < 3) {
            System.out.println("Nome não pode ter menos de 3 caracteres ou ser nulo");
            return;
        }
        Monster m = new Monster();
        m = findByName(monster.getName());
        if(monster.getName() == m.getName()) {
            System.out.println("Nome para monstro já está sendo utilizado");
            return;
        }
        if(monster.getType() == null) {
            System.out.println("Tipo não pode ser nulo");
            return;
        }
        if(monster.getHitPoints() == 0) {
            System.out.println("Pontos de vida não pode ser 0");
            return;
        }
        if(monster.getStrength() == 0) {
            System.out.println("Força não pode ser 0");
            return;
        }
        if(monster.getDexterity() == 0) {
            System.out.println("Destreza não pode ser 0");
            return;
        }
        if(monster.getConstitution() == 0) {
            System.out.println("Constituição não pode ser 0");
            return;
        }
        if(monster.getIntelligence() == 0) {
            System.out.println("Inteligência não pode ser 0");
            return;
        }
        if(monster.getWisdom() == 0) {
            System.out.println("Sabedoria não pode ser 0");
            return;
        }
        if(monster.getCharisma() == 0) {
            System.out.println("Carisma não pode ser 0");
            return;
        }
        if(monster.getProficiencyBonus() == 0) {
            System.out.println("Bonus de proeficiência não pode ser 0");
            return;
        }
        save(monster);
    }
    /*
     * Salva no banco de dados
     */
    public void save(Monster monster) {
        dao.save(monster);
    }

    /*
     * Procura por nome no banco de dados
     */
    public Monster findByName(String name) {
        return dao.findByName(name);
    }

    /*
     * Lista todos os monstros
     */
    public List<Monster> listAll() {
        return dao.listAll();
    }
}