package org.smartbuy.sar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "PO_NUMBER")
public class PurchaseOrderNumber {

	@Id
	@Column(name = "LAST_PO_NUM")
	private int lastPoNumber;

	public int getLastPoNumber() {
		return lastPoNumber;
	}

	public void setLastPoNumber(int lastPoNumber) {
		this.lastPoNumber = lastPoNumber;
	}
}