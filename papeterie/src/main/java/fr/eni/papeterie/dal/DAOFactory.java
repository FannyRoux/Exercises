package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

/**
 * @author Fanny Roux
 */
public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}

}
