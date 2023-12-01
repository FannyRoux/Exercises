package papeterie;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

public class TestArticleDAOJdbcImpl {

	@Test
	public void testSelectById() throws SQLException {
		ArticleDAOJdbcImpl articleDAOJdbcImpl = new ArticleDAOJdbcImpl();
		System.out.println(articleDAOJdbcImpl.selectById(1));
	}

	@Test
	public void testSelectAll() throws SQLException {
		String liste ="";
		ArticleDAOJdbcImpl articleDAOJdbcImpl = new ArticleDAOJdbcImpl();
		List<Article> articles = articleDAOJdbcImpl.selectAll();
		
		for(Article article : articles) {
			liste += String.format("%s%n",article);
		}
		System.out.println(liste);
		
	}
}
