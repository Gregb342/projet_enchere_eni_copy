<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Page de Connexion</title>
</head>
<body>
<%@ include file="header.jsp" %>
<main>
    <div class="centered-div">
    <form action="pageConnexion" method="post">
		        <label for="pseudo">Pseudo :</label>
        <input type="text" id="pseudo" name="pseudo"><br>

        <label for="motDePasse">Mot de passe :</label>
        <input type="password" id="motDePasse" name="motDePasse"><br>


        <input type="submit" value="Se connecter">
        
        <label for="maCase">Se souvenir de moi</label>
    <input type="checkbox" id="maCase" name="maCase">
    
    <a href="Mot de passe oublié">Mot de passe oublié</a>
    
    <input type="submit" value="Créer un Compte">
    </form>
    <c:if test="${ !empty messageErreur}">
    	<p style="color: red;">${messageErreur}</p>
	</c:if>
            </div>
    
<%--     <c:if test="${ !empty utilisateurConnecte}"> --%>
<!--     Affichage des informations de l'utilisateur -->
<%--     <p>Bienvenue, ${utilisateurConnecte.pseudo} !</p> --%>
<!--     Vous pouvez afficher d'autres informations de l'utilisateur ici -->
<%-- </c:if> --%>


</main>    
</body>
</html>