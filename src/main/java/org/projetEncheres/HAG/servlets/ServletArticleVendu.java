package org.projetEncheres.HAG.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.projetEncheres.HAG.bo.ArticleVendu;
import org.projetEncheres.HAG.dal.jdbc.ArticleVenduDaoImpl;


@WebServlet("/articleVendu")
public class ServletArticleVendu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletArticleVendu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/articleVendu.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("dateDebutEncheres"));
		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ArticleVenduDaoImpl creationArticle = new ArticleVenduDaoImpl();
	    ArticleVendu nouvelArticle = new ArticleVendu(	
	    	request.getParameter("nomArticle"),
	    	request.getParameter("description"),
	    	LocalDate.parse(request.getParameter("dateDebutEncheres"),DATEFORMATTER),
	    	LocalDate.parse(request.getParameter("dateFinEncheres"),DATEFORMATTER),
	    	Integer.parseInt(request.getParameter("miseAPrix")),
	    	Integer.parseInt(request.getParameter("prixVente"))
	    );
	    		
	    ArticleVendu articleCree = null; 
	    try {	    
	    articleCree = creationArticle.miseEnVente(nouvelArticle);}
	    catch (Exception e) {
			e.printStackTrace();
		}
			
	    
	    if (articleCree != null) {

	        // L'enregistrement a réussi, redirection vers accueil
	        response.sendRedirect("Accueil");
	        System.out.println("Nouvel article enrgistré !");
	        return;
	        
	    } 

	}
	        
	}
