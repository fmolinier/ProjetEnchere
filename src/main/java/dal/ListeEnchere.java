package dal;

import java.sql.SQLException;
import java.util.List;
import bo.Article;
import bo.Categorie;
import bo.Utilisateur;

public interface ListeEnchere {
	public List<Article> listeArticleVendu(String etatVente) throws SQLException;
	public List<Article> listeEnchereRemporter(String etatVente,String pseudoAcheteur) throws SQLException;
	public List<Article> listeArticleCategorie(String etatVente, String categorie) throws SQLException;
	public List<Article> listeMesVente(String etatVente, String vendeur, String recherche) throws SQLException;
	public List<Article> listeMesEnchereEnCours (String pseudo)throws SQLException;
	public List<Article> listeNomArticle(String etatVente, String nom)throws SQLException;
	public Article article(int noArticle, String etatVente) throws SQLException;
	public Utilisateur pseudoUtilisateur(int noUtilisateur) throws SQLException;
	public Categorie libelleCategorie(int noCategorie) throws SQLException;
	public Categorie NoCategorie(String libelleCategorie) throws SQLException;
	public Utilisateur noUtilisateur(String pseudo) throws SQLException;
	public List<Article> listeNomEtCategorieArticle(String etatVente,String categorie, String nom) throws SQLException;
	public List<Article> listeMesVenteCategorie(String etatVente, String vendeur, String recherche,String categorie) throws SQLException;

}
