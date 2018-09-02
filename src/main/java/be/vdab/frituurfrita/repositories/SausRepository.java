package be.vdab.frituurfrita.repositories;

import java.util.List;

import be.vdab.frituurfrita.entities.Saus;
import be.vdab.frituurfrita.exceptions.SausRepositoryException;

public interface SausRepository {
	public List<Saus> findAll();
}
