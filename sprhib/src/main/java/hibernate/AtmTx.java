package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "atx")
//@Table(name="Atmtxper")
public class AtmTx extends Tx {

	private int atm;

	
	public AtmTx() {}
	public AtmTx(double amount, int atm) {
		super(amount);
		this.atm = atm;
	}
	public int getAtm() {
		return atm;
	}
	public void setAtm(int atm) {
		this.atm = atm;
	}
	@Override
	public String toString() {
		return "AtmTx [getId()=" + getId() + ", getAmount()=" + getAmount() + "]";
	}
	
	
	
	
}
