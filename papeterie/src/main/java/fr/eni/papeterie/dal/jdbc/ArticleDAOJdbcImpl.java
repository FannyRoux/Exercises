/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.DALException;

/**
 * @author Fanny Roux
 * 
 */
public class ArticleDAOJdbcImpl {

	public ArticleDAOJdbcImpl() {
	}

	public Article selectById(Integer id) throws DALException {
		Article article = null;
		Connection connection = JdbcTools.getConnection();

		String selectById = "SELECT * FROM dbo.Articles WHERE idArticle= ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(selectById);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			rs.next();
			article = SQLMapperHelper.mapGetterArticle(rs);

			rs.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
		return article;
	}

	public List<Article> selectAll() throws DALException {

		List<Article> listeArticles = new ArrayList<>();
		Connection connection = JdbcTools.getConnection();

		String selectAll = "SELECT * FROM dbo.Articles";
		try {
			PreparedStatement stmt = connection.prepareStatement(selectAll);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listeArticles.add(SQLMapperHelper.mapGetterArticle(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			throw new DALException();
		}
		return listeArticles;
	}

	public void delete(Integer idArticle) throws DALException {
		Connection connection = JdbcTools.getConnection();

		String delete = "DELETE FROM dbo.Articles WHERE idArticle=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(delete);
		stmt.setInt(1, idArticle);

		stmt.executeUpdate();

		stmt.close();
		connection.close();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}

	public void update(Article article) throws DALException {

		Connection connection = JdbcTools.getConnection();

		String update = "UPDATE dbo.Articles set reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?, type=?  WHERE idArticle=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(update);
		SQLMapperHelper.mapSetterArticle(stmt, article);
		stmt.setInt(9, article.getIdArticle());

		stmt.executeUpdate();

		stmt.close();
		connection.close();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}

	}

	public void insert(Article article) throws DALException {
		Connection connection = JdbcTools.getConnection();

		String insert = "INSERT INTO dbo.Articles values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
		PreparedStatement stmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
		SQLMapperHelper.mapSetterArticle(stmt, article);

		int affectedRows = stmt.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("Creating article failed, no rows affected");
		}

		ResultSet rsGeneratedKey = stmt.getGeneratedKeys();
		ResultSetMetaData rsmd = rsGeneratedKey.getMetaData(); 
//		System.out.println(rsmd.getColumnLabel(1));
		if (rsGeneratedKey.next()) {
			article.setIdArticle(rsGeneratedKey.getInt("GENERATED_KEYS"));
		}
		stmt.close();
		connection.close();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}

	}

}