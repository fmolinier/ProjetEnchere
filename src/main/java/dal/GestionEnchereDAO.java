package dal;

import java.sql.SQLException;
import bo.Article;
import bo.Retrait;

public interface GestionEnchereDAO {
	public int insertArticle(Article article, String pseudo, String libelle) throws SQLException;
	public Article Detail(int noArticle) throws SQLException;
	public void insertRetrait(Retrait retrait) throws SQLException;
	public Article modifierArticles (Article article) throws SQLException;
	public void anulerArticles (int noArticle) throws SQLException;

}
