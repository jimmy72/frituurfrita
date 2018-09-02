package be.vdab.frituurfrita.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.frituurfrita.entities.Saus;
import be.vdab.frituurfrita.repositories.SausRepository;

@Service
class DefaultSausService implements SausService {

	private final SausRepository sausRepository;
	
	public DefaultSausService(SausRepository sausRepository) {
		this.sausRepository = sausRepository;
	}
	
	@Override
	public List<Saus> findAll() {
		// TODO Auto-generated method stub
		return sausRepository.findAll();
	}

	
}
