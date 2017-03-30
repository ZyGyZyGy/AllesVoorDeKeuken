package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.ArtikelGroep;

public class ArtikelGroepRepository extends AbstractRepository {

    public List<ArtikelGroep> findAll() {
	return getEntityManager()
		.createNamedQuery("ArtikelGroep.findAll", ArtikelGroep.class)
		.getResultList();
    }
    
    public Optional<ArtikelGroep> read(long id) {
	return Optional.ofNullable(
		getEntityManager().find(ArtikelGroep.class, id));
    }
}
