package be.vdab.frituurfrita.services;

import java.util.List;
import java.util.Optional;

import be.vdab.frituurfrita.entities.Snack;

public interface SnackService {
	public abstract Optional<Snack> read(long id);
	public abstract void update(Snack snack);
	List<Snack> findByBeginNaam(String beginNaam);
	List<Snack> findAll();
}
