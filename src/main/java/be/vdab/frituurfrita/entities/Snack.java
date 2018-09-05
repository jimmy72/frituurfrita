package be.vdab.frituurfrita.entities;

import java.math.BigDecimal;

public class Snack {
	private long id;
	private String naam;
	private BigDecimal prijs;
	
	public Snack(String naam, BigDecimal prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}
	
	public Snack(long id, String naam, BigDecimal prijs) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	
}
