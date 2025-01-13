package br.monsterssheet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.monsterssheet.factory.ConnectionFactory;
import br.monsterssheet.model.entity.Language;

public class LanguageDAO {
    /* CRD */

    // CREATE
    public void save(Language language) {
        String insert = "INSERT INTO Languages(idMonster, name) VALUES (?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(insert);

            pstm.setInt(1, language.getIdMonster());
            pstm.setString(2, language.getName());

            pstm.execute();

            System.out.println("Language salva com sucesso");
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
    public List<Language> findByIdMonster(int idMonster) {
        String select = "SELECT * FROM Languages WHERE idMonster = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Language> languages = new ArrayList<Language>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(select);

            pstm.setInt(1, idMonster);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Language l = new Language();
                l.setId(rset.getInt("id"));
                l.setIdMonster(rset.getInt("idMonster"));
                l.setName(rset.getString("name"));

                languages.add(l);
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
        return languages;
    }

    // READ
    public List<Language> findByName(Language language) {
        String select = "SELECT * FROM Languages WHERE name = ? ";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Language> languages = new ArrayList<Language>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(select);

            pstm.setString(1, language.getName());

            rset = pstm.executeQuery();

            while (rset.next()) {
                Language l = new Language();
                l.setId(rset.getInt("id"));
                l.setIdMonster(rset.getInt("idMonster"));
                l.setName(rset.getString("name"));
                languages.add(l);
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
        return languages;
    }

    // READ
    public List<Language> listAll() {
        String select = "SELECT * FROM Languages ORDER BY name ASC";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Language> languages = new ArrayList<Language>();
        
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(select);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Language l = new Language();
                l.setId(rset.getInt("id"));
                l.setIdMonster(rset.getInt("idMonster"));
                l.setName(rset.getString("name"));

                languages.add(l);
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
        return languages;
    }

    // DELETE
    public void deleteByIdMonster(int idMonster) {
        String delete = "DELETE FROM Languages WHERE idMonster = ? ";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, idMonster);

            pstm.execute();

            System.out.println("Languages de um Monster deletado com sucesso");
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
    public void deleteOneByIdMonster(Language language) {
        String delete = "DELETE FROM Languages WHERE idMonster = ? AND name = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(delete);

            pstm.setInt(1, language.getIdMonster());
            pstm.setString(2, language.getName());

            pstm.execute();

            System.out.println("Uma Language de um Monster deletado com sucesso");
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
    public void deleteByName(String name) {
        String delete = "DELETE FROM Language WHERE name = ? ";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(delete);

            pstm.setString(1, name);

            pstm.execute();

            System.out.println("Language deletada com sucesso");
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
