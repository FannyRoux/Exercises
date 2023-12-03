package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

/**
 * @author Fanny Roux
 */
public interface ArticleDAO {
	   //commentaire test push !
	public Article selectById(Integer idArticle) throws DALException;
	public List<Article> selectAll()throws DALException;
	public void update(Article data) throws DALException;
	public void insert(Article data) throws DALException;
	public void delete (Integer idArticle) throws DALException;
	
	}