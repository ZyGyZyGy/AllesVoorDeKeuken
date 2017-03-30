package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "artikelgroepen")
public class ArtikelGroep implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @OneToMany(mappedBy = "artikelgroep")
    @OrderBy("naam")
    private Set<Artikel> artikels;

    public ArtikelGroep(String naam) {
	this.naam = naam;
    }

    public ArtikelGroep() {
    }

    public long getId() {
	return id;
    }

    public String getNaam() {
	return naam;
    }

    public Set<Artikel> getArtikels() {
	return Collections.unmodifiableSet(artikels);
    }
    
    public void add(Artikel artikel) {
	artikels.add(artikel);
	if (artikel.getArtikelgroep() != this) {
	    artikel.setArtikelgroep(this);
	}
    }
    
    public void remove(Artikel artikel) {
	artikels.remove(artikel);
	if (artikel.getArtikelgroep() == this) {
	    artikel.setArtikelgroep(null);
	}
    }
}









