package be.vdab.frituurfrita.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import be.vdab.frituurfrita.exceptions.JacksonControllerException;

@Controller
@RequestMapping("/jackson")
public class JacksonController {
	private static final String JACKSON_JSP = "jackson";
	//private static final String endpoint = "http://data.fixer.io/api/latest?access_key=3d0a4fecd7d5a53aa66487323c7dc519";
    private static URL url;
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonController.class);
    
    @GetMapping
    ModelAndView jackson() {
    	return new ModelAndView(JACKSON_JSP).addObject("usd", "firstvisit");
    }
    
	@GetMapping(params = {"endpoint"}) 
	ModelAndView getjackson(String endpoint) { 
		ModelAndView modelAndView = new ModelAndView(JACKSON_JSP);
		try {
			url = new URL(endpoint);
		} catch (MalformedURLException e) {
			String fout = "Er scheelt iets met de url";
			LOGGER.error(fout, e);
			throw new JacksonControllerException(fout);
		}
	      try (InputStream inputStream = url.openStream()){
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode usd = objectMapper
					.readValue(inputStream, JsonNode.class)
					.get("rates")
					.get("USD");
			modelAndView.addObject("usd", usd.asText());
		} catch (IOException | NullPointerException e) {
			String fout = "Er scheelt iets met de inputstream";
			LOGGER.error(fout, e);
			throw new JacksonControllerException(fout);
		}
		return modelAndView;
	}
}
