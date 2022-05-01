package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Ville;
import service.VilleService;

/**
 * Servlet implementation class Afficher
 */
@WebServlet("/ModifierVille")
public class ModifierVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVille() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeCommune = request.getParameter("codeCommuneInsee");
		request.setAttribute("codeCommuneInsee", codeCommune);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifVille.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeCommune = request.getParameter("codeCommuneInsee");
        VilleService villeServ = new VilleService();
        Ville villeTemp = villeServ.trouverVille(codeCommune);
        
        String nom = request.getParameter("nomCommune");
		String codePostal = request.getParameter("codePostal");
		String libelle = request.getParameter("libelleAchem");
		String ligne5 = request.getParameter("ligne5");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		if(nom!="") {villeTemp.setNomCommune(nom);}
		if(codePostal!="") {villeTemp.setCode_postal(codePostal) ;}
		if(libelle!="") {villeTemp.setLibelleAcheminement(libelle);}
		if(ligne5!="") {villeTemp.setLigne5(ligne5);}
		if(latitude!="") {villeTemp.setLatitude(latitude);}
		if(longitude!="") {villeTemp.setLongitude(longitude);}
		
		villeServ.modifierVille(villeTemp, codeCommune);
		this.doGet(request, response);
	}

}
