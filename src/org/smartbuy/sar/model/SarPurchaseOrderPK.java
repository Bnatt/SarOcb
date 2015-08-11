/**
 * 
 */
package org.smartbuy.sar.model;

import java.io.Serializable;

/**
 * @author User
 *
 */
public class SarPurchaseOrderPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String purchaseOrderNumber;
	protected int skuNumber;
	
	public SarPurchaseOrderPK(){}

	public SarPurchaseOrderPK(String purchaseOrderNumber, int skuNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.skuNumber = skuNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((purchaseOrderNumber == null) ? 0 : purchaseOrderNumber
						.hashCode());
		result = prime * result + skuNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SarPurchaseOrderPK other = (SarPurchaseOrderPK) obj;
		if (purchaseOrderNumber == null) {
			if (other.purchaseOrderNumber != null)
				return false;
		} else if (!purchaseOrderNumber.equals(other.purchaseOrderNumber))
			return false;
		if (skuNumber != other.skuNumber)
			return false;
		return true;
	}	
}	