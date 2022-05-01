<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		 
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Accueil</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>

        	<div class="flex justify-center m-15" >
            <p>
                Bienvenue sur votre application de calcul de distance entre les villes de france
            </p>
            <p>
                Vous pouvez également consulter et modifier la liste des villes
            </p>
            </div>
            <br>
            <br>
            <div class="grid justify-items-stretch">
                <div class="justify-self-auto">
                    <form action="affichage" method="post">
                        <input class ="" type="submit" value="Accéder à la liste"/>
                    </form>
                </div>
                <div class="justify-self-auto">
                    <form class="justify-self-auto" action="calcul" method="post">
                        <input class="" type="submit" value="Calculer une distance"/>
                    </form>
                </div>
            </div>
        </div>
        
        <footer class="flex justify center bg-grey table-footer-group">
            Contact : <br/>
            Caroline Auger - caroline.auger@reseau.eseo.fr<br>
        </footer>
    </body>


</html>