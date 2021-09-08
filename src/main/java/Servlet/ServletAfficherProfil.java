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


@WebServlet(
		urlPatterns= {
						"/MonProfil",
						"/Profil"
		})
public class ServletAfficherProfil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522942704590524587L;

    public ServletAfficherProfil() {
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
		GestionUtilisateurBLL b = new GestionUtilisateurBLL();
		HttpSession session = request.getSession();
		Utilisateur u = new Utilisateur();
		//si c'est le profil de l'utilisateur
		if (request.getServletPath().equals("/MonProfil")) {
			u = b.afficherProfil( (String) session.getAttribute("pseudo"));
			request.setAttribute("pseudo", u.getPseudo());
			request.setAttribute("nom", u.getNom());
			request.setAttribute("prenom", u.getPrenom());
			request.setAttribute("email", u.getEmail());
			request.setAttribute("telephone", u.getTelephone());
			request.setAttribute("rue", u.getRue());
			request.setAttribute("codepostal", u.getCodePostal());
			request.setAttribute("ville", u.getVille());
			request.setAttribute("motdepasse", u.getMotDePasse());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monProfil.jsp");
			rd.forward(request, response);
			//si c'est le profil d'un autre utilisateur
		}else if (request.getServletPath().equals("/Profil")){
			String pseudo = request.getParameter("pseudo");
			u = b.afficherProfil(pseudo);
			request.setAttribute("pseudo", u.getPseudo());
			request.setAttribute("nom", u.getNom());
			request.setAttribute("prenom", u.getPrenom());
			request.setAttribute("email", u.getEmail());
			request.setAttribute("telephone", u.getTelephone());
			request.setAttribute("rue", u.getRue());
			request.setAttribute("codepostal", u.getCodePostal());
			request.setAttribute("ville", u.getVille());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
			rd.forward(request, response);
		}
	}

}
