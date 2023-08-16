<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
    <meta charset="UTF-8">
    <title>Inscription ENI-Enchères</title>
</head>
<%@ include file="header.jsp" %>
<body>

    <div class="centered-div"><h1>Inscription</h1>
    <form class="clean-form" action="pageInscription" method="post">
        
        <label for="pseudo">Pseudo :</label>
        <input type="text" id="pseudo" name="pseudo" required><br>

        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required><br>

        <label for="email">E-mail :</label>
        <input type="email" id="email" name="email" required><br>

        <label for="telephone">Téléphone :</label>
        <input type="tel" id="telephone" name="telephone" required><br>

        <label for="rue">Rue :</label>
        <input type="text" id="rue" name="rue" required><br>

        <label for="codePostal">Code postal :</label>
        <input type="text" id="codePostal" name="codePostal" required><br>

        <label for="ville">Ville :</label>
        <input type="text" id="ville" name="ville" required><br>

        <label for="motDePasse">Mot de passe :</label>
        <input type="password" id="motDePasse" name="motDePasse" required><br>


       
        <input type="submit" value="S'inscrire">
        <input type="button" value="Annuler">
        
    </form>
    
    <p>    <c:if test="${ !empty erreur}">
    	<p style="color: red;">${erreur}</p>
	</c:if></p>
	</div>

</body>
</html>
