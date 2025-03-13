package br.monsterssheet.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.monsterssheet.model.dao.ActionDAO;
import br.monsterssheet.model.entity.Action;

public class ActionService {
    private ActionDAO dao;
    
    public ActionService() {
        this.dao = new ActionDAO();
    }
    /*
     * Checa as regras de negócio, se de acordo com as regras retorna true, do contrário, false
     */
    public boolean checkRules(Action action) {
        if(action.getName() == null || action.getName().length() < 3) {
            System.out.println("Nome não pode ter menos de 3 caracteres ou ser nulo");
            return false;
        }

        if(action.getDescription() == null || action.getDescription().length() < 3) {
            System.out.println("Descrição não pode ter menos de 3 caracteres ou ser nulo");
            return false;
        }

        List<String> types = new ArrayList<String>();
        types = typeValues();
        String type = action.getType().toLowerCase();
        if(!types.contains(type)) {
            System.out.println("Tipo inválido, favor verificar valores possiveis");
            return false;
        }

        if(action.getActionRange() < 0) {
            System.out.println("Range não pode ser menor que 0");
            return false;
        }

        if(action.isLegendary() == null) {
            System.out.println("isLegendary não pode ser nulo");
            return false;
        }

        // cheacar se idMonster é válido
        if(action.getIdMonster() < 0) {
            System.out.println("IdMonster inválido");
            return false;
        }

        return true;
    }

    // Valores possíveis de type
    public List<String> typeValues() {
        String[] values = {"melee","ranged","area","special"};
        List<String> valuesList = new ArrayList<String>(Arrays.asList(values));
        return valuesList;
    }

    /*
     * Salva no banco de dados
     */
    public void save(Action action) {
        if (checkRules(action)) {
            dao.save(action);
        } else {
            System.out.println("Action falhou no teste de regra de negocio");
        }
    }

    /* 
     * Atualiza no banco de dados
     */
    public void update(Action action) {
        if (checkRules(action)) {
            dao.update(action);
        } else {
            System.out.println("Action falhou no teste de regra de negocio");
        }
    }

    /*
     * Lista por idMonster
     */
    public List<Action> findByIdMonster(int idMonster) {
        return dao.findByIdMonster(idMonster);
    }
    
    /*
     * Lista todos os ataques
     */
    public List<Action> listAll() {
        return dao.listAll();
    }

    /*
     * Deleta por idMonster
     */
    public void deleteByIdMonster(int idMonster) {
        dao.deleteByIdMonster(idMonster);
    }

    /*
     * Deleta por idMonster e name
     */
    public void deleteOneByIdMonster(Action action) {
        dao.deleteOneByIdMonster(action);
    }
}
