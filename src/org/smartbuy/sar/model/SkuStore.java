package org.smartbuy.sar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sku_store")
public class SkuStore {
	
	@Id
	@Column(name="SKU_NUMBER")
	private int skuNumber;
	
	@Column(name="STORE_NUM")
	private int storeNumber;
	
	@Column(name="SKU_VELOCITY")
	private String skuVelocity;
	
	@Column(name="TRK_DLVR_TIME_DAYS")
	private int deliveryTime;
	
	@Column(name="SHELF_QTY")
	private int shelfQuantity;
	
	@Column(name="IN_STR_QTY")
	private int inStoreQuantity;
	
	public SkuStore(){
		
	}

	public SkuStore(int skuNumber, int storeNumber, String skuVelocity,
			int deliveryTime, int shelfQuantity, int inStoreQuantity) {
		this.skuNumber = skuNumber;
		this.storeNumber = storeNumber;
		this.skuVelocity = skuVelocity;
		this.deliveryTime = deliveryTime;
		this.shelfQuantity = shelfQuantity;
		this.inStoreQuantity = inStoreQuantity;
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

	public String getSkuVelocity() {
		return skuVelocity;
	}

	public void setSkuVelocity(String skuVelocity) {
		this.skuVelocity = skuVelocity;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getShelfQuantity() {
		return shelfQuantity;
	}

	public void setShelfQuantity(int shelfQuantity) {
		this.shelfQuantity = shelfQuantity;
	}

	public int getInStoreQuantity() {
		return inStoreQuantity;
	}

	public void setInStoreQuantity(int inStoreQuantity) {
		this.inStoreQuantity = inStoreQuantity;
	}

	@Override
	public String toString() {
		return "SkuStore [skuNumber=" + skuNumber + ", storeNumber="
				+ storeNumber + ", skuVelocity=" + skuVelocity
				+ ", deliveryTime=" + deliveryTime + ", shelfQuantity="
				+ shelfQuantity + ", inStoreQuantity=" + inStoreQuantity + "]";
	}
	
	
}
