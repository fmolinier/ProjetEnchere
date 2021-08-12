package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.Article;
import dal.DAOFactory;
import dal.ListeEnchere;

/**
 * 
 * @author Florian
 *
 */
public class ListeEnchereBLL {
	private ListeEnchere listeEnchere;

	// Constructeurs
	public ListeEnchereBLL() {
		listeEnchere = DAOFactory.getListeEncherDAO();
	}

	// liste non connectée
	public List<Article> listeEnchere() {
		List<Article> liste = new ArrayList<Article>();
		try {
			liste = listeEnchere.listeArticleVendu("en cours");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	// liste par categorie
	public List<Article> listeCategorie(String categorie) {
		List<Article> listeCategorie = new ArrayList<Article>();

		try {
			if (categorie == "tous") {
				listeCategorie = listeEnchere.listeArticleVendu("en cours");
			} else {
				listeCategorie = listeEnchere.listeArticleCategorie("en cours", categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCategorie;
	}

	// liste par nom article
	public List<Article> listeNomArticle(String nomArticle) {
		List<Article> listeNomArticle = new ArrayList<Article>();

		try {
			listeNomArticle = listeEnchere.listeNomArticle("en cours", nomArticle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeNomArticle;
	}

	// liste par nom article et categorie
	public List<Article> listeNomEtCategorieArticle(String nomArticle, String categorie) {
		List<Article> listeNomArticle = new ArrayList<Article>();

		try {
			listeNomArticle = listeEnchere.listeNomEtCategorieArticle("en cours", nomArticle, categorie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeNomArticle;
	}

	// liste mes vente en cours
	public List<Article> listeMesVenteEnCours(String vendeur, String recherche, String categorie) {
		List<Article> listeMesVente = new ArrayList<Article>();
		try {
			if (categorie == "tous") {

				listeMesVente = listeEnchere.listeMesVente("en cours", vendeur, recherche);

			} else {

				listeMesVente = listeEnchere.listeMesVenteCategorie("en cours", vendeur, recherche, categorie);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVente;
	}
	
	// liste mes vente terminer
	public List<Article> listeMesVenteTerminer(String vendeur, String recherche, String categorie) {
		List<Article> listeMesVenteTerminer = new ArrayList<Article>();
		try {
			if (categorie == "tous") {

				listeMesVenteTerminer = listeEnchere.listeMesVente("terminer", vendeur, recherche);

			} else {

				listeMesVenteTerminer = listeEnchere.listeMesVenteCategorie("terminer", vendeur, recherche, categorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVenteTerminer;
	}

	// liste mes vente non debutée
	public List<Article> listeMesVenteNonDebute(String vendeur, String recherche, String categorie) {
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();
		try {
			if (categorie == "tous") {

				listeMesVenteNonDebute = listeEnchere.listeMesVente("non debuté", vendeur, recherche);

			} else {

				listeMesVenteNonDebute = listeEnchere.listeMesVenteCategorie("non debuté", vendeur, recherche, categorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVenteNonDebute;
	}

	// liste mes enchere en cours
	public List<Article> listeMesEnchereEnCours(String pseudo, String recherche, String categorie) {
		List<Article> listeMesEnchereEnCours = new ArrayList<Article>();
		try {
			if (categorie == "tous") {

				listeMesEnchereEnCours = listeEnchere.listeMesEnchereEnCours(pseudo, recherche);

			} else {

				listeMesEnchereEnCours = listeEnchere.listeMesEnchereEnCoursCategorie(pseudo, recherche, categorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMesEnchereEnCours;
	}

	// liste mes enchere remportée
	public List<Article> listeMesVenteRemporte(String acheteur, String recherche, String categorie) {
		List<Article> listeEnchereRemporter = new ArrayList<Article>();
		try {
			if (categorie == "tous") {

				listeEnchereRemporter = listeEnchere.listeEnchereRemporter("terminer", acheteur, recherche);

			} else {

				listeEnchereRemporter = listeEnchere.listeEnchereRemporterCategorie("terminer", acheteur, recherche, categorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeEnchereRemporter;
	}
}
