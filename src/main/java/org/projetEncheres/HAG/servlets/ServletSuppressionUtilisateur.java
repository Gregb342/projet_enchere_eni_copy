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


@WebServlet("/suppressionUtilisateur")
public class ServletSuppressionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSuppressionUtilisateur() {
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
						utilisateurManager.supprimerProfilUtilisateur(noUtilisateur);
						System.out.println("SERVLET Suppression de l'utilisateur effectuée");
						
						request.getSession().invalidate();
				   
				} catch (Exception e) {
				    e.printStackTrace();
				}
		this.getServletContext().getRequestDispatcher("/WEB-INF/suppressionProfilUtilisateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
