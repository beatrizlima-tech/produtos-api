package br.com.cotiinformatica.produtos_api.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    // Método para retornar uma conexão com o banco de dados do PostgreSQL

    public Connection getConnection() throws Exception{

        var host = "jdbc:postgresql://localhost:5434/bd_apiprodutos";
        var user = "coti";
        var pass = "Coti2026";

        return DriverManager.getConnection(host, user, pass);
    }

}
