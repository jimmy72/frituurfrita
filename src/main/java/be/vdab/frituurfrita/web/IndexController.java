package be.vdab.frituurfrita.web;


import java.time.LocalDate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.valueobjects.Adres;
import be.vdab.frituurfrita.valueobjects.Gemeente;

@Controller
@RequestMapping("/")
class IndexController {
	@GetMapping 
	ModelAndView index(@CookieValue(name = "bezocht" , required = false) String bezocht, HttpServletResponse response) { 
		//Cookie instellen
		Cookie cookie = new Cookie("bezocht", "Ja");
		cookie.setMaxAge(31_536_000);
		response.addCookie(cookie);
		
		String message;
		int dagNummer = LocalDate.now().getDayOfWeek().getValue();
		message = (dagNummer == 1 || dagNummer == 4) ? "gesloten" : "open";
		ModelAndView mv = new ModelAndView("index","message",message);
		mv.addObject("frituur", new Adres("Genkersteenweg","285", new Gemeente("Hasselt", 3500)));
		//als er een cookie werd meegegeven als parameter van deze method dan hebben we de website reeds bezocht
		if(bezocht != null) {
			mv.addObject("bezocht", true);
		}
		return mv;
	}
}
