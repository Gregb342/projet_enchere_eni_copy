<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Formulaires</title>
</head>
<body>



    <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        <p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    </c:if>
   
    <form method="post" action="bonjour">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
        </p>
        
        <input type="submit" />
    </form>
    

<!-- FORM POUR LOGIN ET MOT DE PASSE -->
<%-- 	<c:if test="${ !empty form.resultat }"> --%>
<!-- 	<p> -->
<%-- 	<c:out value="${ form.resultat }" /> --%>
<!-- 	</p> -->
<%-- 	</c:if> --%>
	
<!-- 	<form method="post" action="bonjour"> -->
<!-- 		<p> -->
<!-- 		<label for="login">Login : </label> -->
<!-- 		<input type="text" id="login" name="login" /> -->
<!-- 		</p> -->
		
<!-- 		<p> -->
<!-- 		<label for="pass">Mot de passe : </label> -->
<!-- 		<input type="password" id="pass" name="pass" /> -->
<!-- 		</p> -->
<!-- 		<input type="submit" />	 -->
<!-- 	</form> -->


</body>
</html>