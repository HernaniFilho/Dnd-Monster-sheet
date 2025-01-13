package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.factory.ConnectionFactory;
import br.monsterssheet.model.entity.Monster;

public class MonsterDAO {
    /* CRUD */

    //CREATE
    public int save(Monster monster) {
        String insert = "INSERT INTO Monsters(name, type, alignment, armorClass, hitPoints, speed, challenge, strength, dexterity, constitution, intelligence, wisdom, charisma, proficiencyBonus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        int idMonster = -1;
        try {
            //Conecta no banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a string
            pstm = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            //Adiciona valores a string
            pstm.setString(1, monster.getName());
            pstm.setString(2, monster.getType());
            pstm.setString(3, monster.getAlignment());
            pstm.setInt(4, monster.getArmorClass());
            pstm.setInt(5, monster.getHitPoints());
            pstm.setInt(6, monster.getSpeed());
            pstm.setString(7, monster.getChallenge());
            pstm.setInt(8, monster.getStrength());
            pstm.setInt(9, monster.getDexterity());
            pstm.setInt(10, monster.getConstitution());
            pstm.setInt(11, monster.getIntelligence());
            pstm.setInt(12, monster.getWisdom());
            pstm.setInt(13, monster.getCharisma());
            pstm.setInt(14, monster.getProficiencyBonus());
            //Executa a query
            pstm.execute();
            // Pega o que foi criado
            rset = pstm.getGeneratedKeys();
            // Pega somente a coluna do id
            if (rset.next()) {
                idMonster = rset.getInt(1);
            }
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

                if(rset!=null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return idMonster;
    }

    //READ
    public List<Monster> findByName(String name) {
        String select = "SELECT * FROM Monsters WHERE name LIKE ? ORDER BY name ASC";

        name = name + "%";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Monster> monsters = new ArrayList<Monster>();

        try {
            //Conecta no banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a string
            pstm = conn.prepareStatement(select);
            pstm.setString(1, name);

            rset = pstm.executeQuery();
            while (rset.next()) {
                //Cria e seta valores para uma entrada da tabela
                Monster m = new Monster();
                m.setAlignment(rset.getString("alignment"));
                m.setArmorClass(rset.getInt("armorClass"));
                m.setChallenge(rset.getString("challenge"));
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
                //adiciona a lista
                monsters.add(m);
            }
            
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
        return monsters;

    }

    //READ
    public List<Monster> listAll() {
        String select = "select * FROM Monsters ORDER BY name ASC";

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
                //Cria e seta
                Monster m = new Monster();
                m.setAlignment(rset.getString("alignment"));
                m.setArmorClass(rset.getInt("armorClass"));
                m.setChallenge(rset.getString("challenge"));
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
                //Adiciona a lista
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

    //UPDATE
    public void update(Monster monster) {
        String update = "UPDATE Monsters SET name = ?, type = ?, alignment = ?, armorClass = ?, hitPoints = ?, speed = ?, challenge = ?, strength = ?, dexterity = ?, constitution = ?, intelligence = ?, wisdom = ?, charisma = ?, proficiencyBonus = ? WHERE id = ? ";
        
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Conceta ao servidor
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a query
            pstm = conn.prepareStatement(update);

            //Adiciona valores a string
            pstm.setString(1, monster.getName());
            pstm.setString(2, monster.getType());
            pstm.setString(3, monster.getAlignment());
            pstm.setInt(4, monster.getArmorClass());
            pstm.setInt(5, monster.getHitPoints());
            pstm.setInt(6, monster.getSpeed());
            pstm.setString(7, monster.getChallenge());
            pstm.setInt(8, monster.getStrength());
            pstm.setInt(9, monster.getDexterity());
            pstm.setInt(10, monster.getConstitution());
            pstm.setInt(11, monster.getIntelligence());
            pstm.setInt(12, monster.getWisdom());
            pstm.setInt(13, monster.getCharisma());
            pstm.setInt(14, monster.getProficiencyBonus());
            //Id do Monstro
            pstm.setInt(15, monster.getId());

            //Executa a query
            pstm.execute();
            System.out.println("Monstro atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null) {
                    conn.close();
                }
                
                if (pstm!=null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //DELETE
    public void deleteById(int id) {
        String delete = "DELETE FROM Monsters WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Concecta com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Prepara a query
            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, id);

            //Executa a query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null) {
                    conn.close();
                }

                if(pstm!=null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
