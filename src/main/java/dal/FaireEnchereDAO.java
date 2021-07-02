package dal;

import java.sql.SQLException;

import bo.Enchere;
import bo.Utilisateur;

public interface FaireEnchereDAO {
	public void faireEnchere(Enchere enchere, int noArticle) throws SQLException;
	public Utilisateur noUtilisateur(String pseudo) throws SQLException;
}
