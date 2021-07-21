package dal;

import java.sql.SQLException;
import bo.Utilisateur;

public interface GestionUtilisateur {
	public Utilisateur connection(Utilisateur connection,String type,String motdepasse) throws SQLException;
	public void inscription(Utilisateur utilisateur) throws SQLException;
	public String verifPeusdo(String pseudo) throws SQLException;
	public String verifEmail(String email) throws SQLException;
	public Utilisateur VoirProfil(String pseudo) throws SQLException;
	public void ModificationProfil(Utilisateur modif,String ancienPseudo) throws SQLException;
	public void suprimerMonCompte(String pseudo) throws SQLException;
}
