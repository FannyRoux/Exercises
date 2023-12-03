package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.papeterie.dal.Settings;

public class JdbcTools {

	private static Connection cnx = null;

	/**
	 * Obtention d'une connexion à la base de données
	 * 
	 * @return connexion
	 */
	public static Connection getConnection() {
	

			try {
				String urlConnection = Settings.getProperty("urlDB");
				String user = Settings.getProperty("userDB");
				String password = Settings.getProperty("passwordDB");

				cnx = DriverManager.getConnection(urlConnection, user, password);
				
			} catch (SQLException e) {
				e.printStackTrace();

			}
		return cnx;

	}


	}

