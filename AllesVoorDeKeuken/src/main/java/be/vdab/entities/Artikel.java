package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Korting;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "artikels")
@DiscriminatorColumn(name = "soort")
public abstract class Artikel implements Serializable {

    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;
    
    @ElementCollection
    @CollectionTable(name = "kortingen",
    	joinColumns = @JoinColumn(name = "artikelid"))
    @OrderBy("vanafaantal")
    private Set<Korting> kortingen;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artikelgroepid")
    private ArtikelGroep artikelgroep;

    public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs, ArtikelGroep artikelGroep) {
	if (!isVerkoopprijsValid(verkoopprijs, aankoopprijs)) {
	    throw new IllegalArgumentException();
	}
	setNaam(naam);
	setAankoopprijs(aankoopprijs);
	setVerkoopprijs(verkoopprijs);
	setArtikelgroep(artikelGroep);
    }

    public Artikel() {

    }

    public long getId() {
	return id;
    }

    public String getNaam() {
	return naam;
    }

    public BigDecimal getAankoopprijs() {
	return aankoopprijs;
    }

    public BigDecimal getVerkoopprijs() {
	return verkoopprijs;
    }
    
    public Set<Korting> getKortingen() {
	return Collections.unmodifiableSet(kortingen);
    }

    public ArtikelGroep getArtikelgroep() {
        return artikelgroep;
    }

    public void setArtikelgroep(ArtikelGroep artikelgroep) { 
        if (this.artikelgroep != null && this.artikelgroep.getArtikels().contains(this)) {
	    this.artikelgroep.remove(this);
	}
        this.artikelgroep = artikelgroep;
        if (artikelgroep != null && !artikelgroep.getArtikels().contains(this)) {
	    artikelgroep.add(this);
	}
    }
    
    public BigDecimal getWinst() {
	return verkoopprijs.subtract(aankoopprijs).divide(aankoopprijs, 2, RoundingMode.HALF_UP)
		.multiply(BigDecimal.valueOf(100));
    }

    public static boolean isNaamValid(String naam) {
	return naam != null && !naam.isEmpty();
    }

    public static boolean isAankoopprijsValid(BigDecimal aankoopprijs) {
	return aankoopprijs != null && aankoopprijs.compareTo(BigDecimal.valueOf(0.01)) >= 0;
    }

    public static boolean isVerkoopprijsValid(BigDecimal verkoopprijs, BigDecimal aankoopprijs) {
	return verkoopprijs != null && verkoopprijs.compareTo(aankoopprijs) >= 0;
    }

    public void setNaam(String naam) {
	if (!isNaamValid(naam)) {
	    throw new IllegalArgumentException();
	}
	this.naam = naam;
    }

    public void setAankoopprijs(BigDecimal aankoopprijs) {
	if (!isAankoopprijsValid(aankoopprijs)) {
	    throw new IllegalArgumentException();
	}
	this.aankoopprijs = aankoopprijs;
    }

    public void setVerkoopprijs(BigDecimal verkoopprijs) {
	if (!isVerkoopprijsValid(verkoopprijs, verkoopprijs)) {
	    throw new IllegalArgumentException();
	}
	this.verkoopprijs = verkoopprijs;
    }

    @Override
    public int hashCode() {
	return naam.toUpperCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (!(obj instanceof Artikel))
	    return false;
	Artikel artikel = (Artikel) obj;
	return naam.equalsIgnoreCase(artikel.naam);
    }
    
}
//test

