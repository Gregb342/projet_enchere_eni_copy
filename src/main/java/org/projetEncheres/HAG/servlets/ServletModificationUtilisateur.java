package org.projetEncheres.HAG.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.projetEncheres.HAG.bll.UtilisateurManager;
import org.projetEncheres.HAG.bll.UtilisateurManagerImpl;
import org.projetEncheres.HAG.bo.Utilisateur;


@WebServlet("/modifierProfil")
public class ServletModificationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletModificationUtilisateur() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noUtilisateur = 0;
		
		// Récupérer le numéro d'identifiant utilisateur (noUtilisateur) de la session.
				try {
					
					noUtilisateur = (int) request.getSession().getAttribute("noUtilisateur");
					System.out.println("doGet NoUtilisateur récupéré de la session : " + noUtilisateur);
				} catch (Exception e) {
					response.sendRedirect("pageConnexion");
			        return;
				}
				// Utilisation du manager dans la BLL
				UtilisateurManager utilisateurManager = new UtilisateurManagerImpl();

				try {
				    // Récupérer les informations de l'utilisateur à l'aide de la méthode afficherProfil.
				    Utilisateur profilUtilisateur = utilisateurManager.afficherProfil(noUtilisateur);

				    if (profilUtilisateur != null) {
				        // L'utilisateur est trouvé dans la base de données.
				        // Mettre l'utilisateur dans les attributs de la requête pour l'utiliser dans la JSP.
				        request.setAttribute("profilUtilisateur", profilUtilisateur);

				        // Redirection vers la page profilUtilisateur.jsp.
				        
				    } else {
				        // L'utilisateur n'est pas trouvé dans la base de données ou les informations sont incorrectes.
				        System.out.println("SERVLET ERROR Aucun utilisateur trouvé avec l'identifiant utilisateur : " + noUtilisateur);
				        // message d'erreur pour l'afficher dans la JSP
				        // request.setAttribute("messageErreur", "Aucun utilisateur trouvé avec l'identifiant utilisateur fourni.");
				        response.sendRedirect("pageConnexion");
				        return;
				    }
				} catch (Exception e) {
				    e.printStackTrace();
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/modificationProfilUtilisateur.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noUtilisateur = 0;
		
		// Récupérer le numéro d'identifiant utilisateur (noUtilisateur) de la session.
		try {
			
			noUtilisateur = (int) request.getSession().getAttribute("noUtilisateur");
			System.out.println("doPost NoUtilisateur récupéré de la session : " + noUtilisateur);
		} catch (Exception e) {
			response.sendRedirect("pageConnexion");
	        return;
		}
		// Utilisation du manager dans la BLL
					UtilisateurManager utilisateurManager = new UtilisateurManagerImpl();
					
				    Utilisateur modifUtilisateur = new Utilisateur(
			        request.getParameter("pseudo"), 
			        request.getParameter("nom"),
			        request.getParameter("prenom"), 
			        request.getParameter("email"), 
			        request.getParameter("telephone"), 
			        request.getParameter("rue"), 
			        request.getParameter("codePostal"),
			        request.getParameter("ville"),
			        request.getParameter("motDePasse"));
				    
				    modifUtilisateur.setNoUtilisateur(noUtilisateur);
			    
			    Utilisateur utilisateurModifie = null;
				try {
					utilisateurModifie = utilisateurManager.modifierProfilUtilisateur(modifUtilisateur);
				} catch (Exception e) {
					e.printStackTrace();
				}
			    
			    if (utilisateurModifie != null) {

			        // La modification du profil a été correcteur effectuée, redirection vers la page du profil.
			    	request.setAttribute("modifok", "Modification enregistrée");
			    	response.sendRedirect("profilUtilisateur");
			        System.out.println("Modification réussie !");
			        return;
			    } else {
			        // La modification a échoué, redirection vers la page d'inscription avec un message d'erreur
			        request.setAttribute("erreur", "Probleme à la modification");
			        this.getServletContext().getRequestDispatcher("/WEB-INF/modificationProfilUtilisateur.jsp").forward(request, response);
				}

			}
			
		}