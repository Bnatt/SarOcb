/**
 * 
 */
package org.smartbuy.sar.dao;

import java.util.List;

import org.smartbuy.sar.model.SarParameter;
import org.smartbuy.sar.model.SkuStore;

/**
 * @author User
 *
 */
public interface SkuService {
	public List<SkuStore> getSkuForStore(int storeNumber);
	public int createPurchaseOrder(List<SkuStore> skuStoreList);
	public int calculateFinalOrderQuantity(SkuStore skuStore, SarParameter sarParameter);
	public int generatePurchaseOrderNumber();
}
