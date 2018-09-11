package be.vdab.frituurfrita.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

class BeginLettersForm {
	
	@NotBlank @NotEmpty
	private String beginletters;

	public String getBeginletters() {
		return beginletters;
	}

	public void setBeginletters(String beginletters) {
		this.beginletters = beginletters;
	}

}
