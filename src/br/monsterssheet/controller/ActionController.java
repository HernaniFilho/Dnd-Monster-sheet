package br.monsterssheet.controller;

import java.util.List;

import br.monsterssheet.model.entity.Action;
import br.monsterssheet.model.service.ActionService;

public class ActionController implements IController {

    @Override
    public boolean execute(Object view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
    
    public boolean remove(int idMonster) {
		ActionService service = new ActionService();
		service.deleteByIdMonster(idMonster);
		return true;
	}
    /*
     * Apenas para testes
     */
    public static void main(String[] args) {
        Action action = new Action();
        action.setName("Ataque de garra");
        action.setDescription("Ataque de garra de um monstro");
        action.setType("melee");
        action.setActionRange(5);
        action.setLegendary(false);
        action.setIdMonster(7);

        // Salva no banco de dados
        ActionService service = new ActionService();
        service.save(action);

        // Atualiza entrada no banco de dados
        List<Action> actions = service.findByIdMonster(7);
        /* action.setId(actions.get(0).getId());
        //action.setId(2);
        action.setName("Ataque de mordida");
        action.setDescription("Ataque de mordida de um monstro");
        action.setType("melee");
        action.setActionRange(4);
        action.setLegendary(false);
        action.setIdMonster(7);
        service.update(action); */

        // Delete por idMonster
        /* service.deleteByIdMonster(7); */

        // Lista por idMonster
        actions = service.findByIdMonster(7);
        System.out.println("Teste procurando por idMonster");
        for (Action act : actions) {
            System.out.println(act);
        }

        // Lista todos os ataques
        /* List<Action> allActions = service.listAll();
        System.out.println("Teste listando todos os ataques");
        for (Action act : allActions) {
            System.out.println(act);
        } */
    }

}
