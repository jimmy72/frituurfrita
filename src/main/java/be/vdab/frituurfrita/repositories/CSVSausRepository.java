package be.vdab.frituurfrita.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import be.vdab.frituurfrita.entities.Saus;
import be.vdab.frituurfrita.exceptions.SausRepositoryException;

@Repository
@Order(2)
class CSVSausRepository implements SausRepository {

	private final static Path PATH = Paths.get("D:\\files\\sauzen.csv");
	private static final Logger LOGGER = LoggerFactory.getLogger(CSVSausRepository.class);
	
	public CSVSausRepository() {
		
	}
	
	private Saus makeSausOfString(String line) {
		String[] pieces = line.split(",");
		if(pieces.length < 2) {
			String fout = PATH.toString() + ":" + line + " bevat minder dan 2 onderdelen";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
		}
		
		try {
			Saus saus = new Saus(Long.parseLong(pieces[0]), pieces[1]);
			for(int i=2; i<pieces.length;i++) {
				saus.addIngredient(pieces[i]);
			}
			return saus;
		}catch(NumberFormatException ex) {
			String fout = PATH.toString() + ":" + line + " bevat verkeerde ID!";
			LOGGER.error(fout);
			throw new SausRepositoryException(fout);
		}
		
	}
	
	@Override
	public List<Saus> findAll() {
		List<Saus> sauzen = new ArrayList<>();
		try(FileReader file = new FileReader(PATH.toFile());
			BufferedReader reader = new BufferedReader(file)){
			String line = null;
			while((line = reader.readLine()) != null) {
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

}
