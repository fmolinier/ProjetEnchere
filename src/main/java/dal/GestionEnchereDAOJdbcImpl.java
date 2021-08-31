package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

import bo.Article;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class GestionEnchereDAOJdbcImpl implements GestionEnchereDAO {

	private static final String sqlInsertArticle = " INSERT INTO ARTICLE_VENDU (nom_Article,description,mise_a_prix,date_debut_encheres,date_fin_encheres,etat_vente,no_vendeur,no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private static final String sqlInsertRetrait = " INSERT INTO RETRAIT (no_article,rue,code_postal,ville) VALUES (?,?,?,?)";
	private static final String sqlSelectNoCategorie = "SELECT no_categorie" + " FROM CATEGORIE WHERE libelle = ?";
	private static final String sqlSelectNoUtilisateur = "select no_utilisateur from utilisateur where pseudo = ?";
	private static final String SELECT_article = "SELECT * FROM ARTICLE_VENDU WHERE no_article = ?";
	private static final String SELECT_libelleCategorie = "SELECT no_categorie,libelle FROM Categorie WHERE no_categorie = ?";
	private static final String SELECT_PseudoUtilisateur = "SELECT no_utilisateur,pseudo FROM UTILISATEUR WHERE no_utilisateur = ?";
	private static final String DELETE_Enchere = "DELETE FROM ARTICLE_VENDU WHERE no_Article = ?";
	private static final String UPDATE_Enchere = "UPDATE ARTICLE_VENDU SET nom_article = ?, description = ?,date_debut_encheres = ?,date_fin_encheres = ?,mise_a_prix = ?,no_categorie = ? WHERE no_Article = ?";
	private static final String Montant_Max_Enchere = "SELECT montant_enchere,no_utilisateur FROM ENCHERE where no_article = ? ORDER BY montant_enchere DESC";
	private static final String SELECT_lieuxRetrait = "SELECT * FROM RETRAIT WHERE no_article = ?";

	
	//TODO enchere remporter
	@Override
	public Article Detail(int noArticles) throws SQLException {
		ResultSet rs = null;
		Article a = new Article();
		Categorie c = new Categorie();
		Utilisateur u = new Utilisateur();
		Enchere e = new Enchere();
		Retrait r = new Retrait();
		// connection à la BDD
		Connection uneConnectionUtilisateur = JdbcTools.getConnection();

		// Requête à la BDD
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_article);
		pstmt.setInt(1, noArticles);

		rs = pstmt.executeQuery();
		rs.next();
		a.setNoArticle(rs.getInt("no_article"));
		a.setNomArticle(rs.getString("nom_article"));
		a.setDescription(rs.getString("description"));
		a.setMiseAPrix(rs.getInt("mise_a_prix"));
		a.setDateFin(rs.getDate("date_fin_encheres"));
		c = libelleCategorie(rs.getInt("no_categorie"));
		a.setCategorie(c);
		u = pseudoUtilisateur(rs.getInt("no_vendeur"));
		a.setVendeur(u);
		a.setEtatVente(rs.getString("etat_vente"));
		e = meillereEnchere(rs.getInt("no_article"));
		a.setEnchere(e);
		r = lieuxRetrait(rs.getInt("no_article"));
		a.setRetrait(r);
		
		// Fermeture de la connexion
		uneConnectionUtilisateur.close();
		
		return a;
	}
	
	//lieux du retrait de l'enchere
	private Retrait lieuxRetrait(int numeroArticle) throws SQLException {
		ResultSet rs = null;
		Retrait r = new Retrait();

		// connection à la BDD
		Connection uneConnectionUtilisateur = JdbcTools.getConnection();

		// Requête à la BDD
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(SELECT_lieuxRetrait);
		pstmt.setInt(1, numeroArticle);
		
		rs = pstmt.executeQuery();
		rs.next();
		r.setRueRetrait(rs.getString("rue"));
		r.setCodePostalRetrait(rs.getInt("code_postal"));
		r.setRueRetrait(rs.getString("ville"));

		return r;
	}
	
	//meillere enchere
	private Enchere meillereEnchere(int numeroArticle) throws SQLException {
		ResultSet rs = null;
		Enchere e = new Enchere();
		Utilisateur u = new Utilisateur();

		// connection à la BDD
		Connection uneConnectionUtilisateur = JdbcTools.getConnection();

		// Requête à la BDD
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(Montant_Max_Enchere);
		pstmt.setInt(1, numeroArticle);
		
		rs = pstmt.executeQuery();
		if (rs.next() == true) {
			e.setMontantEnchere( rs.getInt("montant_enchere"));
			u = pseudoUtilisateur(rs.getInt("no_utilisateur"));
			e.setEnchereur(u);
		} else {
			e.setMontantEnchere(0);
		}
		

		return e;
	}

	// recherche une categorie avec son numero categorie
	private Categorie libelleCategorie(int noCategorie) throws SQLException {

		ResultSet rs = null;
		Categorie c = new Categorie();

		// connection à la BDD
		Connection uneConnectionCategorie = JdbcTools.getConnection();

		// Requête à la BDD
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

	// recherche un utilisateur avec son numero utilisateur
	private Utilisateur pseudoUtilisateur(int noUtilisateur) throws SQLException {
		ResultSet rs = null;
		Utilisateur u = new Utilisateur();
		// connection à la BDD
		Connection uneConnectionUtilisateur = JdbcTools.getConnection();

		// Requête à la BDD
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

	//nouvelle enchere / article
	@Override
	public int insertArticle(Article article, String pseudo, String libelle) throws SQLException {		
		// Connection à la BDD
		ResultSet rs;
		Connection uneConnection = JdbcTools.getConnection();

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlInsertArticle,
				PreparedStatement.RETURN_GENERATED_KEYS);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, article.getNomArticle());
		pstmt.setString(2, article.getDescription());
		pstmt.setInt(3, article.getMiseAPrix());
		
		//converti java date en sql date
		long timeInMilliSeconds = article.getDateDebut().getTime();
        java.sql.Date datedebut = new java.sql.Date(timeInMilliSeconds);
		pstmt.setDate(4,datedebut);
		timeInMilliSeconds = article.getDateFin().getTime();
        java.sql.Date datefin = new java.sql.Date(timeInMilliSeconds);
		pstmt.setDate(5,datefin);
		
		pstmt.setString(6, article.getEtatVente());
		pstmt.setInt(7, noUtilisateur(pseudo));
		pstmt.setInt(8, noCategorie(libelle));
		pstmt.executeUpdate();
		rs = pstmt.getGeneratedKeys();
		rs.next();
		int noArticle = rs.getInt(1);

		// Fermeture de la connexion
		uneConnection.close();

		return noArticle;
	}
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}


	private int noUtilisateur(String pseudo) throws SQLException {
		ResultSet rs = null;
		int num = 0;
		// connection à la BDD
		Connection uneConnectionUtilisateur = JdbcTools.getConnection();

		// Requête à la BDD
		PreparedStatement pstmt = uneConnectionUtilisateur.prepareStatement(sqlSelectNoUtilisateur);
		pstmt.setString(1, pseudo);
		rs = pstmt.executeQuery();
		rs.next();
		num = rs.getInt("no_utilisateur");

		// Fermeture de la connexion
		uneConnectionUtilisateur.close();

		return num;
	}

	private int noCategorie(String libelle) throws SQLException {
		ResultSet rs = null;
		int num = 0;
		// Connection à la BDD
		Connection uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlSelectNoCategorie);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, libelle);

		rs = pstmt.executeQuery();
		rs.next();
		num = rs.getInt("no_categorie");
		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

		return num;
	}

	@Override
	public void insertRetrait(Retrait retrait) throws SQLException {
		// Connection à la BDD
		Connection uneConnection = JdbcTools.getConnection();
		System.out.println("Connection");

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(sqlInsertRetrait);

		// Valorisation des paramètres de la requete
		pstmt.setInt(1, retrait.getNoArticle());
		pstmt.setString(2, retrait.getRueRetrait());
		pstmt.setInt(3, retrait.getCodePostalRetrait());
		pstmt.setString(4, retrait.getVilleRetrait());
		pstmt.executeUpdate();
		System.out.println("Requête");

		// Fermeture de la connexion
		uneConnection.close();
		System.out.println("Fermeture");

	}

	@Override
	public Article modifierArticles(Article article) throws SQLException {
		// Connection à la BDD
		Connection uneConnection = JdbcTools.getConnection();

		// Requête à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(UPDATE_Enchere);

		// Valorisation des paramètres de la requete
		pstmt.setString(1, article.getNomArticle());
		pstmt.setString(2, article.getDescription());
		pstmt.setDate(3, (Date) article.getDateDebut());
		pstmt.setDate(4, (Date) article.getDateFin());
		pstmt.setInt(5, article.getMiseAPrix());
		pstmt.setInt(6, noCategorie(article.getCategorie().getLibelle()));
		pstmt.setInt(7, article.getNoArticle());
		pstmt.executeUpdate();

		return article;
	}

	// delete on cascade
	@Override
	public void anulerArticles(int noArticle) throws SQLException {
		// Connection à la BDD
		Connection uneConnection = JdbcTools.getConnection();
		PreparedStatement pstmt = uneConnection.prepareStatement(DELETE_Enchere);

		// Valorisation des paramètres de la requete
		pstmt.setInt(1, noArticle);
		pstmt.executeUpdate();
	}

}
