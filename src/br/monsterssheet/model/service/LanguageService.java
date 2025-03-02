package br.monsterssheet.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.monsterssheet.model.dao.LanguageDAO;
import br.monsterssheet.model.entity.Language;

public class LanguageService {
    private LanguageDAO dao;

    public LanguageService() {
        this.dao = new LanguageDAO();
    }

    public boolean checkRules(Language language) {
        List<String> languages = new ArrayList<String>();
        languages = languageValues();
        String name = language.getName().toLowerCase();
        if (!languages.contains(name)) {
            System.out.println("Nome de lingua inválido");
            return false;
        }

        // cheacar se idMonster é válido
        if (language.getIdMonster() <= 0) {
            System.out.println("IdMonster inválido");
            return false;
        }

        return true;
    }

    // Valores possíveis de name
    public List<String> languageValues() {
        String[] values = {"common","dwarvish","elvish","giant","gnomish","goblin","halfling","orc",
                            "abyssal","celestial","draconic","deep speech","infernal","primordial",
                            "sylvan","undercommon"};

        List<String> valuesList = new ArrayList<String>(Arrays.asList(values));
        return valuesList;
    }

    /*
     * Salva no banco de dados
     */
    public void save(Language language) {
        if (checkRules(language)) {
            dao.save(language);
        } else {
            System.out.println("Language falhou no teste de regra de negocio");
        }
    }

    /*
     * Lista por idMonster
     */
    public List<Language> findByIdMonster(int idMonster) {
        return dao.findByIdMonster(idMonster);
    }

    /*
     * Lista por name
     */
    public List<Language> findByName(Language language) {
        if (checkRules(language)) {
            return dao.findByName(language);
        } else {
            System.out.println("Language falhou no teste de regra de negocio");
            return null;
        }
    }

    /*
     * Lista todas as Languages ordenado por nome
     */
    public List<Language> listAll() {
        return dao.listAll();
    }

    /*
     * Deleta por idMonster
     */
    public void deleteByIdMonster(int idMonster) {
        dao.deleteByIdMonster(idMonster);
    }
    /*
     * Deleta uma language de um Monster
     */
    public void deleteOneByIdMonster(Language language) {
        if(checkRules(language)) {
            dao.deleteOneByIdMonster(language);
        } else {
            System.out.println("Language falhou no teste das regras de negocio");
        }
    }
    /*
     * Deleta uma language do banco de dados
     */
    public void deleteByName(String name) {
        List<String> languages = languageValues();
        if(languages.contains(name)) {
            dao.deleteByName(name);
        } else {
            System.out.println("Language para a remoção inválida");
        }
        
    }
}