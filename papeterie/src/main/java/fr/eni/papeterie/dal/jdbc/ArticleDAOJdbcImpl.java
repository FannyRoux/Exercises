/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

/**
 * @author Fanny Roux
 * 
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {

	public ArticleDAOJdbcImpl() {
	}

	public Article read(Integer idArticle) throws DALException {
		Article article = null;
		Connection connection = JdbcTools.getConnection();

		String selectById = "SELECT * FROM dbo.Articles WHERE idArticle= ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(selectById);

			stmt.setInt(1, idArticle);

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

	public List<Article> selectBy(Condition condition, String valeur) throws DALException {

		List<Article> listeArticles = new ArrayList<>();
		Connection connection = JdbcTools.getConnection();

		String selectByMarque = "SELECT * FROM dbo.Articles WHERE upper(marque) like upper(?)";
		String selectByMotCle = "SELECT * FROM dbo.Articles WHERE upper(marque) like upper(?) OR upper(designation) like upper(?)";
		String select = null;

		if (condition == Condition.SELECT_BY_MARQUE) {
			select = selectByMarque;
		} else {
			select = selectByMotCle;
		}
		try {
			PreparedStatement stmt = connection.prepareStatement(select);
			stmt.setString(1, "%"+valeur+"%");
			if (condition == Condition.SELECT_BY_MOT_CLE) {
				stmt.setString(2, "%"+valeur+"%");
			}
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

	public void create(Article article) throws DALException {
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