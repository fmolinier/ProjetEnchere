package bll;

import java.sql.SQLException;
import bo.Utilisateur;
import dal.GestionUtilisateur;
import dal.DAOFactory;

/**
 * @author Florian MOLINIER
 */
public class GestionUtilisateurBLL {

	private GestionUtilisateur gestionUtilisateur;

	// Constructeurs
	public GestionUtilisateurBLL() {
		gestionUtilisateur = DAOFactory.getUtilisateurDAO();
	}

	// Methode gerant la connection d'un utilisateur
	public Utilisateur Connection(String login, String motDePasse) {

		Utilisateur utilisateur = new Utilisateur();
		Utilisateur connection = new Utilisateur();
		connection.setMotDePasse(motDePasse);

		String type = null;
		
		if (login.contains("@")) {
			type = "email";
			connection.setEmail(login);
		} else if (!login.contains("@")) {
			connection.setPseudo(login);
			type = "pseudo";
		}

		// recuperation de l'utilisateur
		try {
			utilisateur = gestionUtilisateur.connection(connection, type, motDePasse);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	// Methode gerant l'inscription d'un utilisateur
	public void InscriptionUtilisateur(Utilisateur inscrit) {

		/*
		 * iscription dans la base de donne si le pseudo et l'email son different de ce
		 * deja inscrit
		 */
		try {
			gestionUtilisateur.inscription(inscrit);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Methode gerant l'affichage du profil d'un utilisateur
	public Utilisateur afficherProfil(String pseudo) {
		Utilisateur profil = new Utilisateur();

		try {
			profil = gestionUtilisateur.VoirProfil(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profil;
	}

	// Methode gerant la modification du profil d'un utilisateur
	public Utilisateur modificationProfil(Utilisateur profil, String pseudoActuel, String emailActuel) {

		Utilisateur modif = new Utilisateur();
		try {

			gestionUtilisateur.ModificationProfil(profil, pseudoActuel);
			modif = afficherProfil(profil.getPseudo());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modif;

	}

	// suprimer mon compte
	public void SuprimerProfil(String pseudo) {
		try {
			gestionUtilisateur.suprimerMonCompte(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// verif
	public boolean verifPseudo(String pseudo) {
		String bddPseudo = null;
		boolean verif = false;
		try {
			bddPseudo = gestionUtilisateur.verifPeusdo(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (bddPseudo != null) {
			verif = false;
		} else {
			verif = true;
		}
		return verif;
	}

	public boolean verifEmail(String email) {
		String bddEmail = null;
		boolean verif = false;
		try {
			bddEmail = gestionUtilisateur.verifEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (bddEmail != null) {
			verif = false;
		} else {
			verif = true;
		}
		return verif;
	}
}
