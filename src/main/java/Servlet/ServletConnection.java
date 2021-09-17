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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connection.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		Utilisateur u = new Utilisateur();
		u = b.Connection(request.getParameter("identifiant"));
		// Verification si l'utilisateur existe ou non
		if (u.getPseudo() != null || u.getEmail() != null) {

			// Verification si le mot de passe est correct
			if (u.getMotDePasse().equals(request.getParameter("motdepasse"))) {
				session.setAttribute("pseudo", u.getPseudo());
				session.setAttribute("email", u.getEmail());
				session.setAttribute("numeroUtilisateur", u.getNoUtilisateur());
				RequestDispatcher rd = request.getRequestDispatcher("/Accueil");
				rd.forward(request, response);
			} else if (!u.getMotDePasse().equals(request.getParameter("motdepasse"))) {
				request.setAttribute("alert", "Erreur mot de passe erronée");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connection.jsp");
				rd.forward(request, response);
			}

		} else if (u.getPseudo() == null) {
			request.setAttribute("alert", "Erreur pseudo inconnue");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connection.jsp");
			rd.forward(request, response);
		} else if (u.getEmail() == null) {
			request.setAttribute("alert", "Erreur email inconnue");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connection.jsp");
			rd.forward(request, response);
		}

	}
}
