package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.monsterssheet.factory.ConnectionFactory;
import br.monsterssheet.model.entity.Monster;

public class MonsterDAO {
    /* CRUD */

    //CREATE
    public void save(Monster monster) {
        String insert = "INSERT INTO Monsters(name, type, alignment, armorClass, hitPoints, speed, challenge, strength, dexterity, constitution, intelligence, wisdom, charisma, proficiencyBonus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Conecta no banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a string
            pstm = conn.prepareStatement(insert);
            //Adiciona valores a string
            pstm.setString(1, monster.getName());
            pstm.setString(2, monster.getType());
            pstm.setString(3, monster.getAlignment());
            pstm.setInt(4, monster.getArmorClass());
            pstm.setInt(5, monster.getHitPoints());
            pstm.setInt(6, monster.getSpeed());
            pstm.setInt(7, monster.getChallenge());
            pstm.setInt(8, monster.getStrength());
            pstm.setInt(9, monster.getDexterity());
            pstm.setInt(10, monster.getConstitution());
            pstm.setInt(11, monster.getIntelligence());
            pstm.setInt(12, monster.getWisdom());
            pstm.setInt(13, monster.getCharisma());
            pstm.setInt(14, monster.getProficiencyBonus());
            //Executa a query
            pstm.execute();
            System.out.println("Monstro salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Fechar conexões
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
