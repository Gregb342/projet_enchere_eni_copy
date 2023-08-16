package org.projetEncheres.HAG.dal;

import org.projetEncheres.HAG.bo.Utilisateur;

public interface UtilisateurDao {

	Utilisateur connexionUtilisateur(String pseudo, String motDePasse);
	Utilisateur afficherProfil(int noUtilisateur);
	Utilisateur inscriptionUtilisateur(Utilisateur utilisateur);
	Utilisateur modifierProfilUtilisateur(Utilisateur utilisateur);
	Utilisateur supprimerProfilUtilisateur(int noUtilisateur);
}
