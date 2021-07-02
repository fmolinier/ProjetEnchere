package bll;

import java.sql.SQLException;
import java.util.Date;
import bo.Enchere;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.FaireEnchereDAO;

public class FaireEnchereBLL {

	private FaireEnchereDAO faireEnchereDAO;

	public FaireEnchereBLL() {
		// Instancier le Data Access Object
		faireEnchereDAO = DAOFactory.getFaireEnchereDAO();
	}

	public void Encherir(int noArticle, int montant, String pseudo) {
		
		Date jour = new Date();
		Enchere e = new Enchere();
		Utilisateur u = new Utilisateur();
		
		try {
			
			e.setDateEnchere(jour);
			e.setMontantEnchere(montant);
			u = faireEnchereDAO.noUtilisateur(pseudo);
			e.setEnchereur(u);
			faireEnchereDAO.faireEnchere(e,noArticle);
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}
