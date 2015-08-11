package org.smartbuy.sar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@IdClass(SarPurchaseOrderPK.class)
@Table(name="sar_po")
public class SarPurchaseOrder {
	
	@Id
	@Column(name="PO_NUMBER")
	private String purchaseOrderNumber;
	
	@Id
	@Column(name="SKU_NUMBER")
	private int skuNumber;
	
	@Column(name="STR_NUMBER")
	private int storeNumber;
	
	@Column(name="ORDER_QTY")
	private int orderQuantity;
	
	@Column(name="IS_APPROVED")
	private int isApproved;

	public SarPurchaseOrder(){
		
	}	
	
	public SarPurchaseOrder(String purchaseOrderNumber, int skuNumber,
			int storeNumber, int orderQuantity, int isApproved) {
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.skuNumber = skuNumber;
		this.storeNumber = storeNumber;
		this.orderQuantity = orderQuantity;
		this.isApproved = 0;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public int getSkuNumber() {
		return skuNumber;
	}

	public void setSkuNumber(int skuNumber) {
		this.skuNumber = skuNumber;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "SarPurchaseOrder [purchaseOrderNumber=" + purchaseOrderNumber
				+ ", skuNumber=" + skuNumber + ", storeNumber=" + storeNumber
				+ ", orderQuantity=" + orderQuantity + ", isApproved="
				+ isApproved + "]";
	}
	
}