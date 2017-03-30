package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.ArtikelGroep;
import be.vdab.repositories.ArtikelGroepRepository;

public class ArtikelGroepService extends AbstractService {

    private final ArtikelGroepRepository artikelGroepRepository = new ArtikelGroepRepository();
    
    public List<ArtikelGroep> findAll() {
	return artikelGroepRepository.findAll();
    }
    
    public Optional<ArtikelGroep> read(long id) {
	return artikelGroepRepository.read(id);
    }
}
