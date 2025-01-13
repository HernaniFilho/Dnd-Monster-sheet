package br.monsterssheet.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.monsterssheet.model.dao.MonsterDAO;
import br.monsterssheet.model.entity.Monster;

public class MonsterService {
    private MonsterDAO dao;

    public MonsterService() {
        this.dao = new MonsterDAO();
    }
    /*
     * Checa as regras de negócio, se de acordo com as regras retorna true, do contrário, false
     */
    public boolean checkRules(Monster monster) {
        if(monster.getName() == null || monster.getName().length() < 3) {
            System.out.println("Nome não pode ter menos de 3 caracteres ou ser nulo");
            return false;
        }
        List<Monster> monsters = new ArrayList<Monster>();
        monsters = findByName(monster.getName());
        for (Monster monster2 : monsters) {
            if(monster.getName() == monster2.getName()) {
                System.out.println("Nome para monstro já está sendo utilizado");
                return false;
            }
        }
        
        List<String> types = typeValues();
        String type = monster.getType().toLowerCase();
        if(!types.contains(type)) {
            System.out.println("Tipo inválido, favor verificar valores possiveis");
            return false;
        }
        List<String> challenges = challengeValues();
        String challenge = monster.getChallenge().toLowerCase();
        if (!challenges.contains(challenge)) {
            System.out.println("Valor inválido para CR, favor verificar valores possiveis");
            return false;
        }
        List<String> alignments = alignmentValues();
        String alignment = monster.getAlignment().toLowerCase();
        if (!alignments.contains(alignment)) {
            System.out.println("Valor inválido para tendência, favor verificar valores possiveis");
            return false;
        }
        
        if(monster.getHitPoints() <= 0) {
            System.out.println("Pontos de vida não pode ser 0");
            return false;
        }
        if(monster.getArmorClass() < 0) {
            System.out.println("Armadura não pode ser menor que 0");
            return false;
        }
        if (monster.getSpeed() < 0) {
            System.out.println("Velocidade não pode ser menor que 0");
            return false;
        }
        if(monster.getStrength() < 0) {
            System.out.println("Força não pode ser 0");
            return false;
        }
        if(monster.getDexterity() < 0) {
            System.out.println("Destreza não pode ser 0");
            return false;
        }
        if(monster.getConstitution() < 0) {
            System.out.println("Constituição não pode ser 0");
            return false;
        }
        if(monster.getIntelligence() < 0) {
            System.out.println("Inteligência não pode ser 0");
            return false;
        }
        if(monster.getWisdom() < 0) {
            System.out.println("Sabedoria não pode ser 0");
            return false;
        }
        if(monster.getCharisma() < 0) {
            System.out.println("Carisma não pode ser 0");
            return false;
        }
        if(monster.getProficiencyBonus() < 0) {
            System.out.println("Bonus de proeficiência não pode ser 0");
            return false;
        }
        return true;
    }
    //Valores possiveis para Challenge
    public List<String> challengeValues() {
        String[] values = {"0","1/8","1/4","1/2","2","3","4","5","6","7","8","9",
                        "10","11","12","13","14","15","16","17","18","19","20","21",
                        "22","23","24","25","26","27","28","29","30"};
        List<String> valuesList = new ArrayList<String>(Arrays.asList(values));
        return valuesList;
    }
    //Valores possiveis para Alignment
    public List<String> alignmentValues() {
        String[] values = {"lawfull good","lawfull neutral","lawfull evil",
                            "neutral good","true neutral","neutral evil",
                            "chaotic good","chaotic neutral","chaotic evil",
                            null};
        List<String> valueList = new ArrayList<String>(Arrays.asList(values));
        return valueList;

    }
    //Valores possiveis para Type
    public List<String> typeValues() {
        String[] values = {"aberration","beast","celestial","construct","dragon",
        "true dragon","lesser dragon","elemental","fey","fiend","demon","devil",
        "yugoloth","giant","true giant","giant-kin","humanoid","human","elf",
        "dwarf","monstrosity","ooze","plant","undead"};
        List<String> valueList = new ArrayList<String>(Arrays.asList(values));
        return valueList;
    }
    /*
     * Salva no banco de dados
     */
    public void save(Monster monster) {
        if (checkRules(monster)) {
            dao.save(monster);
        } else {
            System.out.println("Monster falhou na checagem das regras de negócio");
        }
    }
    /*
     * Atualiza um monstro no banco de dados
     */
    public void update(Monster monster) {
        if (checkRules(monster)) {
            dao.update(monster);
        } else {
            System.out.println("Monster falhou na checagem das regras de negócio");
        }
    }
    /*
     * Deleta um monstro pelo id no banco de dados
     */
    public void deleteById(int id) {
        dao.deleteById(id);
    }
    /*
     * Procura por nome no banco de dados
     */
    public List<Monster> findByName(String name) {
        return dao.findByName(name);
    }

    /*
     * Lista todos os monstros
     */
    public List<Monster> listAll() {
        return dao.listAll();
    }
}