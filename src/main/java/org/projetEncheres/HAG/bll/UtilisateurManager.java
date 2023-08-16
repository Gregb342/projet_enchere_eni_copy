package org.projetEncheres.HAG.bll;

import org.projetEncheres.HAG.bo.Utilisateur;

public interface UtilisateurManager {
	
	    Utilisateur connexionUtilisateur(String pseudo, String motDePasse) throws Exception;
	    Utilisateur afficherProfil(int noUtilisateur) throws Exception;
	    Utilisateur inscriptionUtilisateur(Utilisateur utilisateur) throws Exception;
		Utilisateur modifierProfilUtilisateur(Utilisateur modifUtilisateur) throws Exception;
		Utilisateur supprimerProfilUtilisateur(int noUtilisateur) throws Exception;
	    
}
