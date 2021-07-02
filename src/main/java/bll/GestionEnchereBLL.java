package bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import bo.Article;
import bo.Retrait;
import dal.DAOFactory;
import dal.GestionEnchereDAO;

public class GestionEnchereBLL {
	private GestionEnchereDAO gestionEnchereDAO;

	public GestionEnchereBLL() {
		// Instancier le Data Access Object
		gestionEnchereDAO = DAOFactory.getGestionEnchereDAO();
	}

	/* Récuperation des détails de l'article */
	public Article detailArticle(int noArticle) {

		Article article = new Article();
		try {
			article = gestionEnchereDAO.Detail(noArticle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	// Ajout d'un nouvel article en vente
	public Article ajouterArticle(String nomArticle, String description, int miseAPrix, Date dateDebut, Date dateFin,
			String pseudo, String libelle, String rueRetrait, int codePostalRetrait, String villeRetrait) {

		Article article = null;
		LocalDate jour = LocalDate.now();
		LocalDate debut = convertToLocalDateViaInstant(dateDebut);
		LocalDate fin = convertToLocalDateViaInstant(dateFin);

		article = new Article();
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setMiseAPrix(miseAPrix);
		article.setDateDebut(dateDebut);
		article.setDateFin(dateFin);

		if (debut.isBefore(fin)) {
			if (debut.isAfter(jour)) {
				article.setEtatVente("non debuté");
			} else if (debut.isEqual(jour)) {
				article.setEtatVente("en cours");
			}
		}

		try {
			int noArticle = this.gestionEnchereDAO.insertArticle(article, pseudo, libelle);
			ajouterRetrait(rueRetrait, codePostalRetrait, villeRetrait, noArticle);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return article;
	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	// Ajout d'un nouveau lieu de retrait pour le nouvel article
	public Retrait ajouterRetrait(String rueRetrait, int codePostalRetrait, String villeRetrait, int noArticle) {

		Retrait retrait = null;

		retrait = new Retrait();
		retrait.setNoArticle(noArticle);
		retrait.setRueRetrait(rueRetrait);
		retrait.setCodePostalRetrait(codePostalRetrait);
		retrait.setVilleRetrait(villeRetrait);

		try {
			this.gestionEnchereDAO.insertRetrait(retrait);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retrait;
	}

	// modifier une enchere
	public Article modifierenchere(Article enchere) {
		LocalDate jour = LocalDate.now();
		LocalDate debut = convertToLocalDateViaInstant(enchere.getDateDebut());
		if (jour.isBefore(debut)) {
			try {
				this.gestionEnchereDAO.modifierArticles(enchere);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("l'enchere a deja comencée vous ne pouver pas la modifier");
		}
		return null;

	}

	// anuler une enchere
	public void anulerEnchere(Article enchere) {
		LocalDate jour = LocalDate.now();
		LocalDate debut = convertToLocalDateViaInstant(enchere.getDateDebut());
		if (jour.isBefore(debut)) {
			try {
				this.gestionEnchereDAO.anulerArticles(enchere.getNoArticle());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("l'enchere a deja comencée vous ne pouver pas l'annuler");
		}
	}
}