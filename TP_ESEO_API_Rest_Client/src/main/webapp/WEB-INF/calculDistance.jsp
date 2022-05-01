<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calcul Distance</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>	
	<br>
	<br>
	<form action="calculDistance" method="post">
		
		<label for="ville1">Ville de départ</label> 
		<select name="ville1" id="ville1">
			<option value="">-</option>
			<c:forEach items="${ville}" var="current" varStatus="status">
				<option value="${current.getCodeCommuneINSEE()}">
					${current.getNomCommune()} (${current.getCodePostal()})
				</option>
			</c:forEach>
		</select> 
					
		<label for="ville2">Ville d'arrivée</label> 
		<select name="ville2" id="ville2" onchange="">
			<option value="">-</option>
			<c:forEach items="${ville}" var="current" varStatus="status">
				<option value="${current.getCodeCommuneINSEE()}">
					${current.getNomCommune()} (${current.getCodePostal()})
				</option>
			</c:forEach>
		</select>
	
		<br>
		<div class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
			<input type="submit" value="Calculer"/>		
		</div>
		<br><br>
	
		<div>
			<a>Distance calculée :<strong>${distance} km</strong></a>
		</div>
	</form>
	<br>
	<div class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
		<a href="/Accueil">Annuler</a>
	</div>
</body>
	<footer class="fixed left-0 bottom-0 inset-x-0 bottom-0 p-4 bg-white rounded-lg shadow md:items-center dark:bg-gray-800">
		<span class="text-sm text-gray-500 sm:text-center dark:text-gray-400">
		    Contact : <br/>
            Caroline Auger - caroline.auger@reseau.eseo.fr
		</span>
	</footer>
</html>