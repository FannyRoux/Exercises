package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
	
	/**
	 * Obtention d'une connexion à la base de données
	 * 
	 * @return connexion
	 */
	public static Connection getConnection() {

		Connection cnx = null;
		try {
			String urlConnection = "jdbc:sqlserver://127.0.0.1;databasename=PAPETERIE_DB;trustServerCertificate=true";

			String user = "papeterie_java_user";
			String password = "P@peteri3P@$$!";

			cnx = DriverManager.getConnection(urlConnection, user, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return cnx;

	}


}
