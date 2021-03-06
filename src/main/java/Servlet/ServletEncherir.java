package Servlet;

import java.io.IOException;

import bll.FaireEnchereBLL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEncherir
 */
@WebServlet("/Encherir")
public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = -475532172454887677L;

	/**
     * Default constructor. 
     */
    public ServletEncherir() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FaireEnchereBLL fe = new FaireEnchereBLL();
		int proposition = Integer.parseInt(request.getParameter("proposition"));
		int prix =  Integer.parseInt(request.getParameter("prix"));
		int meilleure =  Integer.parseInt(request.getParameter("enchere"));
		if (meilleure != 0) {
			if (proposition > meilleure) {
				fe.Encherir(Integer.parseInt(request.getParameter("numero")), Integer.parseInt(request.getParameter("proposition")), (String) session.getAttribute("pseudo"));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("alert", "proposition trop basse");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DetailEnchere.jsp");
				rd.forward(request, response);
			}
		} else {
			if (proposition > prix) {
				fe.Encherir(Integer.parseInt(request.getParameter("numero")), Integer.parseInt(request.getParameter("proposition")), (String) session.getAttribute("pseudo"));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("alert", "proposition trop basse");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DetailEnchere.jsp");
				rd.forward(request, response);
			}
		}
	}

}
