package org.projetEncheres.HAG.bll;

import org.projetEncheres.HAG.bo.Utilisateur;
import org.projetEncheres.HAG.dal.UtilisateurDao;
import org.projetEncheres.HAG.dal.jdbc.UtilisateurDaoImpl;

public class UtilisateurManagerImpl implements UtilisateurManager {
    private UtilisateurDao utilisateurDao; 

    public UtilisateurManagerImpl() {
        this.utilisateurDao = new UtilisateurDaoImpl(); // Initialiser le DAO dans le constructeur.
    }

    @Override
    public Utilisateur connexionUtilisateur(String pseudo, String motDePasse) throws Exception {
        // ajouter ici toute la logique métier nécessaire avant d'appeler la couche DAL.
        // Par exemple, des validations, des transformations de données, etc.

        // Appel de la couche DAL pour obtenir l'utilisateur.
        return utilisateurDao.connexionUtilisateur(pseudo, motDePasse);
    }

	@Override
	public Utilisateur afficherProfil(int noUtilisateur) throws Exception {
		// Appel de la couche DAL pour obtenir les infos de l'utilisateur
		return utilisateurDao.afficherProfil(noUtilisateur);
	}

	@Override
	public Utilisateur inscriptionUtilisateur(Utilisateur utilisateur) throws Exception {
		// Appel de la couche DAL pour réaliser une inscription utilisateur 
		return utilisateurDao.inscriptionUtilisateur(utilisateur);
	}

	@Override
	public Utilisateur modifierProfilUtilisateur(Utilisateur modifUtilisateur) {
		return utilisateurDao.modifierProfilUtilisateur(modifUtilisateur);
	}


	@Override
	public Utilisateur supprimerProfilUtilisateur(int noUtilisateur) throws Exception {
		return utilisateurDao.supprimerProfilUtilisateur(noUtilisateur);
	}
    
}
