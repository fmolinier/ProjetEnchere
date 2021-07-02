package bo;

public class Retrait {
	private String rueRetrait,villeRetrait;
	private int codePostalRetrait,noArticle;
	
	//Constructeur
	public Retrait(String rueRetrait, int codePostalRetrait, String villeRetrait) {
		this.rueRetrait = rueRetrait;
		this.codePostalRetrait = codePostalRetrait;
		this.villeRetrait = villeRetrait;
	}
	
	public Retrait() {

	}
	
	//Getters et Setters
	public String getRueRetrait() {
		return rueRetrait;
	}
	
	public void setRueRetrait(String rueRetrait) {
		this.rueRetrait = rueRetrait;
	}
	
	public String getVilleRetrait() {
		return villeRetrait;
	}
	
	public void setVilleRetrait(String villeRetrait) {
		this.villeRetrait = villeRetrait;
	}
	
	public int getCodePostalRetrait() {
		return codePostalRetrait;
	}
	
	public void setCodePostalRetrait(int codePostalRetrait) {
		this.codePostalRetrait = codePostalRetrait;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Retrait [rueRetrait=" + rueRetrait + ", villeRetrait=" + villeRetrait + ", codePostalRetrait="
				+ codePostalRetrait + ", noArticle=" + noArticle + "]";
	}
	
	
}
