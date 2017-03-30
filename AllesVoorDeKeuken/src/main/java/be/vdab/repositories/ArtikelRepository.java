package be.vdab.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;

public class ArtikelRepository extends AbstractRepository {

    public Optional<Artikel> read(long id) {
	EntityManager manager=getEntityManager();
	Artikel artikel=manager.find(Artikel.class, id);
	return Optional.ofNullable(artikel);
    }

    public void create(Artikel artikel) {
	getEntityManager().persist(artikel);
    }

    public void delete(long id) {
	read(id).ifPresent(artikel -> getEntityManager().remove(artikel));
    }
    
    public List<Artikel> findByWoord(String woord) {
	return getEntityManager()
		.createNamedQuery("Artikel.findByWoord", Artikel.class)
		.setParameter("woord", '%' + woord + '%')
		.getResultList();
    }
    
    public void prijsverhoging(BigDecimal factor) {
	getEntityManager()
		.createNamedQuery("Artikel.prijsverhoging")
		.setParameter("factor", factor)
		.executeUpdate();
    }
    
    public List<Artikel> findAll() {
	return getEntityManager()
		.createNamedQuery("Artikel.findAll", Artikel.class)
		.getResultList();
    }

}
