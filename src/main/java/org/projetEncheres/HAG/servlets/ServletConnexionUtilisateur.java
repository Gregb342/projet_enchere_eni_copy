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


@WebServlet("/pageConnexion")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnexionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		
		// Utilisation du manager dans la BLL
		UtilisateurManager utilisateurManager = new UtilisateurManagerImpl(); 
		
				try {
		    Utilisateur utilisateur = utilisateurManager.connexionUtilisateur(pseudo, motDePasse);

		    if (utilisateur != null) {
		    	HttpSession session = request.getSession();
		    	session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
		        // Redirection vers la page d'accueil ou autre (a completer).
		        response.sendRedirect("profilUtilisateur");
		        return;
		    } else {
		    	// Message à afficher sur la page de connexion si la connexion ne fonctionne pas
		    	// (non fonctionnel actuellement)
		    	request.setAttribute("messageErreur", "Login ou mot de passe incorrect !");
		    }
		} catch (Exception e) {
				e.printStackTrace();
		}
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
	}

}
