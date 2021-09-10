package br.com.alura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {

		System.out.println("Conectando...");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			

		} catch (ClassNotFoundException e) {
			
			System.out.println("Error de Conexão!!");
			
			e.printStackTrace();

			throw new SQLException(e);

		}
		
		System.out.println("Conectado com sucesso.");

		return DriverManager.getConnection("jdbc:mysql://localhost/livraria?useTimezone=true&serverTimezone=UTC", "root", "toor");

	}

}
