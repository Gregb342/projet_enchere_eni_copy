package org.projetEncheres.HAG.tests;

import javax.servlet.http.HttpServletRequest;

public class ConnexionForm {
	private String resultat;
	
	public void verifierIdentifiants( HttpServletRequest request ) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		if (pass.equals(login + "123")) {
			resultat = "Vous êtes bien connecté !";
		}
		
		else {
			resultat = "identifiants incorrects";
		}
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
