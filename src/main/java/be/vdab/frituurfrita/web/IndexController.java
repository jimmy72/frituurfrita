package be.vdab.frituurfrita.web;


import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class IndexController {
	@GetMapping 
	String index() { 
		int dagNummer = LocalDate.now().getDayOfWeek().getValue();
		return (dagNummer == 1 || dagNummer == 4) ? "Gesloten" : "Open";
	}
}
