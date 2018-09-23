package be.vdab.frituurfrita.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.frituurfrita.entities.Snack;
import be.vdab.frituurfrita.repositories.SnackRepository;

@Service
@Transactional(readOnly = true , isolation = Isolation.READ_COMMITTED)
public class DefaultSnackService implements SnackService{

	private SnackRepository snackRepository;
	
	
	public DefaultSnackService(SnackRepository snackRepository) {
		this.snackRepository = snackRepository;
	}

	@Override
	public Optional<Snack> read(long id) {
		return this.snackRepository.read(id);
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void update(Snack snack) {
		this.snackRepository.update(snack);
	}

	@Override
	public List<Snack> findByBeginNaam(String beginNaam) {
		return this.snackRepository.findByBeginNaam(beginNaam);
	}

	@Override
	public List<Snack> findAll() {
		return this.snackRepository.findAll();
	}
	
	/** 
	 * 
	 * @return List of characters of first letters of all snacks
	 */
	public List<Character> findDistinctBeginLetters(){
		return this.snackRepository.findAll().stream()
				.map(snack -> snack.getNaam().toUpperCase().charAt(0))
				.distinct()
				.collect(Collectors.toList());
	}
	
}
