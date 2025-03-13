package br.monsterssheet.controller;

import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.model.entity.Language;
import br.monsterssheet.model.service.LanguageService;

public class LanguageController implements IController {

    @Override
    public boolean execute(Object view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
    public boolean save(int idMonster, List<String> languages) {
    	LanguageService service = new LanguageService();
		Language language = new Language();
		language.setIdMonster(idMonster);
		for (String name : languages) {
			language.setName(name);
			service.save(language);
		}
		return true;
    }
    
    public boolean remove(int idMonster) {
		LanguageService service = new LanguageService();
		service.deleteByIdMonster(idMonster);
		return true;
	}
    
    // Apenas para testes
    public static void main(String[] args) {
        Language language = new Language();
        //Seta valores
        language.setIdMonster(7);
        //language.setName("Common");

        // Salva
        LanguageService service = new LanguageService();
        String names = service.languageValues().get(0);
        language.setName(names);
        service.save(language);

        names = service.languageValues().get(1);
        language.setName(names);
        service.save(language);

        // Atualiza
        // não possui

        // Deletar por idMonster
        /* service.deleteByIdMonster(7); */

        // Deletar por idMonster e name
        /* service.deleteOneByIdMonster(language); */

        // Deletar por name
        /* service.deleteByName(language.getName()); */

        // Listar por idMonster
        List<Language> languages = new ArrayList<Language>();
        languages = service.findByIdMonster(7);
        for (Language lang : languages) {
            System.out.println(lang);
        }
        // Listar por name
        /* languages = service.findByName(language); */

        // Listar todos
        languages = service.listAll();
        for (Language lang : languages) {
            System.out.println(lang);
        }


        System.out.println("Teste concluído, checar mySQL");
    }
}
