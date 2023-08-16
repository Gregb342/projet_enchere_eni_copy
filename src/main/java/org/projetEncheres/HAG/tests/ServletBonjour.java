package org.projetEncheres.HAG.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bonjour")
public class ServletBonjour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);

// 		METHODE POUR CONNEXION LOGIN MDP		
//		ConnexionForm form = new ConnexionForm();
//		
//		form.verifierIdentifiants(request);
//		
//		request.setAttribute("form", form);
				
	 this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		
	}

}
