package org.projetEncheres.HAG.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.projetEncheres.HAG.bll.UtilisateurManager;
import org.projetEncheres.HAG.bll.UtilisateurManagerImpl;
import org.projetEncheres.HAG.bo.Utilisateur;


@WebServlet("/profilUtilisateur")
public class ServletProfilUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletProfilUtilisateur() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int noUtilisateur = 0;
	
		// Récupérer le numéro d'identifiant utilisateur (noUtilisateur) de la session.
				try {
					
					noUtilisateur = (int) request.getSession().getAttribute("noUtilisateur");
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
				this.getServletContext().getRequestDispatcher("/WEB-INF/profilUtilisateur.jsp").forward(request, response);
			}
				 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
