package bo;

import java.util.Date;

public class Article {


	private int noArticle, miseAPrix, prixVente;
	private String nomArticle, description, etatVente;
	private Date dateDebut, dateFin;
	private Categorie categorie;
	private Utilisateur acheteur, vendeur;
	private Retrait retrait;
	private Enchere enchere;

	// Constructeur
	public Article(int noArticle, String nomArticle, String description, Date dateDebut, Date dateFin, int miseAPrix,
			int prixVente, String etatVente, Categorie categorie, Utilisateur acheteur, Utilisateur vendeur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.acheteur = acheteur;
		this.vendeur = vendeur;

	}

	public Article(String nomArticle, String description, String etatVente, Date dateDebut, Date dateFin,
			int miseAPrix) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.etatVente = etatVente;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.miseAPrix = miseAPrix;

	}

	public Article() {

	}

	// Getters et Setters
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}
	
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente
				+ ", nomArticle=" + nomArticle + ", description=" + description + ", etatVente=" + etatVente
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", categorie=" + categorie + ", acheteur="
				+ acheteur + ", vendeur=" + vendeur + "]";
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

}
