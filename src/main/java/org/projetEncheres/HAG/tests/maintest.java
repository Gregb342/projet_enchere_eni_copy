package org.projetEncheres.HAG.tests;

import org.projetEncheres.HAG.bo.Utilisateur;
import org.projetEncheres.HAG.dal.jdbc.UtilisateurDaoImpl;

public class maintest {

	public static void main(String[] args) {
		
		UtilisateurDaoImpl utilisateurConnexionDao = new UtilisateurDaoImpl();
		
				try {
            Utilisateur utilisateur = utilisateurConnexionDao.connexionUtilisateur("Gregb342", "blublublu");

            //  vérifier les résultats ou afficher des informations sur l'utilisateur récupéré
            if (utilisateur != null) {
                System.out.println("Utilisateur trouvé : " + utilisateur);
                // pour l'instant l'affichage des informations de l'utilisateur ne fonctionne pas
            } else {
                System.out.println("Aucun utilisateur trouvé avec les informations de connexion fournies.");
            }
        } catch (Exception e) {
            // Gérez l'exception (connexion à la base de données, erreur SQL, etc.)
            e.printStackTrace();
        }
	}

}
