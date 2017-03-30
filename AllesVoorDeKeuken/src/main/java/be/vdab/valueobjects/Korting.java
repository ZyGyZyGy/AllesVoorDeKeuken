package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Korting implements Serializable {

    private static final long serialVersionUID = 1L;
    private long vanafAantal;
    private BigDecimal kortingsPercentage;

    public Korting(long vanafAantal, BigDecimal kortingsPercentage) {
	this.vanafAantal = vanafAantal;
	this.kortingsPercentage = kortingsPercentage;
    }

    public Korting() {
    }

    public long getVanafAantal() {
	return vanafAantal;
    }

    public BigDecimal getKortingsPercentage() {
	return kortingsPercentage;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((kortingsPercentage == null) ? 0 : kortingsPercentage.hashCode());
	result = prime * result + (int) (vanafAantal ^ (vanafAantal >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (!(obj instanceof Korting)) {
	    return false;
	}
	Korting korting = (Korting) obj;
	return vanafAantal == korting.vanafAantal 
		&& kortingsPercentage.equals(korting.kortingsPercentage);
    }
    
    

}
















