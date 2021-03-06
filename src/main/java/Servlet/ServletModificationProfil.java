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

@WebServlet(urlPatterns = { "/modifier", "/supprimer" })
public class ServletModificationProfil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5326180208976158071L;

	public ServletModificationProfil() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		Utilisateur u = new Utilisateur();
		HttpSession session = request.getSession();
		String confirmation = request.getParameter("confirmation");
		String nmdp = request.getParameter("nouveaumotdepasse");
		if (request.getServletPath().equals("/modifier")) {
			// recuperation des information
			u.setPseudo(request.getParameter("pseudo"));
			u.setNom(request.getParameter("nom"));
			u.setPrenom(request.getParameter("prenom"));
			u.setEmail(request.getParameter("email"));
			u.setTelephone(request.getParameter("telephone"));
			u.setRue(request.getParameter("rue"));
			u.setCodePostal(Integer.parseInt(request.getParameter("codepostal")));
			u.setVille(request.getParameter("ville"));

			// recuperation info session
			String pseudoActuel = (String) session.getAttribute("pseudo");
			String emailActuel = (String) session.getAttribute("email");
			boolean pseudo = b.verifPseudo(request.getParameter("pseudo"));
			boolean email = b.verifEmail(request.getParameter("email"));

			// on regarde si le mot de passe a ??t?? modifier
			if (confirmation.isBlank()) {

				if (email && pseudo) {
					u.setMotDePasse(request.getParameter("motdepasse"));
					u = b.modificationProfil(u, pseudoActuel, emailActuel);
					session.setAttribute("pseudo", u.getPseudo());
					session.setAttribute("email", u.getEmail());
					RequestDispatcher rd = request.getRequestDispatcher("/MonProfil");
					rd.forward(request, response);
				} else {
					if (!pseudo) {
						request.setAttribute("erreur", "le pseudo est deja utiliser");//TODO regarder pourquoi sa n'affiche pas tout
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
						rd.forward(request, response);
					} else if (!email) {
						request.setAttribute("erreur", "l'Email est deja utiliser");
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
						rd.forward(request, response);
					}

				}
				// on verifie que le nouveau mot de passe correspond a la confirmation du
				// nouveau mot de passe
			} else if (!confirmation.isBlank()) {
				if (nmdp.equals(confirmation)) {
					if (email && pseudo) {
						u.setMotDePasse(confirmation);
						u = b.modificationProfil(u, pseudoActuel, emailActuel);
						session.setAttribute("pseudo", u.getPseudo());
						session.setAttribute("email", u.getEmail());
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
						rd.forward(request, response);
					} else {
						if (!pseudo) {
							request.setAttribute("erreur", "le pseudo est deja utiliser");
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
							rd.forward(request, response);
						} else if (!email) {
							request.setAttribute("erreur", "l'Email est deja utiliser");
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
							rd.forward(request, response);
						}

					}
					// affichage des modification
					request.setAttribute("pseudo", u.getPseudo());
					request.setAttribute("nom", u.getNom());
					request.setAttribute("prenom", u.getPrenom());
					request.setAttribute("email", u.getEmail());
					request.setAttribute("telephone", u.getTelephone());
					request.setAttribute("rue", u.getRue());
					request.setAttribute("codePostal", u.getCodePostal());
					request.setAttribute("ville", u.getVille());
					request.setAttribute("motDePasse", u.getMotDePasse());

					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("erreur", "la confirmation du mot de passe est incorrecte");
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
					rd.forward(request, response);
				}
			}
		} else if (request.getServletPath().equals("/supprimer")) {
			b.SuprimerProfil((String) session.getAttribute("pseudo"));
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(request, response);
		}

	}
}
