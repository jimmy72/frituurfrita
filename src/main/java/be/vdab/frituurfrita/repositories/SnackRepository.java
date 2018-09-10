package be.vdab.frituurfrita.repositories;

import java.util.List;
import java.util.Optional;
import be.vdab.frituurfrita.entities.Snack;

public interface SnackRepository {
	Optional<Snack> read(long id);
	void update(Snack snack);
	List<Snack> findAll();
	List<Snack> findByBeginNaam(String beginNaam);
}
