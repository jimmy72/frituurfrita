package be.vdab.frituurfrita.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.services.DefaultSnackService;
import be.vdab.frituurfrita.services.SnackService;

@Controller
@RequestMapping("snacks")
class SnacksController {
	private static final String SNACKS_VIEW = "snacks";
	private final SnackService snackService;
	private static final char[] ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	SnacksController(SnackService snackService) {
		this.snackService = snackService;
	}
	
	@GetMapping("alfabet")
	ModelAndView snacks() {
		return new ModelAndView(SNACKS_VIEW, "alfabet", ALFABET);
	}
	
	@GetMapping(params = "beginletter")
	ModelAndView snacksMetLetter(char beginletter) {
		return new ModelAndView(SNACKS_VIEW, "alfabet", ALFABET)
				.addObject("snacks", snackService.findByBeginNaam(String.valueOf(beginletter)));
	}
	
}
