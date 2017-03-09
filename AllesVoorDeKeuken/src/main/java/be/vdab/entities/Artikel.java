package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikels")
public class Artikel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;

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

    public BigDecimal getWinst() {
	return verkoopprijs.subtract(aankoopprijs)
		.divide(aankoopprijs, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }

}
