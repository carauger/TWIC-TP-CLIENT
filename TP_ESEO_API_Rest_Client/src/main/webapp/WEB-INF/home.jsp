<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<br>
	<div class="flex justify-center">
		<p>
			Bienvenue sur votre application de calcul de distance entre les villes de france
		</p>
	</div>
		<div class="flex justify-center">
		<p>
			Vous pouvez également modifier, supprimer et ajouter des villes
		</p>
	</div>
	<br>
	
	<div class="flex justify-around">
		<div class="grid justify-items-start bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
			<form action="ajoutVille" method="post">
				<input class="" type="submit" value="Ajouter une ville" />
			</form>
		</div>
		<div class="grid justify-items-end bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
			<form action="calculDistance" method="post">
				<input class="" type="submit" value="Calculer une distance" />
			</form>
		</div>
	</div>
	<br>
	<div>
        <table>
            <tr>
                <th>Code INSEE</th>
                <th>Commune</th>
                <th>Code Postal</th>
                <th>Libelle Acheminement</th>
                <th>Ligne 5</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Modifer</th>
                <th>Supprimer</th>

            </tr>
            <c:forEach items="${villesAffichees}" var="ville">
                <tr>
                    <td scope="row">${ville.getCodeCommuneINSEE()}</td>
                    <td>${ville.getNomCommune()}</td>
                    <td>${ville.getCodePostal()}</td>
                    <td>${ville.getLibelleAcheminement()}</td>
                    <td>${ville.getLigne5()}</td>
                    <td>${ville.getLatitude()}</td>
                    <td>${ville.getLongitude()}</td>
                   	<td><a class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full" 
                   		href="/modifVille?codeCommuneInsee=${ ville.getCodeCommuneINSEE() }">Modifier</a></td>
					<td><a class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full" 
                   		href="/supprVille?codeCommuneInsee=${ ville.getCodeCommuneINSEE() }">Supprimer</a></td>
                </tr>
            </c:forEach>
        </table>

        <form method = "post" action="ListeVille">
            <c:forEach var="i" begin="1" end="68">
                <input type="submit" type="hidden" name="numPage" id="numPage" value="${i}">
            </c:forEach>
        </form>

    </div>
</body>
	<footer class="fixed left-0 bottom-0 inset-x-0 bottom-0 p-4 bg-white rounded-lg shadow md:items-center dark:bg-gray-800">
		<span class="text-sm text-gray-500 sm:text-center dark:text-gray-400">
		    Contact : <br/>
            Caroline Auger - caroline.auger@reseau.eseo.fr
		</span>
	</footer>

</html>