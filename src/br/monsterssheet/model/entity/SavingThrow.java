package br.monsterssheet.model.entity;

public class SavingThrow {
	private int id;
    private int idMonster;
    private String abilityScore;

    public int getIdMonster() {
        return idMonster;
    }
    public void setIdMonster(int idMonster) {
        this.idMonster = idMonster;
    }
    public String getAbilityScore() {
        return abilityScore;
    }
    public void setAbilityScore(String abilityScore) {
        this.abilityScore = abilityScore;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
        return "idMonster: "+idMonster+" abilityScore: "+abilityScore;
    }
}
