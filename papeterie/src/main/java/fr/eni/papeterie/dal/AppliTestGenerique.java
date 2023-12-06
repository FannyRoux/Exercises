package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO.Condition;

public class AppliTestGenerique {

	public static void main(String[] args) {

		//Déclaration et instanciation de la DAO
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();

		//Instanciation du jeu d'essai 
		Article a1 = new Stylo( "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");
		Article a2 = new Ramette(  "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		Article a3 = new Stylo( "Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune");


		System.out.println("Ajout des articles... ");
		try {
			articleDAO.create(a1);
			System.out.println("Article ajouté  : " + a1.toString() );
			articleDAO.create(a2);
			System.out.println("Article ajouté  : " + a2.toString() );
			articleDAO.create(a3);
			System.out.println("Article ajouté  : " + a3.toString() );


			//Sélection de l'article par id
			Article a = articleDAO.read(a2.getIdArticle());
			System.out.println("Sélection de l'article par id  : " + a.toString() );

			//Sélection de tous les articles
			List<Article> articles = articleDAO.selectAll();
			System.out.println("Sélection de tous les articles  : " + articles.toString() );

			//Modification d'un article
			System.out.println("Modification d'un article  : " );
			System.out.println("Article avant modification : "  + a1.toString());
			((Stylo) a1).setCouleur("noir");
			((Stylo) a1).setDesignation("Bic bille noir");
			((Stylo) a1).setReference("BBNoir");
			articleDAO.update(a1);
			System.out.println("Article aprés modification  : " + a1.toString() );
			
			
			//Suppression d'un article
			System.out.println("Suppression de l'article  : " + a1.toString());
			articleDAO.delete(a1.getIdArticle());
			articles = articleDAO.selectAll();
			System.out.println("Liste des articles après suppression : "  );
			StringBuffer sb = new StringBuffer();
			for(Article art: articles){
				if(art instanceof Stylo){
					sb.append("Stylo   [id=");
				}else{
					sb.append("Ramette [id=");
				}
				sb.append(art.getIdArticle());
				sb.append(", ref=");
				sb.append(art.getReference()).append("]\n");
			}
			System.out.println(sb.toString());
			System.out.println("---------------------------------------------------------------");

			// Recherche d'un articles par marque
			System.out.println("\nRecherche d'articles  par la marque Clairef");
			articles = articleDAO.selectBy(Condition.SELECT_BY_MARQUE,"Clairef");
			System.out.println(articles);
			
			// Recherche d'articles par mot clef
			System.out.println("\nRecherche d'articles  par le mot clef Plume");
			articles = articleDAO.selectBy(Condition.SELECT_BY_MOT_CLE,"Plume");
			System.out.println(articles);
			System.out.println("---------------------------------------------------------------");

			
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}
