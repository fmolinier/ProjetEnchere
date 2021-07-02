package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bo.Enchere;
import bo.Utilisateur;
import connectionBDD.JdbcTools;

public class FaireEnchereDAOJdbcImpl implements FaireEnchereDAO {
	private static final String INSERT_FaireEnchere = "INSERT INTO ENCHERE (date_enchere,montant_enchere,no_utilisateur,no_article) VALUES (?,?,?,?)";
	private static final String SELECT_NoUtilisateur = "SELECT no_utilisateur FROM UTILISATEUR WHERE pseudo = ?";

	@Override
	public void faireEnchere(Enchere enchere,int noArticle) throws SQLException {
		// connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		// Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(INSERT_FaireEnchere);

		// Valorisation des paramètres de la requete
		pstmt.setDate(1, (Date) enchere.getDateEnchere());
		pstmt.setInt(2, enchere.getMontantEnchere());
		pstmt.setInt(3, enchere.getEnchereur().getNoUtilisateur());
		pstmt.setInt(4, noArticle);
		pstmt.executeUpdate();

		// Fermeture de la connexion
		uneConnection.close();

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
