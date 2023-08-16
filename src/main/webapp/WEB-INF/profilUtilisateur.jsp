<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="utf-8">
<title>Profil ${profilUtilisateur.pseudo}</title>
</head>
<body>
<%@ include file="header.jsp" %>

<main>	
		<c:if test="${ !empty profilUtilisateur}">
		    <!-- Affichage des informations de l'utilisateur -->
		    <div class="centered-div"><p>Profil utilisateur : ${profilUtilisateur.pseudo} !</p>
<%-- 		    <p>Numero Utilisateur : ${profilUtilisateur.noUtilisateur}</p> --%>
		    <p>Pseudo : ${profilUtilisateur.pseudo}</p>
		    <p>Nom	: ${profilUtilisateur.nom}</p>
		    <p>Prenom : ${profilUtilisateur.prenom}</p>
		    <p>Email : ${profilUtilisateur.email}</p>
		    <p>Telephone : ${profilUtilisateur.telephone}</p>
		    <p>Rue : ${profilUtilisateur.rue}</p>
		    <p>Code Postal : ${profilUtilisateur.codePostal}</p>
		    <p>Ville : ${profilUtilisateur.ville}</p>
<%-- 		    <p>Mot de passe : ${profilUtilisateur.motDePasse}</p> --%>
		    <p>Credit actuel : ${profilUtilisateur.credit}</p>
<%-- 		    <p>Administrateur : ${profilUtilisateur.administrateur}</p>  --%>
		    </div>   
		</c:if>
	
	<a href="modifierProfil"><input type="button" value="Modifier"></a>
		<c:if test="${empty profilUtilisateur}">
			<% System.out.println("JSP ERROR Aucun utilisateur trouvé avec l'identifiant utilisateur"); %>
		</c:if>
		
		<c:if test="${ !empty modifok}">
    	<p>${modifok}</p>
	</c:if>

</main>


</body>
</html>