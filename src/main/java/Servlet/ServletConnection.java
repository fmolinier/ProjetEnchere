package Servlet;

import java.io.IOException;
import bll.GestionUtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/connection")
public class ServletConnection extends HttpServlet {
	

	private static final long serialVersionUID = 2668221621133906349L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnection() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		Utilisateur u = new Utilisateur();

		u = b.Connection(request.getParameter("pseudo"), request.getParameter("motDePasse"));
		if (u.getPseudo() != null && u.getEmail() != null) {
			session.setAttribute("pseudo", u.getPseudo());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("numeroUtilisateur", u.getNoUtilisateur());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Acceuil.jsp");//TODO A tester
			rd.forward(request, response);
		}else {
			request.setAttribute("alert", "le pseudo / mot de passe est incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connection.jsp");//TODO A tester
			rd.forward(request, response);
		}
		//TODO alert ereur
	}
}
