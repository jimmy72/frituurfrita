package be.vdab.frituurfrita.entities;

import java.util.ArrayList;
import java.util.List;

public class Saus {
	private Long nummer;
	private String naam;
	private List<String> ingredienten = new ArrayList<>();
	
	public Saus() {
		
	}
	
	public Saus(Long nummer, String naam) {
		this.setNummer(nummer);
		this.setNaam(naam);
	}
	
	public Saus(Long nummer, String naam, List<String> ingredienten) {
		this.setNummer(nummer);
		this.setNaam(naam);
		this.setIngredienten(ingredienten);
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

	public List<String> getIngredienten() {
		return ingredienten;
	}

	public void setIngredienten(List<String> ingredienten) {
		this.ingredienten.addAll(ingredienten);
	}
	
	public void addIngredient(String ingredient) {
		this.ingredienten.add(ingredient);
	}
	
	
}
