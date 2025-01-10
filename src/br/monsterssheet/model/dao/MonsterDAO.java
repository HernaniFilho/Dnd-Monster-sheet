package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    //READ
    public Monster findByName(String name) {
        String select = "SELECT * FROM Monsters WHERE name LIKE ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Monster m = new Monster();
        //String rname = null;
        try {
            //Conecta no banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a string
            pstm = conn.prepareStatement(select);
            pstm.setString(1, name);

            rset = pstm.executeQuery();
            rset.next();
            
            m.setAlignment(rset.getString("alignment"));
            m.setArmorClass(rset.getInt("armorClass"));
            m.setChallenge(rset.getInt("challenge"));
            m.setCharisma(rset.getInt("charisma"));
            m.setConstitution(rset.getInt("constitution"));
            m.setDexterity(rset.getInt("dexterity"));
            m.setHitPoints(rset.getInt("hitPoints"));
            m.setId(rset.getInt("id"));
            m.setIntelligence(rset.getInt("intelligence"));
            m.setName(rset.getString("name"));
            m.setProficiencyBonus(rset.getInt("proficiencyBonus"));
            m.setSpeed(rset.getInt("speed"));
            m.setStrength(rset.getInt("strength"));
            m.setType(rset.getString("type"));
            m.setWisdom(rset.getInt("wisdom"));
            
            //rname = rset.getString("name");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nome não encontrado");
        } finally {
            //Fechar conexões
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn!=null) {
                    conn.close();
                }

                if(rset!=null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return m;

    }

    //READ
    public List<Monster> listAll() {
        String select = "select * FROM Monsters";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Monster> monsters = new ArrayList<Monster>();

        try {
            //Conecta no banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a string
            pstm = conn.prepareStatement(select);

            rset = pstm.executeQuery();

            while(rset.next()) {
                Monster m = new Monster();
                m.setAlignment(rset.getString("alignment"));
                m.setArmorClass(rset.getInt("armorClass"));
                m.setChallenge(rset.getInt("challenge"));
                m.setCharisma(rset.getInt("charisma"));
                m.setConstitution(rset.getInt("constitution"));
                m.setDexterity(rset.getInt("dexterity"));
                m.setHitPoints(rset.getInt("hitPoints"));
                m.setId(rset.getInt("id"));
                m.setIntelligence(rset.getInt("intelligence"));
                m.setName(rset.getString("name"));
                m.setProficiencyBonus(rset.getInt("proficiencyBonus"));
                m.setSpeed(rset.getInt("speed"));
                m.setStrength(rset.getInt("strength"));
                m.setType(rset.getString("type"));
                m.setWisdom(rset.getInt("wisdom"));

                monsters.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nenhum monstro encontrado");
        } finally {
            //Fechar as conexões
            try {
                if(pstm != null) {
                    pstm.close();
                }

                if(conn!=null) {
                    conn.close();
                }

                if(rset!=null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return monsters;
    }
}
