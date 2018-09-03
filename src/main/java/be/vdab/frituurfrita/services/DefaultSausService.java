package be.vdab.frituurfrita.services;

import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import be.vdab.frituurfrita.entities.Saus;
import be.vdab.frituurfrita.exceptions.SausRepositoryException;
import be.vdab.frituurfrita.repositories.SausRepository;

@Service
class DefaultSausService implements SausService {

	private final SausRepository[] sausRepositories;
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSausService.class);
	
	public DefaultSausService(SausRepository[] sausRepositories) {
		this.sausRepositories = sausRepositories;
	}
	
	@Override
	public List<Saus> findAll() {
		for (SausRepository sausRepository : sausRepositories) {
			try {
				return sausRepository.findAll();
			} catch (SausRepositoryException ex) {
			  LOGGER.error("kan sauzen niet lezen", ex);
			}
		}
		LOGGER.error("kan sauzen van geen enkele bron lezen"); 
		return null;
	}

	
}
