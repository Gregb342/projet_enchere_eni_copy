package org.projetEncheres.HAG.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.projetEncheres.HAG.bo.Utilisateur;
import org.projetEncheres.HAG.dal.UtilisateurDao;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private final static String SQL_SELECTBYLOGINMDP_UTILISATEUR = 
			"SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	private final static String SQL_SELECTONE_UTILISATEUR =
			"SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	private final static String SQL_INSERT_INSCRIPTION_UTILISATEUR= 
			"INSERT INTO UTILISATEURS "
			+ "(pseudo,"
			+ "nom,"
			+ "prenom,"
			+ "email,"
			+ "telephone,"
			+ "rue,"
			+ "code_Postal,"
			+ "ville,"
			+ "mot_De_Passe,"
			+ "credit,"
			+ "administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)"; 
	private final static String  SQL_CHECK_UTILISATEUR_EXISTANT = 
			"SELECT * FROM utilisateurs WHERE email = ? OR pseudo = ?"; 
	
	private final static String SQL_UPDATE_USER_INFO=
			"UPDATE UTILISATEURS "
			+ "SET "
			+ "pseudo = ?, "
			+ "nom = ?, "
			+ "prenom = ?, "
			+ "email = ?, "
			+ "telephone = ?, "
			+ "rue = ?, "
			+ "code_Postal = ?, "
			+ "ville = ?, "
			+ "mot_De_Passe = ? "
			+ "WHERE no_utilisateur = ?";
	
	private final static String SQL_DELETE_USER = 
			"DELETE FROM utilisateurs WHERE no_utilisateur = ?";
	/*
	 * TODO List :
	 *  TROUVER UNE FONCTION DE HASHAGE POUR LE MOT DE PASSE
	 */
	
	@Override
	public Utilisateur connexionUtilisateur(String pseudo, String motDePasse) {
	
		// Etape 1 : connection via le connectionprovider
		try(Connection connection = ConnectionProvider.getConnection()) {
			
			// Etape 2 : création d'un objet pStmt pour appeller la methode
			// prepareStatement qui prends l'une de nos constante en parametre
			// et qui retourne un resultat de type PreparedStatement
			PreparedStatement pStmt = connection.prepareStatement(SQL_SELECTBYLOGINMDP_UTILISATEUR);
			
				
			//Etape 3 : on recupere les infos de l'utilisateur via le login et le mot de passe
			// les numéros correspondent au placement des wildcards "?" dans la requete annoncée
			// en constante, plus haut, dans l'ordre.
			pStmt.setString(1, pseudo);
			pStmt.setString(2, motDePasse);
			
			
			//Etape 4 : c'est une récupération de donnée, donc on apelle la méthode
			//executeQuery qui renvoie un résultat de type ResultSet	
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
		        // L'utilisateur existe et le mot de passe est correct
		        Utilisateur utilisateur = new Utilisateur();
		        utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		        utilisateur.setPseudo(rs.getString("pseudo"));
		        utilisateur.setNom(rs.getString("nom"));
		        utilisateur.setPrenom(rs.getString("prenom"));
		        utilisateur.setEmail(rs.getString("email"));
		        utilisateur.setTelephone(rs.getString("telephone"));
		        utilisateur.setRue(rs.getString("rue"));
		        utilisateur.setCodePostal(rs.getString("code_postal"));
		        utilisateur.setVille(rs.getString("ville"));
		        utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		        utilisateur.setCredit(rs.getInt("credit"));
		        utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
		        
		        return utilisateur; // Renvoyer l'objet utilisateur trouvé
		    } else {
		        // Aucun utilisateur trouvé avec les informations de connexion fournies.
		        return null;
		    }
			
		
		}
		
		catch (SQLException e) {
		e.printStackTrace();
		
		}
			
		return null;
	}

	@Override
	public Utilisateur afficherProfil(int noUtilisateur) {
		
				// Etape 1 : connection via le connectionprovider
			try(Connection connection = ConnectionProvider.getConnection()) {
				
				// Etape 2 : création d'un objet pStmt pour appeller la methode
				// prepareStatement qui prends l'une de nos constante en parametre
				// et qui retourne un resultat de type PreparedStatement
					PreparedStatement pStmt = connection.prepareStatement(SQL_SELECTONE_UTILISATEUR);
					
				//Etape 3 : on recupere les infos de l'utilisateur via noUtilisateur
					pStmt.setInt(1, noUtilisateur);
									
				//Etape 4 : c'est une récupération de donnée, donc on apelle la méthode
				//executeQuery qui renvoie un résultat de type ResultSet	
					ResultSet rs = pStmt.executeQuery();
				
				//Etape 5 : on va remplir l'objet "Utilisateur" avec les infos de chaques colonnes
				//qui correspondent à la valeur de la noUtilisateur ("no_utilisateur"), via une condition "si", 
				//si rs correspond bien à une valeur existante.
					if(rs.next()) {
						return new Utilisateur(
										rs.getInt("no_utilisateur"),
										rs.getString("pseudo"),
										rs.getString("nom"),
										rs.getString("prenom"),
										rs.getString("email"),
										rs.getString("telephone"),
										rs.getString("rue"),
										rs.getString("code_postal"),
										rs.getString("ville"),
										rs.getString("mot_de_passe"),
										rs.getInt("credit"),
										rs.getBoolean("administrateur"));

						} else {
				        // Aucun utilisateur trouvé avec les informations de connexion fournies.
				        return null;
				    }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
	public Utilisateur inscriptionUtilisateur(Utilisateur utilisateur) {
		// Etape 1 : 
		try(Connection connection = ConnectionProvider.getConnection()) {
			
//			 Verification sur le mail et le pseudo existent déjà dans la BDD
			PreparedStatement checkStmt = connection.prepareStatement(SQL_CHECK_UTILISATEUR_EXISTANT);
			checkStmt.setString(1, utilisateur.getEmail());
			checkStmt.setString(2, utilisateur.getPseudo());
			ResultSet rs = checkStmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("DAO Inscription Impossible !");
				return null;
				
			} else {
				// Etape 2 : 
				PreparedStatement pStmt = connection.prepareStatement(SQL_INSERT_INSCRIPTION_UTILISATEUR);
									
				//Etape 3 : 
				pStmt.setString(1, utilisateur.getPseudo());
	            pStmt.setString(2, utilisateur.getNom());
	            pStmt.setString(3, utilisateur.getPrenom());
	            pStmt.setString(4, utilisateur.getEmail());
	            pStmt.setString(5, utilisateur.getTelephone());
	            pStmt.setString(6, utilisateur.getRue());
	            pStmt.setString(7, utilisateur.getCodePostal());
	            pStmt.setString(8, utilisateur.getVille());
	            pStmt.setString(9, utilisateur.getMotDePasse());
	            pStmt.setInt(10, utilisateur.getCredit());
	            pStmt.setBoolean(11, utilisateur.isAdministrateur());
	            
	        	//Etape 4 : 	
	            int rowsAffected = pStmt.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Inscription réussie !");
	                return utilisateur;
	            } else {
	                System.out.println("L'inscription a échoué.");
	                return null;
	            }
			}
				
			} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Utilisateur modifierProfilUtilisateur(Utilisateur utilisateur) {
					// Etape 1 : 
				try(Connection connection = ConnectionProvider.getConnection()) {
					// Etape 2 : 
					PreparedStatement pStmt = connection.prepareStatement(SQL_UPDATE_USER_INFO);
										
					//Etape 3 : 
					pStmt.setString(1, utilisateur.getPseudo());
		            pStmt.setString(2, utilisateur.getNom());
		            pStmt.setString(3, utilisateur.getPrenom());
		            pStmt.setString(4, utilisateur.getEmail());
		            pStmt.setString(5, utilisateur.getTelephone());
		            pStmt.setString(6, utilisateur.getRue());
		            pStmt.setString(7, utilisateur.getCodePostal());
		            pStmt.setString(8, utilisateur.getVille());
		            pStmt.setString(9, utilisateur.getMotDePasse());
		            pStmt.setInt(10, utilisateur.getNoUtilisateur()); // Ajoute le noUtilisateur pour la clause WHERE
		            
		            pStmt.executeUpdate();
		            
		            return utilisateur;
				} catch (SQLException e) {
					System.out.println("DAO La connexion a la base de donnée a echoué");
					e.printStackTrace();
				}
		return null;
	}
	
	@Override
	public Utilisateur supprimerProfilUtilisateur(int noUtilisateur) {
	
		// Etape 1 : 
		try(Connection connection = ConnectionProvider.getConnection()) {
			// Etape 2 : 
			PreparedStatement pStmt = connection.prepareStatement(SQL_DELETE_USER);
			
			//Etape 3 : 
			
			pStmt.setInt(1, noUtilisateur);
			
			pStmt.executeUpdate();
			System.out.println("DAO Suppression de l'utilisateur effectuée");
		} catch (SQLException e) {
			System.out.println("DAO La connexion a la base de donnée a echoué");
			e.printStackTrace();
		}
return null;
			
	}
}


