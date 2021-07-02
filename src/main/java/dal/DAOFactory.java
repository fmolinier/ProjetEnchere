package dal;

public class DAOFactory {
	
	public static GestionUtilisateur getUtilisateurDAO()
	{
		return new GestionUtilisateurJdbcImpl();
	}

	public static GestionEnchereDAO getGestionEnchereDAO() 
	{
		return new GestionEnchereDAOJdbcImpl();
	}
	
	public static ListeEnchere getListeEncherDAO() 
	{
		return new ListeEnchereJdbcImpl();
	}
	
	public static FaireEnchereDAO getFaireEnchereDAO()
	{
		return new FaireEnchereDAOJdbcImpl();
	}
}