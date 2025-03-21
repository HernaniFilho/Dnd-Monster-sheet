CREATE DATABASE monstersheet;

CREATE TABLE Monsters (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE,
    type VARCHAR(20) NOT NULL,
    alignment VARCHAR(20),
    armorClass INTEGER,
    hitPoints INTEGER NOT NULL,
    speed INTEGER,
    challenge VARCHAR(10) NOT NULL,
    strength INTEGER NOT NULL,
    dexterity INTEGER NOT NULL,
    constitution INTEGER NOT NULL,
    intelligence INTEGER NOT NULL,
    wisdom INTEGER NOT NULL,
    charisma INTEGER NOT NULL,
    proficiencyBonus INTEGER NOT NULL
);

CREATE TABLE SavingThrows (
    id INTEGER NOT NULL AUTO_INCREMENT,
    idMonster INTEGER NOT NULL,
    abilityScore VARCHAR(20) NOT NULL,
    PRIMARY KEY (id, idMonster),
    FOREIGN KEY (idMonster) REFERENCES Monsters(id)
);

CREATE TABLE Languages (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idMonster INTEGER,
    name VARCHAR(30) NOT NULL,
    FOREIGN KEY (idMonster) REFERENCES Monsters(id)
);

CREATE TABLE Actions (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idMonster INTEGER NOT NULL,
    name VARCHAR(30) NOT NULL UNIQUE,
    description VARCHAR(200) NOT NULL,
    type VARCHAR(20) NOT NULL,
    actionRange REAL NOT NULL,
    isLegendary BOOLEAN NOT NULL,
    FOREIGN KEY (idMonster) REFERENCES Monsters(id)
);
