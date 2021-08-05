package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bll.GestionEnchereBLL;
import bo.Article;
import bo.Retrait;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletNouvelleEnchere
 */
@WebServlet("/NouvelleEnchere")
public class ServletNouvelleEnchere extends HttpServlet {
	private static final long serialVersionUID = 6365299723574898361L;

	/**
	 * Default constructor.
	 */
	public ServletNouvelleEnchere() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NouveauEnchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionEnchereBLL e = new GestionEnchereBLL();
		HttpSession session = request.getSession();
		Article a = new Article();
		Retrait r = new Retrait();
		
		// recuperation des information
		a.setNomArticle(request.getParameter("nom"));
		a.setDescription(request.getParameter("description"));
		a.setMiseAPrix(Integer.parseInt(request.getParameter("prix")));
		Date debut = null;
		Date fin = null;
		try {
			debut = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("debut"));
			fin = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fin"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		a.setDateDebut(debut);
		a.setDateFin(fin);
		r.setRueRetrait(request.getParameter("rue"));
		r.setCodePostalRetrait(Integer.parseInt(request.getParameter("codepostal")));
		r.setVilleRetrait(request.getParameter("ville"));
		a.setRetrait(r);
		System.out.println("-------------------------------------servlet");
		System.out.println(a);
		e.ajouterArticle(a,(String) session.getAttribute("pseudo") ,request.getParameter("categorie"));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);

	}

}
