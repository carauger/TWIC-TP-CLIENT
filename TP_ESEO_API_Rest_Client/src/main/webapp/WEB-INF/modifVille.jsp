<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edition d'une ville</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<form action="home" method="post">
	<div>
		<div>
		<label for="nomCommune">Nom de la commune : </label> 
		<input type="text" name="nomCommune" id="nomCommune" value="${ville.getNomCommune()}" required><br>
		</div>
		<div>
		<label for="codePostal">Code Postal : </label> 
		<input type="text" name="codePostal" id="codePostal" value="${ville.getCodePostal()}" required><br>
		</div>
		<div>
		<label for="libelleAchem">Libelle Acheminement: </label> 
		<input type="text" name="libelleAchem" id="libelleAchem" value="${ville.getLibelleAcheminement()}" required><br>
		</div>
		<div>
		<label for="ligne5">Ligne 5 : </label> 
		<input type="text" name="ligne5" id="ligne5" value="${ville.getLigne5()}" required><br>
		</div>
		<div>
		<label for="latitude">Latitude : </label> 
		<input type="text" name="latitude" id="latitude" value="${ville.getLatitude()}" required><br>
		</div>
		<div>
		<label for="longitude">Longitude : </label> 
		<input type="text" name="longitude" id="longitude" value="${ville.getLongitude()}" required><br>
		</div>
	</div>
	<div class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
		<input type="submit" value="Modifier la ville">
	</div>
			
	</form>
	
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