package fr.eni.papeterie.dal.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class SQLMapperHelper {

	public static Article mapGetterArticle(ResultSet rs) throws SQLException {
		Article article = null;

		int idArticle = rs.getInt(1);
		String reference = rs.getString(2);
		String marque = rs.getString(3);
		String designation = rs.getString(4);
		float prixUnitaire = rs.getFloat(5);
		int qteStock = rs.getInt(6);
		int grammage = rs.getInt(7);
		String couleur = rs.getString(8);
		String type = rs.getString(9);

		if (rs.getString(9).trim().equalsIgnoreCase("stylo")) {
			article = new Stylo(idArticle, reference, marque, designation, prixUnitaire, qteStock, couleur);
			
		}

		else if (rs.getString(9).trim().equalsIgnoreCase("ramette")) {
			article = new Ramette(idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage);
		}
		return article;
	}

	@SuppressWarnings("null")
	public static void mapSetterArticle(PreparedStatement stmt, Article article) throws SQLException {
		stmt.setString(1, article.getReference());
		stmt.setString(2, article.getMarque());
		stmt.setString(3, article.getDesignation());
		stmt.setFloat(4, article.getPrixUnitaire());
		stmt.setInt(5, article.getQteStock());
		
		if(article instanceof Ramette) {
			stmt.setInt(6, ((Ramette)article).getGrammage());
			stmt.setString(8, "Ramette");
		} else {
			stmt.setInt(6, (Integer) 0);
		}
		
		if(article instanceof Stylo) {
			stmt.setString(7, ((Stylo)article).getCouleur());
			stmt.setString(8, "Stylo");
		} else {
			stmt.setString(7, "");
		}
	}

}
