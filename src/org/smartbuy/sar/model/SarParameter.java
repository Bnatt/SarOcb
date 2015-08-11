/**
 * 
 */
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
@Table(name="sar_parm")
public class SarParameter {
	
	@Id
	@Column(name="SKU_NUMBER")
	private int skuNumber;
	
	@Column(name="SKU_RCMD_THRD")
	private int skuRecommendedThreshold;
	
	@Column(name="TRK_DLVR_FACTOR")
	private int truckDeliveryFactor;
	
	@Column(name="PACK_SIZE")
	private int packSize;
	
	@Column(name="VENDR_MIN")
	private int vendorMin;
	
	@Column(name="SKU_MARKET")
	private String skuMarket;
	
	public SarParameter(){
		
	}

	public SarParameter(int skuNumber, int skuRecommendedThreshold,
			int truckDeliveryFactor, int packSize, int vendorMin,
			String skuMarket) {
		this.skuNumber = skuNumber;
		this.skuRecommendedThreshold = skuRecommendedThreshold;
		this.truckDeliveryFactor = truckDeliveryFactor;
		this.packSize = packSize;
		this.vendorMin = vendorMin;
		this.skuMarket = skuMarket;
	}

	public int getSkuNumber() {
		return skuNumber;
	}

	public void setSkuNumber(int skuNumber) {
		this.skuNumber = skuNumber;
	}

	public int getSkuRecommendedThreshold() {
		return skuRecommendedThreshold;
	}

	public void setSkuRecommendedThreshold(int skuRecommendedThreshold) {
		this.skuRecommendedThreshold = skuRecommendedThreshold;
	}

	public int getTruckDeliveryFactor() {
		return truckDeliveryFactor;
	}

	public void setTruckDeliveryFactor(int truckDeliveryFactor) {
		this.truckDeliveryFactor = truckDeliveryFactor;
	}

	public int getPackSize() {
		return packSize;
	}

	public void setPackSize(int packSize) {
		this.packSize = packSize;
	}

	public int getVendorMin() {
		return vendorMin;
	}

	public void setVendorMin(int vendorMin) {
		this.vendorMin = vendorMin;
	}

	public String getSkuMarket() {
		return skuMarket;
	}

	public void setSkuMarket(String skuMarket) {
		this.skuMarket = skuMarket;
	}

	@Override
	public String toString() {
		return "SarParameter [skuNumber=" + skuNumber
				+ ", skuRecommendedThreshold=" + skuRecommendedThreshold
				+ ", truckDeliveryFactor=" + truckDeliveryFactor
				+ ", packSize=" + packSize + ", vendorMin=" + vendorMin
				+ ", skuMarket=" + skuMarket + "]";
	}

	
}
