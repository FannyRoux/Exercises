/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

/**
 * @author Fanny Roux
 * 
 */
public class ArticleDAOJdbcImpl {

	Article article;
	Connection connection = null;

	public ArticleDAOJdbcImpl() {
		connection = getConnexion();
	}

	/**
	 * Obtention d'une connexion à la base de données
	 * 
	 * @return connexion
	 */
	public static Connection getConnexion() {

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

	/**
	 * Création d'une requête SQL permettant de sélectionner un article par son
	 * identifiant
	 * 
	 * @param integer
	 * @throws SQLException
	 */
	public Article selectById(Integer id) throws SQLException {

		String selectById = "SELECT * FROM dbo.Articles WHERE idArticle= ?";
		PreparedStatement stmt = connection.prepareStatement(selectById);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Stylo stylo = new Stylo();
			Ramette ramette = new Ramette();

			if (rs.getString(9).trim().equalsIgnoreCase("stylo")) {
				stylo.setIdArticle(rs.getInt(1));
				stylo.setReference(rs.getString(2));
				stylo.setMarque(rs.getString(3));
				stylo.setDesignation(rs.getString(4));
				stylo.setPrixUnitaire(rs.getFloat(5));
				stylo.setQteStock(rs.getInt(6));
				stylo.setCouleur(rs.getString(8));

				article = stylo;
			}

			if (rs.getString(9).trim().equalsIgnoreCase("ramette")) {
				ramette.setIdArticle(rs.getInt(1));
				ramette.setReference(rs.getString(2));
				ramette.setMarque(rs.getString(3));
				ramette.setDesignation(rs.getString(4));
				ramette.setPrixUnitaire(rs.getFloat(5));
				ramette.setQteStock(rs.getInt(6));
				ramette.setGrammage(rs.getInt(7));

				article = ramette;
			}
		}

		connection.close();
		return article;
	}

	public List<Article> selectAll() throws SQLException {
		List<Article> listeArticles = new ArrayList<Article>();

		String selectAll = "SELECT * FROM dbo.Articles";
		PreparedStatement stmt = connection.prepareStatement(selectAll);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			article.setIdArticle(rs.getInt(1));
			article.setReference(rs.getString(2));
			article.setMarque(rs.getString(3));
			article.setDesignation(rs.getString(4));
			article.setPrixUnitaire(rs.getFloat(5));
			article.setQteStock(rs.getInt(6));

			if (rs.getString(9).trim().equalsIgnoreCase("ramette")) {
				((Ramette) article).setGrammage(rs.getInt(7));
			} 
			
			if (rs.getString(9).trim().equalsIgnoreCase("stylo")) {
				((Stylo) article).setCouleur(rs.getString(8));
			}

			listeArticles.add(article);

		}
		return listeArticles;
	}

}