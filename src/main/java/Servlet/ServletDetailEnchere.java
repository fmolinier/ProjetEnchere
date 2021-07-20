package Servlet;

import java.io.IOException;

import bll.GestionEnchereBLL;
import bo.Article;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDetailEnchere
 */
@WebServlet("/Detail")
public class ServletDetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletDetailEnchere() {
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
		GestionEnchereBLL e = new GestionEnchereBLL();
		Article a = new Article();
		a = e.detailArticle(Integer.parseInt(request.getParameter("numero")));
		request.setAttribute("nomArticle",a.getNomArticle());
		request.setAttribute("description", a.getDescription());
		request.setAttribute("categorie", a.getCategorie().getLibelle());
		request.setAttribute("enchere", a.getEnchere().getMontantEnchere());
		request.setAttribute("pseudoenchere", a.getEnchere().getEnchereur().getPseudo());
		request.setAttribute("prix", a.getMiseAPrix());
		request.setAttribute("fin", a.getDateFin());
		request.setAttribute("retrait", a.getRetrait());
		request.setAttribute("vendeur", a.getVendeur().getPseudo());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/DetailEnchere.jsp");//TODO a tester
		rd.forward(request, response);
	}

}
