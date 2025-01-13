package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.factory.ConnectionFactory;
import br.monsterssheet.model.entity.SavingThrow;

public class SavingThrowDAO {
    /* CRUD */

    //CREATE
    public void save(SavingThrow savingThrow) {
        String insert = "INSERT INTO SavingThrows(idMonster, abilityScore) VALUES (?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Conecta com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            // Prepara a query
            pstm = conn.prepareStatement(insert);

            pstm.setInt(1,savingThrow.getIdMonster());
            pstm.setString(2, savingThrow.getAbilityScore());
            // Executa a query
            pstm.execute();

            System.out.println("SavingThrow salvo com sucesso");
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

    // READ
    public List<SavingThrow> findByIdMonster(int idMonster) {
        String select = "SELECT * FROM SavingThrows WHERE idMonster = ? ";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<SavingThrow> savingThrows = new ArrayList<SavingThrow>();

        try {
            // Conecta com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            // Prepara a query
            pstm = conn.prepareStatement(select);

            pstm.setInt(1, idMonster);
            // Executa a query
            rset = pstm.executeQuery();

            while (rset.next()) {
                // Cria e seta valores
                SavingThrow s = new SavingThrow();
                s.setAbilityScore(rset.getString("abilityScore"));
                // Adiciona a lista
                savingThrows.add(s);
            }

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
                if(rset!=null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return savingThrows;
    }

    // UPDATE
    public void update(SavingThrow savingThrow) {
        String update = "UPDATE SavingThrows SET abilityScore = ? WHERE idMonster = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Conecta com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            // Prepara a query
            pstm = conn.prepareStatement(update);

            pstm.setString(1, savingThrow.getAbilityScore());
            pstm.setInt(2,savingThrow.getIdMonster());
            // Executa a query
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

    // DELETE
    public void deleteByIdMonster(int idMonster) {
        String delete = "DELETE FROM SavingThrows WHERE idMonster = ? ";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Conecta com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            // Prepara a query
            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, idMonster);

            // Executa a query
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
