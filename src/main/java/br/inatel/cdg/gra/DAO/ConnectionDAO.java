package br.inatel.cdg.gra.DAO;

import java.sql.*;

public abstract class ConnectionDAO{

    // Essa parte é sempre eigual
    Connection con; //conexão
    PreparedStatement pst; // declaração(query) preparada código em sql
    Statement st; //declaração(query) - código em sql
    ResultSet rs; //resposta do banco

    String database = "gra"; // Banco de dados que eu quero usar
    String url = "jdbc:mysql://127.0.0.1:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    String user = "root";
    String password = "root";

    public void connectToDB()
    {
        try
        {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao deu certo!");
        }
        catch(SQLException exc)
        {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}