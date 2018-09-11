package be.vdab.frituurfrita.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.entities.Snack;
import be.vdab.frituurfrita.services.SnackService;

@Controller
@RequestMapping("/snacks")
class SnacksController {
	private static final String SNACKS_VIEW = "snacks";
	private static final String SNACK_VIEW = "snack";
	private static final String BEGINLETTERS_VIEW = "beginletters";
	private final SnackService snackService;
	private static final char[] ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	SnacksController(SnackService snackService) {
		this.snackService = snackService;
	}
	
	@GetMapping("{id}") 
	ModelAndView snackDetail(@PathVariable long id) { 
		ModelAndView modelAndView = new ModelAndView(SNACK_VIEW);
		snackService.read(id).ifPresent(snack -> modelAndView.addObject("snack", snack));
		return modelAndView;
	}
	
	@GetMapping(path = "/alfabet")
	ModelAndView snacks() {
		return new ModelAndView(SNACKS_VIEW, "alfabet", ALFABET);
	}
	
	@GetMapping(path = "/alfabet", params = "beginletter")
	ModelAndView snacksMetLetter(char beginletter) {
		return new ModelAndView(SNACKS_VIEW, "alfabet", ALFABET)
				.addObject("snacks", snackService.findByBeginNaam(String.valueOf(beginletter)));
	}
	
	@GetMapping(path ="/beginletters")
	ModelAndView snacksMetBeginLetters() {
		BeginLettersForm form = new BeginLettersForm();
		return new ModelAndView(BEGINLETTERS_VIEW).addObject(form);
	}
	
	@GetMapping(path = "/beginletters", params = {"beginletters"}) 
	ModelAndView snacksMetBeginLetters(@Valid BeginLettersForm form, BindingResult bindingResult) { 
		ModelAndView modelAndView = new ModelAndView(BEGINLETTERS_VIEW);
		if(bindingResult.hasErrors()) {
			return modelAndView; 
		}
		List<Snack> snacks = snackService.findByBeginNaam(form.getBeginletters());
		if(snacks.isEmpty()) {
			bindingResult.reject("geenSnacks");
		}else {
			modelAndView.addObject("snacks", snacks);
		}
		return modelAndView;
	}
	
}
