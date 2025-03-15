package br.monsterssheet.controller;

import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.model.entity.SavingThrow;
import br.monsterssheet.model.service.SavingThrowService;

public class SavingThrowController implements IController{

    @Override
    public boolean execute(Object view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
    public boolean save(int idMonster, List<SavingThrow> savingThrows) {
		SavingThrowService service = new SavingThrowService();
		for (SavingThrow savingThrow : savingThrows) {
			savingThrow.setIdMonster(idMonster);
			service.save(savingThrow);
		}
		return true;
	}
    
    public boolean remove(int idMonster) {
		SavingThrowService service = new SavingThrowService();
		service.deleteByIdMonster(idMonster);
		return true;
	}
    
    /*
     * Apenas para testes
     */
    public static void main(String[] args) {
        SavingThrow s = new SavingThrow();
        // Setar valores
        s.setIdMonster(7);
        /* s.setAbilityScore("strenght"); */

        // Salvar
        SavingThrowService service = new SavingThrowService();
        String abilityScore = service.abilityScoreValues().get(0);
        s.setAbilityScore(abilityScore);
        service.save(s);

        // Atualizar
        /* service.update(s); */

        // Deletar por idMonster
        /* service.deleteByIdMonster(7); */

        // Listar por idMonster
        List<SavingThrow> savingThrows = new ArrayList<SavingThrow>();
        savingThrows = service.findByIdMonster(7);
        for (SavingThrow savingThrow : savingThrows) {
            System.out.println(savingThrow);
        }

        System.out.println("Teste concluído, checar mySQL");
    }
    
}
