package be.vdab.frituurfrita.web;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
	@GetMapping 
	ModelAndView index() { 
		String message;
		int dagNummer = LocalDate.now().getDayOfWeek().getValue();
		message = (dagNummer == 1 || dagNummer == 4) ? "Gesloten" : "Open";
		ModelAndView mv = new ModelAndView("index","message",message);
		return mv;
	}
}
