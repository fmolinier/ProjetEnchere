package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.Article;
import bo.Enchere;
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
			listeNomArticle = listeEnchere.listeNomArticle("en cours",nomArticle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeNomArticle;
	}

	// liste mes vente en cours
	public List<Article> listeMesVenteEnCours(String vendeur) {
		List<Article> listeMesVente = new ArrayList<Article>();

		try {
			listeMesVente = listeEnchere.listeMesVente("en cours",vendeur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVente;
	}

	// liste mes vente terminer
	public List<Article> listeMesVenteTerminer(String vendeur) {
		List<Article> listeMesVenteTerminer = new ArrayList<Article>();

		try {
			listeMesVenteTerminer = listeEnchere.listeMesVente("terminer",vendeur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVenteTerminer;
	}

	// liste mes vente non debutée
	public List<Article> listeMesVenteNonDebute(String vendeur) {
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();
		try {
			listeMesVenteNonDebute = listeEnchere.listeMesVente("non debuté",vendeur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVenteNonDebute;
	}

	// liste mes enchere en cours
	public List<Article> listeMesEnchereEnCours(String pseudo) {
		List<Article> liste = new ArrayList<Article>();
		List<Enchere> Enchere = new ArrayList<Enchere>();
		List<Article> listeMesEnchereEnCours = new ArrayList<Article>();

		try {
			liste = listeEnchere.listeMesEnchereEnCours(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; Enchere.size() > i; i++) {
			for (int j = 0; liste.size() > j; j++) {
				if (Enchere.get(i).getArticleEncherie().getNoArticle() == liste.get(j).getNoArticle()) {
					listeMesEnchereEnCours.add(liste.get(i));
				}
			}
		}
		return listeMesEnchereEnCours;
	}

	// liste mes enchere remportée
	public List<Article> listeMesVenteRemporte(String acheteur) {
		List<Article> listeMesVenteNonDebute = new ArrayList<Article>();

		try {
			listeMesVenteNonDebute = listeEnchere.listeEnchereRemporter("terminer", acheteur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMesVenteNonDebute;
	}
}
