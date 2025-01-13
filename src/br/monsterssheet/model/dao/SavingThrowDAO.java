package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.factory.ConnectionFactory;
import br.monsterssheet.model.entity.SavingThrow;

public class SavingThrowDAO {
    /* CRD */

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
                s.setIdMonster(rset.getInt("idMonster"));
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
            System.out.println("SavingThrow deletado com sucesso");
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
    public void deleteOneByIdMonster(SavingThrow savingThrow) {
        String delete = "DELETE FROM SavingThrows WHERE idMonster = ? AND abilityScore = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, savingThrow.getIdMonster());
            pstm.setString(2, savingThrow.getAbilityScore());

            pstm.execute();

            System.out.println("Uma abilityScore de um Monster deletado com sucesso");
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
