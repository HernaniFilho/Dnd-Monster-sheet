CREATE DATABASE monstersheet;

CREATE TABLE Monsters (
    id int NOT NULL AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE,
    type VARCHAR(20) NOT NULL,
    alignment VARCHAR(10),
    armorClass INTEGER,
    hitPoints INTEGER NOT NULL,
    speed INTEGER,
    challenge INTEGER NOT NULL,
    strength INTEGER NOT NULL,
    dexterity INTEGER NOT NULL,
    constitution INTEGER NOT NULL,
    intelligence INTEGER NOT NULL,
    wisdom INTEGER NOT NULL,
    charisma INTEGER NOT NULL,
    proficiencyBonus INTEGER NOT NULL
)
