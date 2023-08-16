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
import org.projetEncheres.HAG.dal.jdbc.UtilisateurDaoImpl;


@WebServlet("/pageInscription")
public class ServletInscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletInscriptionUtilisateur() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Utilisation du manager dans la BLL
			UtilisateurManager utilisateurManager = new UtilisateurManagerImpl();
			
		    Utilisateur nouvelUtilisateur = new Utilisateur(
	        request.getParameter("pseudo"), 
	        request.getParameter("nom"),
	        request.getParameter("prenom"), 
	        request.getParameter("email"), 
	        request.getParameter("telephone"), 
	        request.getParameter("rue"), 
	        request.getParameter("codePostal"),
	        request.getParameter("ville"),
	        request.getParameter("motDePasse"));
	    
	    Utilisateur utilisateurCree = null;
		try {
			utilisateurCree = utilisateurManager.inscriptionUtilisateur(nouvelUtilisateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if (utilisateurCree != null) {

	    	// L'enregistrement a réussi, redirection vers accueil
	        response.sendRedirect("Accueil");
	        System.out.println("Inscription réussie !");
	        return;
	    } else {
	    	// L'enregistrement a échoué, message d'erreur
	        request.setAttribute("erreur", "L'email ou le pseudo existe déjà.");
	        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}

	}
	
}
   