package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.factory.ConnectionFactory;
import br.monsterssheet.model.entity.Action;

public class ActionDAO {
    /* CRUD */

    // CREATE
    public void save(Action action) {
        String insert = "INSERT INTO Actions(idMonster, name, description, type, actionRange, isLegendary) VALUES (?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(insert);

            pstm.setInt(1, action.getIdMonster());
            pstm.setString(2, action.getName());
            pstm.setString(3, action.getDescription());
            pstm.setString(4, action.getType());
            pstm.setFloat(5, action.getActionRange());
            pstm.setBoolean(6, action.isLegendary());

            pstm.execute();

            System.out.println("Action salva com sucesso");
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
    public List<Action> findByIdMonster(int idMonster) {
        String select = "SELECT * FROM Actions WHERE idMonster = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Action> actions = new ArrayList<Action>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(select);

            pstm.setInt(1, idMonster);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Action action = new Action();
                action.setId(rset.getInt("id"));
                action.setIdMonster(rset.getInt("idMonster"));
                action.setName(rset.getString("name"));
                action.setDescription(rset.getString("description"));
                action.setType(rset.getString("type"));
                action.setActionRange(rset.getFloat("actionRange"));
                action.setLegendary(rset.getBoolean("isLegendary"));

                actions.add(action);
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
                if (rset!=null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return actions;
    }

    // Outros READ poderiam ser implementados aqui

    // READ
    public List<Action> listAll() {
        String select = "SELECT * FROM Actions ORDER BY name ASC";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Action> actions = new ArrayList<Action>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(select);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Action action = new Action();
                action.setId(rset.getInt("id"));
                action.setIdMonster(rset.getInt("idMonster"));
                action.setName(rset.getString("name"));
                action.setDescription(rset.getString("description"));
                action.setType(rset.getString("type"));
                action.setActionRange(rset.getFloat("actionRange"));
                action.setLegendary(rset.getBoolean("isLegendary"));

                actions.add(action);
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
                if (rset!=null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return actions;
    }

    // UPDATE
    public void update(Action action) {
        String update = "UPDATE Actions SET name = ?, description = ?, type = ?, actionRange = ?, isLegendary = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(update);

            pstm.setString(1, action.getName());
            pstm.setString(2, action.getDescription());
            pstm.setString(3, action.getType());
            pstm.setFloat(4, action.getActionRange());
            pstm.setBoolean(5, action.isLegendary());
            pstm.setInt(6, action.getId());

            pstm.execute();

            System.out.println("Action atualizada com sucesso");
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
        String delete = "DELETE FROM Actions WHERE idMonster = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, idMonster);

            pstm.execute();

            System.out.println("Actions de um Monster deletado com sucesso");
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
    public void deleteOneByIdMonster(Action action) {
        String delete = "DELETE FROM Actions WHERE idMonster = ? AND name = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, action.getIdMonster());
            pstm.setString(2, action.getName());

            pstm.execute();

            System.out.println("Uma Action de um Monster deletado com sucesso");
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
