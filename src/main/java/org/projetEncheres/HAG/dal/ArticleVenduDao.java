package org.projetEncheres.HAG.dal;

import java.time.LocalDateTime;

import org.projetEncheres.HAG.bo.ArticleVendu;

public interface ArticleVenduDao {
	ArticleVendu miseEnVente(ArticleVendu articleVendu);
	ArticleVendu afficherArticle(int noArticle);
}
