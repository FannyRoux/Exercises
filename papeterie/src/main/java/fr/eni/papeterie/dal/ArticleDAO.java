package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

/**
 * @author Fanny Roux
 */
public interface ArticleDAO extends DAO<Article> {

	public List<Article> selectBy(Condition condition, String valeur) throws DALException;

	enum Condition {
		SELECT_BY_MARQUE, SELECT_BY_MOT_CLE
	}
}