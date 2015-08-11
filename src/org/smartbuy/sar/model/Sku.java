package org.smartbuy.sar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Sku {
	
	@Id
	@Column(name="SKU_NUMBER")
	private int skuNumber;
	
	@Column(name="SKU_DESC")
	private String skuDescription;
	
	@Column(name="SKU_TYPE")
	private String skuType;
	
	@Column(name="SKU_DETAILS")
	private String skuDetails;
	
	@Column(name="SPCL_MARKET")
	private String specialMarket;
	
	public Sku(){
		
	}
	
	public Sku(int skuNumber, String skuDescription, String skuType,
			String skuDetails, String specialMarket) {
		this.skuNumber = skuNumber;
		this.skuDescription = skuDescription;
		this.skuType = skuType;
		this.skuDetails = skuDetails;
		this.specialMarket = specialMarket;
	}
	
	public int getSkuNumber() {
		return skuNumber;
	}
	public void setSkuNumber(int skuNumber) {
		this.skuNumber = skuNumber;
	}
	public String getSkuDescription() {
		return skuDescription;
	}
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	public String getSkuType() {
		return skuType;
	}
	public void setSkuType(String skuType) {
		this.skuType = skuType;
	}
	public String getSkuDetails() {
		return skuDetails;
	}
	public void setSkuDetails(String skuDetails) {
		this.skuDetails = skuDetails;
	}
	public String getSpecialMarket() {
		return specialMarket;
	}
	public void setSpecialMarket(String specialMarket) {
		this.specialMarket = specialMarket;
	}

	@Override
	public String toString() {
		return "Sku [skuNumber=" + skuNumber + ", skuDescription="
				+ skuDescription + ", skuType=" + skuType + ", skuDetails="
				+ skuDetails + ", specialMarket=" + specialMarket + "]";
	}
	
	
}
