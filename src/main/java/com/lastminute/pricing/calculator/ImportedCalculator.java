package com.lastminute.pricing.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.lastminute.Constants;
import com.lastminute.VO.CommerceItemVO;
import com.lastminute.VO.OrderVO;
import com.lastminute.VO.SkuVO;
import com.lastminute.pricing.CalculatorTools;

/**
 * Calculator to add the imported price
 * 
 * @author Manuel Moranchel
 *
 */
public class ImportedCalculator implements Calculator {
	
	static Logger logger = Logger.getLogger(ImportedCalculator.class.getName());

	@Override
	public OrderVO run(OrderVO order) {
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "Before calculating Imported taxes for order: " + order);
		}
		
		for (CommerceItemVO commerceItem : order.getCommerceItems()) {
			if (isCommerceItemImported(commerceItem.getsku())) {
				commerceItem.setTaxAmount(CalculatorTools.roundPrice(commerceItem.getQuantity() * (commerceItem.getTaxAmount() + importedTax(commerceItem))));
			}
			commerceItem.setTotalPrice(CalculatorTools.roundPrice(commerceItem.getTotalBasePrice() + commerceItem.getTaxAmount()));
		}
		
		if (logger.isLoggable(Level.FINE)) {
			logger.log(Level.FINE, "After calculating Imported taxes for order: " + order);
		}
		
		return order;
	}

	/**
	 * Calculate the tax for imported products
	 * 
	 * @param commerceItem
	 * @return
	 */
	protected double importedTax(CommerceItemVO commerceItem) {
		return commerceItem.getsku().getListPrice() * Constants.IMPORTED_TAX_PERCENTAGE;
	}

	/**
	 * Determine whether the sku is imported
	 * 
	 * @param getsku
	 * @return true if it is imported
	 */
	protected boolean isCommerceItemImported(SkuVO sku) {
		return sku.isImported();
	}

}
