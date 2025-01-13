package br.monsterssheet.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.monsterssheet.model.dao.SavingThrowDAO;
import br.monsterssheet.model.entity.SavingThrow;

public class SavingThrowService {
    private SavingThrowDAO dao;

    public SavingThrowService() {
        this.dao = new SavingThrowDAO();
    }
    /*
     * Checa regras de negócio
     */
    public boolean checkRules(SavingThrow savingThrow) {
        List<String> abilityScores = abilityScoreValues();
        String abilityScore = savingThrow.getAbilityScore().toLowerCase();
        if(!abilityScores.contains(abilityScore)) {
            System.out.println("Salvaguarda inválida");
            return false;
        }
        return true;
    }

    // Valores possiveis para abilityScore
    public List<String> abilityScoreValues() {
        String[] values = {"strength","dexterity","constitution","intelligence","wisdom","charisma"};

        List<String> valueList = new ArrayList<String>(Arrays.asList(values));
        return valueList;
    }

    /*
     * Salva no banco de dados
     */
    public void save(SavingThrow savingThrow) {
        if(checkRules(savingThrow)) {
            dao.save(savingThrow);
        } else {
            System.out.println("SavingThrow falhou na checagem das regras de negócio");
        }
    }

    /*
     * Procura pelo idMonster
     */
    public List<SavingThrow> findByIdMonster(int idMonster) {
        return dao.findByIdMonster(idMonster);
    }

    /*
     * Deleta por idMonster
     */
    public void deleteByIdMonster(int idMonster) {
        dao.deleteByIdMonster(idMonster);
    }

    /*
     * Deleta apenas um abilityScore do Monster
     */
    public void deleteOneByIdMonster(SavingThrow savingThrow) {
        if(checkRules(savingThrow)) {
            dao.deleteOneByIdMonster(savingThrow);
        } else {
            System.out.println("SavingThrow falhou no teste de regra de negocio");
        }
    }
}
