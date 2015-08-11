/**
 * 
 */
package org.smartbuy.sar.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.smartbuy.sar.model.SarParameter;
import org.smartbuy.sar.model.SarPurchaseOrder;
import org.smartbuy.sar.model.SkuStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SkuServiceImpl implements SkuService {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(SkuServiceImpl.class);

	List<SkuStore> listOfSkuStore = new ArrayList<SkuStore>();

	/**
	 * Returns a list containing all the sku's for a given store number.
	 * 
	 * @param storeNumber
	 * @return list of sku's
	 */

	@SuppressWarnings("unchecked")
	public List<SkuStore> getSkuForStore(int storeNumber) {

		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from SkuStore where storeNumber=:storeNum");
		query.setInteger("storeNum", storeNumber);
		listOfSkuStore = query.list();
		logger.info("Sku list for the store successfully pulled from database.");
		return listOfSkuStore;
	}

	/**
	 * Compare the total quantity and recommended threshold values of sku's and
	 * create purchase order if necessary. Update SAR_PO table.
	 */
	public int createPurchaseOrder(List<SkuStore> skuStoreList) {

		int finalOrderQuantity = 0;
		int skusNeedToBeOrdered = 0;
		int poNumber = generatePurchaseOrderNumber();

		for (SkuStore skuStore : skuStoreList) {

			int skuNum = skuStore.getSkuNumber();
			SarParameter sarParm = (SarParameter) getSessionFactory()
					.getCurrentSession().get(SarParameter.class, skuNum);
			finalOrderQuantity = calculateFinalOrderQuantity(skuStore, sarParm);

			if (finalOrderQuantity > 0) {
				skusNeedToBeOrdered++;
				SarPurchaseOrder sarPO = new SarPurchaseOrder(
						String.valueOf(poNumber), skuNum,
						skuStore.getStoreNumber(), finalOrderQuantity, 0);
				getSessionFactory().getCurrentSession().save(sarPO);
			}
		}
		if (skusNeedToBeOrdered > 0)
			return poNumber;

		return -1;
	}

	/**
	 * Number of units to be ordered will be calculated by Velocity of SKU * No.
	 * of Days for truck to deliver it. Number of units should be in multiples
	 * of Pack Size. Number of units should be greater than vendor minimum
	 * quantities.
	 */
	public int calculateFinalOrderQuantity(SkuStore skuStore,
			SarParameter sarParameter) {

		int finalOrderQuantity = 0;
		int minUnitsRequired = 0;
		int minPacksRequired = 0;

		int totalQuantityInStore = skuStore.getInStoreQuantity()
				+ skuStore.getShelfQuantity();
		int vendorMin = sarParameter.getVendorMin();

		if (totalQuantityInStore < sarParameter.getSkuRecommendedThreshold()) {
			minUnitsRequired = Integer.parseInt(skuStore.getSkuVelocity())
					+ skuStore.getDeliveryTime();
			minPacksRequired = (int) Math.ceil(minUnitsRequired
					/ sarParameter.getPackSize());

			if (minPacksRequired > vendorMin)
				finalOrderQuantity = minPacksRequired;
			else
				finalOrderQuantity = vendorMin;
		} else {
			finalOrderQuantity = 0;
		}
		logger.info("Final order quantity calculated successfully." );
		return finalOrderQuantity;

	}

	public int generatePurchaseOrderNumber() {

		int lastPoNumber = (int) getSessionFactory().getCurrentSession()
				.createQuery("select lastPoNumber from PurchaseOrderNumber")
				.uniqueResult();
		int purchaseOrderNumber = lastPoNumber + 1;
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"update PurchaseOrderNumber set lastPoNumber=:lastPoNum");
		query.setInteger("lastPoNum", purchaseOrderNumber);
		query.executeUpdate();
		logger.info("New PO number generated successfully." );
		return purchaseOrderNumber;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}