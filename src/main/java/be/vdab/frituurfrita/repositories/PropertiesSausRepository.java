package be.vdab.frituurfrita.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import be.vdab.frituurfrita.entities.Saus;
import be.vdab.frituurfrita.exceptions.SausRepositoryException;

@Repository
@Order(1)
public class PropertiesSausRepository implements SausRepository {

	private final static Path PATH = Paths.get("D:\\files\\sauzen.properties");
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesSausRepository.class);
	
	public PropertiesSausRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Saus> findAll() {
		List<Saus> sauzen = new ArrayList<>();
		try(FileReader file = new FileReader(PATH.toFile());
			BufferedReader reader = new BufferedReader(file)){
			for(String line; (line = reader.readLine()) != null;) {
				if(! line.isEmpty()) {
					sauzen.add(makeSausOfString(line));
				}
			}
		}catch(IOException ex) {
			String fout = "Fout bij lezen " + PATH.toString();
			LOGGER.error(fout, ex);
			throw new SausRepositoryException(fout);
		}
		return sauzen;
	}
	
	private Saus makeSausOfString(String line) {
		
		String sauces[] = line.substring(0, line.indexOf(',')).split(":");
		String ingredients[] = line.substring(line.indexOf(',') + 1).split(",");
		
		if(sauces.length < 2) {
			String fout = PATH.toString() + ":" + line + " bevat minder dan 2 onderdelen (nummer & naam)";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
		}
		
		try {
			Saus saus = new Saus(Long.parseLong(sauces[0]), sauces[1]);
			Arrays.stream(ingredients).forEach(ingredient -> saus.addIngredient(ingredient));
			return saus;
		}catch(NumberFormatException ex) {
			String fout = PATH.toString() + ":" + line + " bevat verkeerde ID!";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
		}
		
	}

}
