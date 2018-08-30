package be.vdab.frituurfrita.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("voorkeurtaal")
class HeaderController {

	private static final String JSP_FILE = "voorkeurtaal";
	
	@GetMapping
	ModelAndView voorkeurTaal(@RequestHeader("accept-language") String acceptLanguage) {
		return new ModelAndView(JSP_FILE,"voorkeurTaal", acceptLanguage.toLowerCase().contains("nl"));
	}
}
