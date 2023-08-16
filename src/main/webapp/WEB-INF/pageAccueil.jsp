<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">

	<head>
		<meta charset="utf-8">
		<title>Accueil</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
		<body>
<%@ include file="header.jsp" %>
	<div class="centered-div">
			<h2> Liste des enchères</h2>

			<form method="get" action="">
				<p class="filtres"> Filtres :</p>
					<input type="text" name="champ de recherche" placeholder="Le nom de l'article contient">
			
				<p>Catégories :</p>
				<select name="Catégories">
					<option value="Toutes">Toutes</option>
					<option value="Informatique">Informatique</option>
					<option value="Ameublement">Ameublement</option>
					<option value="Vêtements">Vêtements</option>
					<option value="Sports&Loisirs">Sports&Loisirs</option>
				</select>
			</form>

			<form method ="get" action="">
			</form>
			<div class="encheres-div">
				<div>
					<img width="200" src="images/ameublement.jpg">
					<p><strong>Bureau</strong></p>
					<p>Prix : </p>
					<p>Vendeur :</p>
					<p>Fin de l'enchère :</p>
				</div>
					
				<div>
					<img width="200" src="images/sportetloisirs.jpg">
					<p><strong>Sports</strong> </p>
					<p>Prix : </p>
					<p>Vendeur :</p>
					<p>Fin de l'enchère :</p>
				</div>
				<div>
					<img width="200" src="images/pcgamer.jpg">
					<p><strong>PC Gamer</strong> </p>
					<p>Prix : </p>
					<p>Vendeur :</p>
					<p>Fin de l'enchère :</p>
				</div>
				<div>
					<img width="200" src="images/vetements.jpg">
					<p><strong>Vetements</strong> </p>
					<p>Prix : </p>
					<p>Vendeur :</p>
					<p>Fin de l'enchère :</p>
				</div>	
										
			</div>
		</div>
		</body>

</html>