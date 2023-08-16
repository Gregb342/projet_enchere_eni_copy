package org.projetEncheres.HAG.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.projetEncheres.HAG.config.Settings;

public class ConnectionProvider {

	private static String url=Settings.getProperty("url");
	private static String login=Settings.getProperty("login");
	private static String password=Settings.getProperty("password");

	public static Connection getConnection() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cnx = DriverManager.getConnection(url, login, password);
			System.out.println("Connexion réussie.");
			return cnx;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
