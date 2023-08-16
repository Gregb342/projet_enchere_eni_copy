<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${ArticleVendu.dateDebutEncheres}" pattern="yyyy-MM-dd" />
<fmt:formatDate value="${ArticleVendu.dateFinEncheres}" pattern="yyyy-MM-dd" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Liste des enchères</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	<h1>Nouvelle vente</h1>

	<img src="" alt="image de l'enchère">

	<form action="articleVendu" method="post">
		<label for="nomArticle">Article :</label>
		<input type="text" id="nomArticle" name="nomArticle" required><br>
		<label for="description">Description :</label>
		<input type="text" id="description" name="description" required><br>

<!-- 		<label for="categorie">Catégorie :</label> -->
<!-- 		<select name="categories"> -->
<!-- 			<option value="toutes">Toutes</option> -->
<!-- 			<option value="informatique">Informatique</option> -->
<!-- 			<option value="ameublement">Ameublement</option> -->
<!-- 			<option value="vetements">Vêtements</option> -->
<!-- 			<option value="sportsLoisirs">Sports&Loisirs</option> -->
<!-- 		</select><br> -->
<!-- 		<label for="Photo de l'article">Photo de l'article :</label> -->
<!-- 		<a href="" download></a> -->
<!-- 			<button>Upload</button> <br> -->
			<label for="miseAPrix">Mise à prix :</label>
			<input type="number" id="miseAPrix" name="miseAPrix" value="0" min="0" max="1000" step="1"> <br>
			<label for="dateDebutEncheres">Début de l'enchère :</label>
			<input type="date" id="dateDebutEncheres" name="dateDebutEncheres" required><br>
			<label for="dateFinEncheres">Fin de l'enchère :</label>
			<input type="date" id="dateFinEncheres" name="dateFinEncheres" required><br>
			<label for="prixVente">Prix de vente :</label>
			<input type="number" id="prixVente" name="prixVente" value="0" min="0" max="1000" step="1"> <br>
			
			
		<input type="submit" value="Enregistrer">
        <input type="button" value="Annuler">
		<input type="button" value="Annuler la vente">
	</form>
	
<!-- <h3>Retrait</h3> -->
<!-- 	<form action="articleVendu" method="post"> -->
<!-- 		<label for="Rue">rue :</label> -->
<!-- 		<input type="text" id="rue" name="rue" required><br> -->
<!-- 		<label for="code postal">Code postal :</label> -->
<!-- 		<input type="text" id="code postal" name="code postal" required><br> -->
<!-- 		<label for="ville">Ville :</label> -->
<!-- 		<input type="text" id="Ville" name="Ville" required><br> -->
		
<!-- 		</form> -->
		
		
		
		
</body>
</html>