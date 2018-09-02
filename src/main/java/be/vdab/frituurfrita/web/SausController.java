package be.vdab.frituurfrita.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.services.SausService;

@Controller
@RequestMapping("/sauzen")
class SausController {
	
	private static final String SAUZEN_JSP = "sauzen";
	private SausService sausService;
	
	public SausController(SausService sausService) {
		this.sausService = sausService;
	}
	
	@GetMapping
	ModelAndView sauzen() {
		return new ModelAndView(SAUZEN_JSP, "sauzen", sausService.findAll());
	}
}
