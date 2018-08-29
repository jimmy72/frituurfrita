package be.vdab.frituurfrita.entities;

public class Saus {
	private Long nummer;
	private String naam;
	private String[] ingredienten;
	
	public Saus() {
		
	}
	
	public Saus(Long nummer, String naam, String[] ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
		this.ingredienten = ingredienten;
	}

	public Long getNummer() {
		return nummer;
	}

	public void setNummer(Long nummer) {
		this.nummer = nummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String[] getIngredienten() {
		return ingredienten;
	}

	public void setIngredienten(String[] ingredienten) {
		this.ingredienten = ingredienten;
	}
	
	
	
	
}
