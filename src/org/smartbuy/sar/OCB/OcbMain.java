package org.smartbuy.sar.OCB;

import java.util.List;

import org.apache.log4j.Logger;
import org.smartbuy.sar.dao.SkuService;
import org.smartbuy.sar.mail.SendMail;
import org.smartbuy.sar.model.SkuStore;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author User
 *
 */
public class OcbMain {

	/**
	 * @param args
	 */
	private static final Logger logger = Logger.getLogger(OcbMain.class);

	public static void main(String[] args) {

		int storeNumber = 2894;
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		SkuService skuService = context.getBean("skuServiceImpl",
				SkuService.class);
		List<SkuStore> skuStoreList = skuService.getSkuForStore(storeNumber);
		logger.info("skuStoreList generated");

		int poNum = skuService.createPurchaseOrder(skuStoreList);
		SendMail email = null;

		if (poNum != -1) {
			email = context.getBean("sendMail", SendMail.class);
			email.sendMail(poNum, storeNumber);
		}

		logger.info("Mail sent to store manager");
		context.close();

	}
}