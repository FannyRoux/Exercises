package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

/**
 * @author Fanny Roux
 */

public class CatalogueManager {
	private ArticleDAO daoArticle = DAOFactory.getArticleDAO();
	private static CatalogueManager instance = null;
	enum Condition {
		SELECT_BY_MARQUE(ArticleDAO.Condition.SELECT_BY_MARQUE)
		, SELECT_BY_MOT_CLE(ArticleDAO.Condition.SELECT_BY_MOT_CLE);

		
		private ArticleDAO.Condition value;

		Condition(ArticleDAO.Condition ordinal) {
			this.value = ordinal;
		}
		ArticleDAO.Condition getValue(){
			return value;
		}
	}

	private CatalogueManager() {
	}

	public static CatalogueManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}

	public void addArticle(Article a) throws BLLException {
		try {
			validerArticle(a);
			daoArticle.create(a);
		} catch (DALException e) {
			throw new BLLException();
		}
	}

	public List<Article> getCatalogue() throws BLLException {
		try {
			return daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException();
		}
	}

	public void updateArticle(Article a) throws BLLException {
		try {
			validerArticle(a);
			daoArticle.update(a);
		} catch (DALException e) {
			throw new BLLException();
		}
	}

	public void removeArticle(int index) throws BLLException {
		try {
			daoArticle.delete(index);
		} catch (DALException e) {
			throw new BLLException();
		}

	}

	public Article getArticle(int index) throws BLLException {
		try {
			return daoArticle.read(index);
		} catch (DALException e) {
			throw new BLLException();
		}
	}
	
	public List<Article> getArticleSelection(Condition condition, String valeur) throws BLLException {
		try {
			
			return daoArticle.selectBy(condition.getValue(), valeur);
		} catch (DALException e) {
			throw new BLLException();
		}
	}

	public void validerArticle(Article a) throws BLLException {
		boolean articleValide = true;
		String messageErreur = null;

		if (dataNotDefined(a.getReference())) {
			articleValide = false;
			messageErreur = String.format("%s%n", "La référence de l'article est obligatoire");

		}

		if (dataNotDefined(a.getMarque())) {
			articleValide = false;
			messageErreur = String.format("%s%n", "La marque de l'article est obligatoire");

		}

		if (dataNotDefined(a.getDesignation())) {
			articleValide = false;
			messageErreur = String.format("%s%n", "La désignation de l'article est obligatoire");
		}

		if (a.getPrixUnitaire() <= 0) {
			articleValide = false;
			messageErreur = String.format("%s%n", "Le prix de l'article doit être supérieur à 0€ ");
		}

		if (a.getQteStock() <= 0) {
			articleValide = false;
			messageErreur = String.format("%s%n", "Il doit y avoir au moins 1 article en stock ");
		}

		if (a instanceof Ramette && ((Ramette) a).getGrammage() <= 0) {
			articleValide = false;
			messageErreur = String.format("%s%n", "Le grammage de la ramette doit être supérieur à 0");
		}

		if (a instanceof Stylo && dataNotDefined(((Stylo) a).getCouleur())) {
			articleValide = false;
			messageErreur = String.format("%s%n", "La couleur de la ramette est obligatoire");
		}

		if (!articleValide) {
			throw new BLLException(String.format("%s%n", messageErreur));
		}
	}

	private boolean dataNotDefined(String s) {
		return s == null || s.trim().length() == 0;
	}

}
