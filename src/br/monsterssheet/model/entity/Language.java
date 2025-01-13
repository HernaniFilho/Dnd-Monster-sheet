package br.monsterssheet.model.entity;

public class Language {
    private int id;
    private int idMonster;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdMonster() {
        return idMonster;
    }
    public void setIdMonster(int idMonster) {
        this.idMonster = idMonster;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "idMonster: "+idMonster+" language name: "+name;
    }
    
}
