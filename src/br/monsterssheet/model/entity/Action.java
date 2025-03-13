package br.monsterssheet.model.entity;

public class Action {
    private int id;
    private int idMonster;
    private String name;
    private String description;
    private String type;
    private float actionRange;
    private Boolean isLegendary;

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public float getActionRange() {
        return actionRange;
    }
    public void setActionRange(float range) {
        this.actionRange = range;
    }
    public Boolean isLegendary() {
        return isLegendary;
    }
    public void setLegendary(Boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public String toString() {
        return name+" ("+type+")("+actionRange+")";
    }    
}
