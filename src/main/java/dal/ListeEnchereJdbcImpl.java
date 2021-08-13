package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bo.Article;
import bo.Categorie;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class ListeEnchereJdbcImpl implements ListeEnchere {

	private static final String SELECT_ListeEnchere = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ?";
	private static final String SELECT_listeMesEnchereEnCours = "SELECT * FROM ENCHERE  WHERE no_utilisateur = ?";
	private static final String SELECT_ListeEnchereParNom = "SELECT * FROM ARTICLE_VENDU where etat_vente = ? AND nom_article like ?";
	private static final String SELECT_listeNomEtCategorie = "SELECT * FROM ARTICLE_VENDU where etat_vente = ? AND no_categorie = ? AND nom_article like ?";
	private static final String SELECT_ListeEnchereCategorie = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ? AND no_categorie = ?";
	private static final String SELECT_ListeMesVentes = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ? AND no_vendeur = ? AND nom_article like ?";
	private static final String SELECT_ListeMesVentesCategorie = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ? AND no_vendeur = ? AND no_categorie = ? AND nom_article like ?";
	private static final String SELECT_libelleCategorie = "SELECT no_categorie,libelle FROM Categorie WHERE no_categorie = ?";
	private static final String SELECT_ListeEnchereRemporter = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ? and no_acheteur = ? AND nom_article like ?";
	private static final String SELECT_ListeEnchereRemporterategorie = "SELECT * FROM ARTICLE_VENDU Where etat_vente = ? and no_acheteur = ? AND no_categorie = ? AND nom_article like ?";
	private static final String SELECT_listeArticle = "SELECT * FROM ARTICLE_VENDU Where no_article = ? and etat_vente = ? AND nom_article like ?";
	private static final String SELECT_listeArticleCategorie = "SELECT * FROM ARTICLE_VENDU Where no_article = ? and etat_vente = ? AND no_categorie = ? AND nom_article like ?";
	private static final String SELECT_PseudoUtilisateur = "SELECT no_utilisateur,pseudo FROM UTILISATEUR WHERE no_utilisateur = ?";
	private static final String SELECT_NoCategorie = "SELECT no_categorie,libelle FROM Categorie WHERE libelle = ?";
	private static final String SELECT_NoUtilisateur = "SELECT no_utilisateur FROM UTILISATEUR WHERE pseudo = ?";

	// liste des enchere en cour
	@Override
	public List<Article> listeArticleVendu(String etatVente) throws SQLException {

		List<Article> liste = new ArrayList<Article>();

		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeEnchere);
		pstmt.setString(1, etatVente);
		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();

		return liste;

	}

	// liste des enchere par catégorie
	@Override
	public List<Article> listeArticleCategorie(String etatVente, String categorie) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Categorie nc = new Categorie();

		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeEnchereCategorie);
		pstmt.setString(1, etatVente);
		nc = NoCategorie(categorie);
		// recuperation du numero de la categorie
		pstmt.setInt(2, nc.getNoCategorie());
		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			Categorie c = new Categorie();
			Article a = new Article();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();
		return liste;

	}

	// liste des enchere rechercher via le nom
	@Override
	public List<Article> listeNomArticle(String etatVente, String nom) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		String str = "%";
		String name = str + nom + str;
		
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeEnchereParNom);
		pstmt.setString(1, etatVente);
		pstmt.setString(2, name);
		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			Categorie c = new Categorie();
			Article a = new Article();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();
		return liste;

	}

	// liste via le nom de l'enchre et par categorie
	@Override
	public List<Article> listeNomEtCategorieArticle(String etatVente, String nom, String categorie) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Categorie nc = new Categorie();
		nc = NoCategorie(categorie);
		String str = "%";
		String name = str + nom + str;
		
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_listeNomEtCategorie);
		pstmt.setString(1, etatVente);
		pstmt.setInt(2, nc.getNoCategorie());
		pstmt.setString(3, name);
		
		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			Categorie c = new Categorie();
			Article a = new Article();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();
		
		return liste;
	}

	// liste mes ventes
	@Override
	public List<Article> listeMesVente(String etatVente, String vendeur, String recherche) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Utilisateur nu = new Utilisateur();
		nu = noUtilisateur(vendeur);
		String str = "%";
		String name = str + recherche + str;
		
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeMesVentes);
		pstmt.setString(1, etatVente);
		pstmt.setInt(2, nu.getNoUtilisateur());
		pstmt.setString(3, name);

		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			Categorie c = new Categorie();
			Article a = new Article();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();
		return liste;

	}

	@Override
	public List<Article> listeMesVenteCategorie(String etatVente, String vendeur, String recherche, String categorie)
			throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Utilisateur nu = new Utilisateur();
		nu = noUtilisateur(vendeur);
		Categorie nc = new Categorie();
		nc = NoCategorie(categorie);
		String str = "%";
		String name = str + recherche + str;
		
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeMesVentesCategorie);
		pstmt.setString(1, etatVente);
		pstmt.setInt(2, nu.getNoUtilisateur());
		pstmt.setInt(3, nc.getNoCategorie());
		pstmt.setString(4, name);

		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			Categorie c = new Categorie();
			Article a = new Article();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();
		return liste;

	}

	// liste des enchere remporter par l'utilisateur
	@Override
	public List<Article> listeEnchereRemporter(String etatVente, String pseudo, String recherche) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		String str = "%";
		String name = str + recherche + str;
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeEnchereRemporter);
		pstmt.setString(1, etatVente);
		pstmt.setInt(2, noUtilisateur(pseudo).getNoUtilisateur());
		pstmt.setString(3, name);

		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			u = pseudoUtilisateur(rs.getInt("no_acheteur"));
			a.setAcheteur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}
		
		// Fermeture de la connexion
		uneConnection.close();
		return liste;

	}

	@Override
	public List<Article> listeEnchereRemporterCategorie(String etatVente, String pseudo, String recherche, String categorie) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Categorie nc = new Categorie();
		nc = NoCategorie(categorie);
		String str = "%";
		String name = str + recherche + str;

		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ListeEnchereRemporterategorie);
		pstmt.setString(1, etatVente);
		pstmt.setInt(2, noUtilisateur(pseudo).getNoUtilisateur());
		pstmt.setInt(3, nc.getNoCategorie());
		pstmt.setString(4, name);

		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Article a = new Article();
			Categorie c = new Categorie();
			Utilisateur u = new Utilisateur();

			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			u = pseudoUtilisateur(rs.getInt("no_acheteur"));
			a.setAcheteur(u);
			a.setEtatVente(rs.getString("etat_vente"));
			liste.add(a);
		}
		// Fermeture de la connexion
		uneConnection.close();
		return liste;

	}

	// liste des enchere en cour d'un utilisateur
	@Override 
	public List<Article> listeMesEnchereEnCours(String pseudoAcheteur, String recherche) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Article a = new Article();
		String str = "%";
		String name = str + recherche + str;

		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_listeMesEnchereEnCours);
		pstmt.setInt(1, noUtilisateur(pseudoAcheteur).getNoUtilisateur());

		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			
				a = article(rs.getInt("no_article"), "en cours", name);
				if (a.getMiseAPrix() != 0) {
					liste.add(a);
				}
		}

		// Fermeture de la connexion
		uneConnection.close();

		return liste;

	}

	// recherche un article avec son numero article
	@Override
	public Article article(int noArticle, String etatVente, String recherche) throws SQLException {

		ResultSet rs = null;
		Article a = new Article();
		Categorie c = new Categorie();
		Utilisateur u = new Utilisateur();
		
		// connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_listeArticle);
		pstmt.setInt(1, noArticle);
		pstmt.setString(2, etatVente);
		pstmt.setString(3, recherche);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setMiseAPrix(rs.getInt("mise_a_prix"));
			a.setDateFin(rs.getDate("date_fin_encheres"));
			a.setDateDebut(rs.getDate("date_debut_encheres"));
			c = libelleCategorie(rs.getInt("no_categorie"));
			a.setCategorie(c);
			u = pseudoUtilisateur(rs.getInt("no_vendeur"));
			a.setVendeur(u);
			a.setEtatVente(rs.getString("etat_vente"));
		}
		// Fermeture de la connexion
		uneConnectionUtilisateur.close();

		return a;
	}
	
	@Override
	public List<Article> listeMesEnchereEnCoursCategorie(String pseudoAcheteur, String recherche,String categorie) throws SQLException {

		List<Article> liste = new ArrayList<Article>();
		Article a = new Article();
		String str = "%";
		String name = str + recherche + str;
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_listeMesEnchereEnCours);
		pstmt.setInt(1, noUtilisateur(pseudoAcheteur).getNoUtilisateur());

		// Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			a = articleCategorie(rs.getInt("no_article"), "en cours", name,categorie);
			liste.add(a);
		}

		// Fermeture de la connexion
		uneConnection.close();

		return liste;

	}
	// recherche un article avec son numero article avec une categorie
	@Override
	public Article articleCategorie(int noArticle, String etatVente, String recherche, String categorie) throws SQLException {

		ResultSet rs = null;
		Article a = new Article();
		Categorie c = new Categorie();
		Utilisateur u = new Utilisateur();
		String str = "%";
		String name = str + recherche + str;

		// connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_listeArticleCategorie);
		pstmt.setInt(1, noArticle);
		pstmt.setString(2, etatVente);
		pstmt.setString(3, categorie);
		pstmt.setString(4, name);
		
		rs = pstmt.executeQuery();
		rs.next();
		a.setNoArticle(rs.getInt("no_article"));
		a.setNomArticle(rs.getString("nom_article"));
		a.setMiseAPrix(rs.getInt("mise_a_prix"));
		a.setDateFin(rs.getDate("date_fin_encheres"));
		a.setDateDebut(rs.getDate("date_debut_encheres"));
		c = libelleCategorie(rs.getInt("no_categorie"));
		a.setCategorie(c);
		u = pseudoUtilisateur(rs.getInt("no_vendeur"));
		a.setVendeur(u);
		a.setEtatVente(rs.getString("etat_vente"));
		// Fermeture de la connexion
		uneConnectionUtilisateur.close();

		return a;
	}

	// recherche un utilisateur avec son numero utilisateur
	@Override
	public Utilisateur pseudoUtilisateur(int noUtilisateur) throws SQLException {
		ResultSet rs = null;
		Utilisateur u = new Utilisateur();
		// connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_PseudoUtilisateur);
		pstmt.setInt(1, noUtilisateur);
		rs = pstmt.executeQuery();
		rs.next();
		u.setNoUtilisateur(rs.getInt("no_utilisateur"));
		u.setPseudo(rs.getString("pseudo"));
		// Fermeture de la connexion
		uneConnectionUtilisateur.close();

		return u;
	}

	// recherche une categorie avec son numero categorie
	@Override
	public Categorie libelleCategorie(int noCategorie) throws SQLException {
		ResultSet rs = null;
		Categorie c = new Categorie();

		// connection à la BDD
		Connection uneConnectionCategorie = null;
		uneConnectionCategorie = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionCategorie.prepareStatement(SELECT_libelleCategorie);
		pstmt.setInt(1, noCategorie);
		rs = pstmt.executeQuery();
		rs.next();
		c.setNoCategorie(rs.getInt("no_categorie"));
		c.setLibelle(rs.getString("libelle"));

		// Fermeture de la connexion
		uneConnectionCategorie.close();

		return c;
	}

	// recherche un numero categorie avec son libelle
	@Override
	public Categorie NoCategorie(String libelleCategorie) throws SQLException {
		
		ResultSet rs = null;
		Categorie c = new Categorie();

		// connection à la BDD
		Connection uneConnectionCategorie = null;
		uneConnectionCategorie = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionCategorie.prepareStatement(SELECT_NoCategorie);
		pstmt.setString(1, libelleCategorie);
		rs = pstmt.executeQuery();
		rs.next();
		c.setNoCategorie(rs.getInt("no_categorie"));
		c.setLibelle(rs.getString("libelle"));

		// Fermeture de la connexion
		uneConnectionCategorie.close();

		return c;
	}

	// recherche un numero utilisateur avec son pseudo
	@Override
	public Utilisateur noUtilisateur(String pseudo) throws SQLException {
		ResultSet rs = null;
		Utilisateur u = new Utilisateur();

		// connection à la BDD
		Connection uneConnectionUtilisateur = null;
		uneConnectionUtilisateur = JdbcTools.getConnection();

		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_NoUtilisateur);
		pstmt.setString(1, pseudo);
		rs = pstmt.executeQuery();
		rs.next();
		u.setNoUtilisateur(rs.getInt("no_utilisateur"));

		// Fermeture de la connexion
		uneConnectionUtilisateur.close();

		return u;
	}
}
