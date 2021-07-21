package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bo.Utilisateur;
import connectionBDD.JdbcTools;


public class GestionUtilisateurJdbcImpl implements GestionUtilisateur{
   
	private static final String SELECT_ConnectionPseudo = "SELECT no_utilisateur,pseudo,mot_de_passe,email FROM UTILISATEUR WHERE pseudo = ? and mot_de_passe = ? ";
	private static final String SELECT_ConnectionEmail = "SELECT no_utilisateur,email,mot_de_passe,pseudo FROM UTILISATEUR WHERE email = ? and mot_de_passe = ?";
	private static final String SELECT_VerifPseudo=" SELECT pseudo FROM UTILISATEUR WHERE pseudo = ?";
	private static final String SELECT_VerifEmail=" SELECT email FROM UTILISATEUR WHERE email = ?";
    private static final String INSERT_Instricption=" INSERT INTO UTILISATEUR (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_VoirProfil = "SELECT pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit FROM UTILISATEUR WHERE pseudo = ?";
	private static final String UPDATE_ModifProfil = "UPDATE UTILISATEUR SET pseudo = ?,nom = ?,prenom = ?,email = ?,telephone = ?,rue = ?,code_postal = ?,ville = ?,mot_de_passe = ? WHERE pseudo = ?";
	private static final String DELETE_Pseudo=" DELETE FROM UTILISATEUR WHERE pseudo = ?";

	//recuperation des informations de l'utilisateur
	@Override
	public Utilisateur VoirProfil(String pseudo) throws SQLException {
		
		Connection uneConnection = null;
		ResultSet rs = null;
		Utilisateur Profil = new Utilisateur();
		
		//connection à la BDD
		uneConnection = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_VoirProfil);
		pstmt.setString(1,pseudo);
		rs = pstmt.executeQuery();
		
		//Recuperation des données recupérer
		rs.next();
		Profil.setPseudo(rs.getString("pseudo"));
		Profil.setPrenom(rs.getString("prenom"));
		Profil.setNom(rs.getString("nom"));
		Profil.setEmail(rs.getString("email"));
		Profil.setTelephone(rs.getString("telephone"));
		Profil.setRue(rs.getString("rue"));
		Profil.setCodePostal(rs.getInt("code_postal"));
		Profil.setVille(rs.getString("ville"));
		Profil.setMotDePasse(rs.getString("mot_de_passe"));
		Profil.setCredit(rs.getInt("credit"));
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return Profil;
	}
	
	//Mise a jour de l'utilisateur dans la BDD
	@Override
	public void ModificationProfil(Utilisateur modif,String pseudoActuel) throws SQLException {
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		
		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(UPDATE_ModifProfil);
		
		//Valorisation des paramètres de la requete
		pstmt.setString(1,modif.getPseudo() );
		pstmt.setString(2, modif.getNom());
		pstmt.setString(3, modif.getPrenom());
		pstmt.setString(4, modif.getEmail());
		pstmt.setString(5, modif.getTelephone());
		pstmt.setString(6, modif.getRue());
		pstmt.setInt(7, modif.getCodePostal());
		pstmt.setString(8, modif.getVille());
		pstmt.setString(9, modif.getMotDePasse());
		pstmt.setString(10,pseudoActuel);

		pstmt.executeUpdate();

		//Fermeture de la connexion
		uneConnection.close();

	}
	//TODO A ameliorer
	@Override
	public Utilisateur connection(Utilisateur connection,String type,String motdepasse) throws SQLException {
		Connection uneConnection = null;
		ResultSet rs = null;
		Utilisateur Utilisateur = new Utilisateur();
		
		//connection à la BDD
		uneConnection = JdbcTools.getConnection();
		//Requette à la BDD
		if (type == "pseudo") {
			
			PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ConnectionPseudo);
			pstmt.setString(1,connection.getPseudo());
			pstmt.setString(2,motdepasse);
			rs = pstmt.executeQuery();
			
			//Recuperation des données recupérer
			rs.next();
			Utilisateur.setNoUtilisateur(Integer.parseInt("no_utilisateur"));
			Utilisateur.setPseudo(rs.getString("pseudo"));
			Utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			
		}else if(type == "email") {
			
			PreparedStatement pstmt = uneConnection.prepareStatement(SELECT_ConnectionEmail);
			pstmt.setString(1,connection.getEmail());
			pstmt.setString(2,motdepasse);
			rs = pstmt.executeQuery();
			
			//Recuperation des données recupérer
			rs.next();
			Utilisateur.setNoUtilisateur(Integer.parseInt("no_utilisateur"));
			Utilisateur.setEmail(rs.getString("email"));
			Utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		}
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return Utilisateur;		
	}
	
	//verif existant
	//verif pseudo
	@Override
	public String verifPeusdo(String pseudo) throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		

		
		//Requette à la BDD
		PreparedStatement pstmt =  uneConnection.prepareStatement(SELECT_VerifPseudo);
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		String verif;
		verif = rs.getString("pseudo");
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return verif;		
	}
	
	//verif email
	@Override
	public String verifEmail(String email) throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();
		

		
		//Requette à la BDD
		PreparedStatement pstmt =  uneConnection.prepareStatement(SELECT_VerifEmail);
		
		//Recuperation des données recupérer
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		String verif;
		verif = rs.getString("email");
		
		//Fermeture de la connexion
		uneConnection.close();
		
		return verif;		
	}
	
	@Override
	public void inscription(Utilisateur inscrit) throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(INSERT_Instricption);
		
		//Valorisation des paramètres de la requete
		pstmt.setString(1,inscrit.getPseudo() );
		pstmt.setString(2, inscrit.getNom());
		pstmt.setString(3, inscrit.getPrenom());
		pstmt.setString(4, inscrit.getEmail());
		pstmt.setString(5, inscrit.getTelephone());
		pstmt.setString(6, inscrit.getRue());
		pstmt.setInt(7, inscrit.getCodePostal());
		pstmt.setString(8, inscrit.getVille());
		pstmt.setString(9, inscrit.getMotDePasse());
		pstmt.setInt(10, 0);
		pstmt.executeUpdate();

		//Fermeture de la connexion
		uneConnection.close();


	}
	
	@Override
	public void suprimerMonCompte(String pseudo) throws SQLException {
		
		//connection à la BDD
		Connection uneConnection = null;
		uneConnection = JdbcTools.getConnection();

		//Requette à la BDD
		PreparedStatement pstmt = uneConnection.prepareStatement(DELETE_Pseudo);
		
		//Valorisation des paramètres de la requete
		pstmt.setString(1,pseudo);
		pstmt.executeUpdate();

		//Fermeture de la connexion
		uneConnection.close();


	}

}
