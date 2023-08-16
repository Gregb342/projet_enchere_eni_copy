<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
</head>
<body>
<p>Affichage des donn�es via Expression Language</p>
<p>Id utilisateur : ${utilisateur1.noUtilisateur }</p>
<p>Nom utilisateur : ${utilisateur1.nom }</p>
<p>Prenom utilisateur : ${utilisateur1.prenom }</p>
<p>Email utilisateur : ${utilisateur1.email }</p>

<p>Affichage de donn�e via JSTL</p>
<p><c:out value="Bonjour!" /></p>

<!-- Utilisation d'une variable de la servlet via jstl, avec valeur par default -->
<p><c:out value="${ utilisateur1.email }" default="pas d'email" /></p>

<!-- Definition d'une variable directement dans la jsp via JSTL, avec port�e "page" -->
<c:set var="pseudo" value="gregb342" scope="page" />
<p><c:out value="${ pseudo }" /></p>
<!-- Modification de la variable et affichage -->
<c:set var="pseudo" value="truite" scope="page" />
<p><c:out value="${ pseudo }" /></p>

<!-- Modification d'un attribut r�cup�r� de la servlet via JSTL, et affichage -->
<c:set target="${utilisateur1 }" property="prenom" value="john" />
<p><c:out value="${utilisateur1.prenom }" /></p>

<!-- Supprimer une variable de la m�moire via JSTL -->
<c:remove var="pseudo" scope="page" />

<!-- Test en JSTL -->
<c:if test="${ 50 > 10 }" var="variable">C'est vrai</c:if> 
<!-- "variable" enregistre le resultat du test en variable, port�e par d�faut "page" -->
<!-- On peut modifier le "scope" en attribut -->
<!-- pas de else ou else if avec cette syntaxe -->

<!-- Va tester tout les when les uns apres les autres -->
<c:choose> 

	<c:when test="${ variable }">Du texte</c:when> 
	<c:when test="${ autreVariable }">Du texte</c:when>
	<c:when test="${ encoreUneAutreVariable }">Du texte</c:when>
	<c:otherwise></c:otherwise> 

</c:choose>
<!-- otherwise : Condition finale qui affichera si aucune autre condition n'est affich�e -->

<!-- Boucles en JSTL -->
<c:forEach var="i" begin="0" end="10" step="1"><p>message <c:out value="${i }" /> </p></c:forEach>

<!-- Parcours de tableau avec un foreach -->
<c:forEach items="${ titres }" var="titre" varStatus="status">
<p>N� <c:out value="${ status.count }" /> <c:out value="${ titre }" /></p>
<!-- status donne le status actuel sur la parcours d'un tableau -->
<!-- parametres : status.count : compte depuis 1 -->
<!-- 			status.index : compte depuis 0 -->
<!-- 			status.current : numero de l'�l�ment courant -->
<!-- 			status.first : premier de la liste -->
<!-- 			status.last : dernier de la liste -->
</c:forEach>

<!-- boucle for d�di�e aux chaines de caracteres : c:forTokens -->
<c:forTokens var="morceau" items="Un �l�ment/Encore un autre �l�ment/Un dernier pour la route" delims="/">
	<p>${morceau }</p>
</c:forTokens>
</body>
</html>