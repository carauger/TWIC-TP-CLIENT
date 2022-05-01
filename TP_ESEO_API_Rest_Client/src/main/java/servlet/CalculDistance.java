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
 * Servlet implementation class CalculDistancee
 */
@WebServlet("/CalculDistance")
public class CalculDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDistance() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VilleService villeServ = new VilleService();
		request.setAttribute("villes", villeServ.getVilles());
        this.getServletContext().getRequestDispatcher("/WEB-INF/calculDistance.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ville villeDepart = new Ville();
		Ville villeArrivee = new Ville();

		// Retrieving Ville inputs from JSP
		villeDepart.setCodeCommuneINSEE(request.getParameter("ville1"));
		villeArrivee.setCodeCommuneINSEE(request.getParameter("ville2"));
		
		// Setting attribute "distance" to value returned by DAO getDistance() 
		request.setAttribute("distance", villeDepart.getDistance(villeArrivee));
		doGet(request, response);
	}

}
