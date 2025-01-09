package br.monsterssheet.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //Username
    private static final String USERNAME = "root";

    //Password
    private static final String PASSWORD = "";

    //Database URL, Port, Database name
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/monsterssheet";

    //Connection with Database
    public static Connection createConnectionToMySQL() throws Exception{
        //Faz a classe ser carregada pela JVM
        Class.forName("com.mysql.jdbc.Driver");

        //Conecction with Database
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception{
        //Get connection
        Connection con = createConnectionToMySQL();

        //Test conncetion
        if(con!=null) {
            System.out.println("Conexão feita com sucesso!");
            con.close();
        }
    }

}
