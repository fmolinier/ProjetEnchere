package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import bll.GestionUtilisateurBLL;
import bo.Utilisateur;

@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = -7765659313742692757L;

	/**
	 * Default constructor.
	 */
	public ServletInscription() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		Utilisateur u = new Utilisateur();
		//TODO email en minuscule / mise en page css
		// recuperation des information
		u.setPseudo(request.getParameter("pseudo"));
		u.setNom(request.getParameter("nom"));
		u.setPrenom(request.getParameter("prenom"));
		u.setEmail(request.getParameter("email"));
		u.setTelephone(request.getParameter("telephone"));
		u.setRue(request.getParameter("rue"));
		u.setCodePostal(Integer.parseInt(request.getParameter("codepostal")));
		u.setVille(request.getParameter("ville"));
		
		boolean pseudo = b.verifPseudo(request.getParameter("pseudo"));
		boolean email = b.verifEmail(request.getParameter("email"));
		if (email && pseudo) {		
			// on verifie que le mot de passe correspond a la confirmation du
			// mot de passe
			String MotDePasse = request.getParameter("motdepasse");
			String confirmation = request.getParameter("confirmation");
			
			if (MotDePasse.equals(confirmation)) {
				
				u.setMotDePasse(MotDePasse);
				b.InscriptionUtilisateur(u);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connection.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("alert","la confirmation du mot de passe est incorrecte");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);
			}
		}else {
			if (!pseudo) {
				request.setAttribute("alert","le pseudo est deja utiliser");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);
			} else if (!email) {
				request.setAttribute("alert","l'Email est deja utiliser");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
				rd.forward(request, response);
			}
			
		}
		
	}
}
