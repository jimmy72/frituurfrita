package be.vdab.frituurfrita.web;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.valueobjects.Adres;
import be.vdab.frituurfrita.valueobjects.Gemeente;

@Controller
@RequestMapping("/")
class IndexController {
	@GetMapping 
	ModelAndView index() { 
		String message;
		int dagNummer = LocalDate.now().getDayOfWeek().getValue();
		message = (dagNummer == 1 || dagNummer == 4) ? "gesloten" : "open";
		ModelAndView mv = new ModelAndView("index","message",message);
		mv.addObject("frituur", new Adres("Genkersteenweg","285", new Gemeente("Hasselt", 3500)));
		return mv;
	}
}
