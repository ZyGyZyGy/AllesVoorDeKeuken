package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FoodArtikel extends Artikel {

    private static final long serialVersionUID = 1L;
    private long houdbaarheid;

    public FoodArtikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs, long houdbaarheid, ArtikelGroep artikelGroep) {
	super(naam, aankoopprijs, verkoopprijs, artikelGroep);
	setHoudbaarheid(houdbaarheid);
    }

    protected FoodArtikel() {
    }

    public static boolean isHoudbaarheidValid(long houdbaarheid) {
	return houdbaarheid >= 1;
    }

    public long getHoudbaarheid() {
	return houdbaarheid;
    }

    public void setHoudbaarheid(long houdbaarheid) {
	if (!isHoudbaarheidValid(houdbaarheid)) {
	    throw new IllegalArgumentException();
	}
	this.houdbaarheid = houdbaarheid;
    }

}
