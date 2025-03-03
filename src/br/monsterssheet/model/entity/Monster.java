package br.monsterssheet.model.entity;

import java.util.List;

public class Monster {
	private int id;
    private String name;
    private String type;
    private String alignment;
    private int armorClass;
    private int hitPoints;
    private int speed;
    private String challenge;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int proficiencyBonus;

    private List<Language> languages;
    private List<SavingThrow> savingThrows;
    private List<Action> actions;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public void addLanguage(Language l) {
    	languages.add(l);
    }
    
    public void setLanguage(List<Language> l) {
    	languages = l;
    }
    
    public void removeLanguage(Language l) {
    	languages.remove(l);
    }
    
    public List<Language> getLanguages() {
    	return languages;
    }
    
    public void addSavingThrow(SavingThrow s) {
    	savingThrows.add(s);
    }
    
    public void setSavingThrow(List<SavingThrow> s) {
    	savingThrows = s;
    }
    
    public void removeSavingThrow(SavingThrow s) {
    	savingThrows.remove(s);
    }
    
    public List<SavingThrow> getSavingThrow() {
    	return savingThrows;
    }

    public void addAction(Action a) {
    	actions.add(a);
    }
    
    public void setAction(List<Action> a) {
    	actions = a;
    }
    
    public void removeAction(Action a) {
    	actions.remove(a);
    }
    
    public List<Action> getActions() {
    	return actions;
    }
    
    public String toString() {
        return "Id: "+getId()+" Name: "+getName()+" Type: "+getType()+" Alignment: "+getAlignment()+
        " ArmorClass: "+getArmorClass()+" HitPoints: "+getHitPoints()+" Speed: "+getSpeed()+
        " Challenge: "+getChallenge()+" Strength: "+getStrength()+" Dexterity: "+getDexterity()+
        " Constitution: "+getConstitution()+" Intelligence: "+getIntelligence()+" Wisdom: "+getWisdom()+
        " Charisma: "+getCharisma()+" ProficiencyBonus: "+getProficiencyBonus();
    }

    
}
