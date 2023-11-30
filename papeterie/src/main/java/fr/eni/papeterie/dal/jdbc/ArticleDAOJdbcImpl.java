/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.papeterie.bo.Article;

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
    public Article selectById(Integer integer) throws SQLException {
        Statement statement = null;
        statement = connection.createStatement();
        String selectById = "select reference, marque, designation, prixUnitaire, qteStock from dbo.Articles where idArticle=integer";
        ResultSet rs = statement.executeQuery(selectById);
        return null;
    }
}