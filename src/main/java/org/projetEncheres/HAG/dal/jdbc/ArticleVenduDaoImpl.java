package org.projetEncheres.HAG.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.projetEncheres.HAG.bo.ArticleVendu;
import org.projetEncheres.HAG.dal.ArticleVenduDao;

public class ArticleVenduDaoImpl implements ArticleVenduDao{
	
	private final static String SQL_INSERT_NOUVEL_ARTICLE =
			"INSERT INTO ARTICLES_VENDUS "
			+ "(nom_Article, description, date_Debut_Encheres, date_Fin_Encheres, "
			+ "prix_Initial, prix_Vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public ArticleVendu miseEnVente(ArticleVendu articleVendu) {
		//etape 1 : connexion au provider
		try(Connection connection = ConnectionProvider.getConnection()) {
	
			// etape 2 :
	PreparedStatement pStmt = connection.prepareStatement(SQL_INSERT_NOUVEL_ARTICLE);
	
			// etape 3 :
		pStmt.setString(1, articleVendu.getNomArticle());
	    pStmt.setString(2, articleVendu.getDescription());
	    pStmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
	    pStmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
	    pStmt.setInt(5, articleVendu.getMiseAPrix());
	    pStmt.setInt(6, articleVendu.getPrixVente());
	    pStmt.setInt(7, articleVendu.getnoUtilisateur());
	    pStmt.setInt(8, articleVendu.getnoCategorie());
	    
	    	//Etape 4 : 	
        int rowsAffected = pStmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Nouvel article enregistré !");
            return articleVendu;
        } else {
            System.out.println("Pas d'ajout de nouvel article");
            return null;
        }
	}
		catch (SQLException e) {
			e.printStackTrace();
		}

			return null;
	}

	@Override
	public ArticleVendu afficherArticle(int noArticle) {
		return null;
	}	
	
	//@Override
	//public ArticleVendu afficherArticle(int noArticle) {
	//	return null;
	//}
}