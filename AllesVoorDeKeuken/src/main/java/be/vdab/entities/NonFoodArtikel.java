package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NF")
public class NonFoodArtikel extends Artikel {

    private static final long serialVersionUID = 1L;
    private long garantie;

    public NonFoodArtikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs, long garantie, ArtikelGroep artikelGroep) {
	super(naam, aankoopprijs, verkoopprijs, artikelGroep);
	setGarantie(garantie);
    }

    protected NonFoodArtikel() {
    }

    public static boolean isGarantieValid(long garantie) {
	return garantie >= 0;
    }

    public long getGarantie() {
	return garantie;
    }

    public void setGarantie(long garantie) {
	if (!isGarantieValid(garantie)) {
	    throw new IllegalArgumentException();
	}
	this.garantie = garantie;
    }

}
