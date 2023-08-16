package org.projetEncheres.HAG.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.projetEncheres.HAG.bo.Utilisateur;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] titres = {"Nouvel incendie", "une ile a été découverte", "chute du dollar"};
		request.setAttribute("titres", titres);
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setNoUtilisateur(1);
		utilisateur1.setNom("Bouteillier");
		utilisateur1.setPrenom("Gregoire");
		utilisateur1.setEmail("gregoire.bouteillier@gmail.com");
		request.setAttribute("utilisateur1", utilisateur1);
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
