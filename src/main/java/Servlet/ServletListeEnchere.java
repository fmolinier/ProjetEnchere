package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import bll.ListeEnchereBLL;
import bo.Article;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/recherche")
public class ServletListeEnchere extends HttpServlet {

	private static final long serialVersionUID = -6264262126743044394L;

	public ServletListeEnchere() {
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
		ListeEnchereBLL b = new ListeEnchereBLL();
		List<Article> liste = new ArrayList<Article>();
		String pseudo = (String) session.getAttribute("pseudo");
		String categorie = request.getParameter("categorie");
		String recherche = request.getParameter("recherche");

		if (pseudo == null) {
			if (categorie.equals("tous") && recherche.isBlank()) {

				liste = b.listeEnchere();

			} else if (!categorie.equals("tous") && recherche.isBlank()) {

				liste = b.listeCategorie(categorie);

			} else if (!recherche.isBlank() && categorie.equals("tous")) {

				liste = b.listeNomArticle(recherche);

			} else if (!recherche.isBlank() && !categorie.equals("tous")) {

				liste = b.listeNomEtCategorieArticle(recherche, categorie);

			}
		} else {
			if (request.getParameter("AchatsVente").equals("ventesencours")) {
				
				System.out.println("-------------------------------servlet--ventesencours");
				liste = b.listeMesVenteEnCours(pseudo,recherche,categorie);

			} else if (request.getParameter("AchatsVente").equals("venteNonDebute")) {
				
				System.out.println("-------------------------------servlet--venteNonDebute");
				liste = b.listeMesVenteNonDebute(pseudo,recherche,categorie);

			} else if (request.getParameter("AchatsVente").equals("enchereremporter")) {
				
				System.out.println("-------------------------------servlet--enchereremporter");
				liste = b.listeMesVenteRemporte(pseudo,recherche,categorie);

			} else if (request.getParameter("AchatsVente").equals("venteTerminer")) {
				
				System.out.println("-------------------------------servlet--venteTerminer");
				liste = b.listeMesVenteTerminer(pseudo,recherche,categorie);

			} else if (request.getParameter("AchatsVente").equals("enchereEnCours")) {
				
				System.out.println("-------------------------------servlet--enchereEnCours");
				liste = b.listeMesEnchereEnCours(pseudo,recherche,categorie);
			}

			else if (request.getParameter("AchatsVente").equals("enchereOuverte")) {
				
				System.out.println("-------------------------------servlet--enchereOuverte");
				liste = b.listeEnchere();
			}
		}

		request.setAttribute("liste", liste);
		System.out.println("---------------------------servlet");
		System.out.println(liste);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);

	}
}
