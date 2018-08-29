package be.vdab.frituurfrita.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.entities.Saus;

@Controller
@RequestMapping("/sauzen")
class SausController {
	
	private static final String SAUS_VIEW = "sauzen";
	private final List<Saus> sauzen = Arrays.asList(
			new Saus(1L,"cocktail", new String[] {"mayonaise", "ketchup", "whisky", "peper", "zout"}),
			new Saus(6L,"mayonaise", new String[] {"ei", "mosterd", "olie", "Peper", "Zout"}),
			new Saus(7L,"mosterd", new String[] {"mosterd", "azijn", "witte wijn"}),
			new Saus(12L,"tartare", new String[] {"mayonaise", "augurk", "tabasco"}),
			new Saus(44L,"vinaigrette", new String[] {"olijfolie", "mosterd", "azijn"})
			);
	
	@GetMapping
	ModelAndView sauzen() {
		return new ModelAndView(SAUS_VIEW, "sauzen", sauzen);
	}
}
