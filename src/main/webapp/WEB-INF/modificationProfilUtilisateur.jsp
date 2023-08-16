<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="utf-8">
<title>Modifier le Profil ${profilUtilisateur.pseudo}</title>
</head>
<body>
<%@ include file="header.jsp" %>

<main>	
	<div class="centered-div"><h1>Mon profil</h1>
    <form action="modifierProfil" method="post">
        
        <label for="pseudo">Pseudo :</label>
        <input type="text" id="pseudo" name="pseudo" value="${profilUtilisateur.pseudo}" required>

        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" value="${profilUtilisateur.nom}" required><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" value="${profilUtilisateur.prenom}" required>

        <label for="email">E-mail :</label>
        <input type="email" id="email" name="email" value="${profilUtilisateur.email}" required><br>

        <label for="telephone">Téléphone :</label>
        <input type="tel" id="telephone" name="telephone" value="${profilUtilisateur.telephone}" required>

        <label for="rue">Rue :</label>
        <input type="text" id="rue" name="rue" value="${profilUtilisateur.rue}" required><br>

        <label for="codePostal">Code postal :</label>
        <input type="text" id="codePostal" name="codePostal" value="${profilUtilisateur.codePostal}" required>

        <label for="ville">Ville :</label>
        <input type="text" id="ville" name="ville" value="${profilUtilisateur.ville}" required><br>

        <label for="motDePasse">Mot de passe actuel :</label>
        <input type="password" id="motDePasse" name="motDePasse" required><br>
        
        <input type="hidden" name="noUtilisateur" value="${profilUtilisateur.noUtilisateur}">
        
<!--         <label for="nMotDePasse">Nouveau mot de passe :</label> -->
<!--         <input type="password" id="nMotDePasse" name="nMotDePasse" required> -->
        
<!--         <label for="nMotDePasseBis">Nouveau mot de passe :</label> -->
<!--         <input type="password" id="nMotDePasseBis" name="nMotDePasseBis" required><br> -->
        
        <p>Credit actuel : ${profilUtilisateur.credit}</p>
	
	<input type="submit" value="Enregistrer">
	<a href="suppressionUtilisateur"><input type="button" value="Supprimer Mon Compte"></a>
        
    </form>
    </div>

</main>


</body>
</html>